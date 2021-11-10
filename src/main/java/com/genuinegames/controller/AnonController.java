package com.genuinegames.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.service.IUserService;
import com.genuinegames.service.UserService;

@Controller
public class AnonController {

	@Autowired
	private UserService userService;
	@Autowired
	private GameRepository Gamerepository;

	@Autowired
	private IUserService iUserService;

	@GetMapping("/")
	public String index() {
		return "/index";
	}

	@GetMapping("/auth/register")
	public String registroForm(Model model) {
		model.addAttribute("user", new User());
		return "/auth/register";
	}

	@PostMapping("/auth/register")
	public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/auth/register";
		} else {
			model.addAttribute("user", iUserService.registerUser(user));
		}

		return "redirect:/auth/login";
	}

	@GetMapping("/auth/login")
	public String loginUser(Model model) {
		return "/auth/login";
	}

	@GetMapping("/user/index")
	public String userIndex(Authentication auth, HttpSession session, ModelMap model) {

		String username = auth.getName();
		String redirect = null;
		model.put("games", Gamerepository.findAll());
		
		if (session.getAttribute("user") == null) {
			User user = userService.findByUsername(username);
			user.setPwd(null);
			session.setAttribute("user", user);
			redirect = "/user/index";
		} 
		
		return redirect;
	}
	
	@PostMapping("/logout")
	public String logout() {
		return "/";
	}

}
