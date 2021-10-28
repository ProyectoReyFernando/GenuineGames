package com.genuinegames.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.genuinegames.entity.User;
import com.genuinegames.repository.UserRepository;
import com.genuinegames.service.IUserService;
import com.genuinegames.service.UserService;

@Controller
public class AnonController {

	@Autowired
	private UserService userService;

	@Autowired
	private IUserService iUserService;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
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
		model.addAttribute("user", new User());
		return "/auth/login";
	}

	@GetMapping("/user/index")
	public String userIndex(Authentication auth, HttpSession session) {

		String username = auth.getName();
		
		if (session.getAttribute("user") == null
				&& auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
			User user = userService.findByUsername(username);
			user.setPwd(null);
			session.setAttribute("user", user);
		}
		
		return "user/index";
	}

}
