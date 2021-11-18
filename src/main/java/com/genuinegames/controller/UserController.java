package com.genuinegames.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.repository.UserRepository;
import com.genuinegames.service.UserService;

@Controller
public class UserController {
	private GameRepository Gamerepository;
	private UserRepository Userrepository;

	@GetMapping("/user/ajustes")
	public String ajustes() {
		return "/user/ajustes";
	}

	@GetMapping("/user/perfil")
	public String perfil(HttpSession session, ModelMap model) {
		User patata=(User) session.getAttribute("id");
		return "/user/perfil";
	}

}
