package com.genuinegames.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.genuinegames.entity.User;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.repository.UserRepository;
import com.genuinegames.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/ajustes")
	public String ajustes(ModelMap model, HttpSession session) {
		model.put("user", session.getAttribute("user"));
		return "/user/ajustes";
	}

	@GetMapping("/user/perfil")
	public String perfil(HttpSession session, ModelMap model) {
		model.put("user", session.getAttribute("user"));
		return "/user/perfil";
	}

	@GetMapping("/user/opinion/{name}")
	public String opinion(HttpSession session, ModelMap model, @PathVariable String name) {
		model.put("games", gameRepository.findByName(name));
		return "/user/opinion";
	}

	@PostMapping("/user/updateDataUser")
	public String intermedio(HttpSession session, ModelMap model, @RequestParam("user") String user) {
		User usuario = (User) session.getAttribute("user");
		
		if (user != null) {
			usuario.setUsername(user);
		}

		userRepository.save(usuario);
		model.put("user", session.getAttribute("user"));
		return "/user/perfil";
	}
}