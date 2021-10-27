package com.genuinegames.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.genuinegames.entity.User;
import com.genuinegames.service.IUserService;

@Controller
public class AnonController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/auth/login")
	public String loginUser(Model model) {
		model.addAttribute("user", new User());
		return "/auth/login";	
	}
	
	@GetMapping("/auth/register")
	public String registroForm(Model model) {
		model.addAttribute("user", new User());
		return "/auth/register";
	}
	
	@PostMapping("/auth/register")
	public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/auth/register";
		} else {
			model.addAttribute("user", userService.registerUser(user));
		}
		
		return "redirect:/auth/login";
	}
	
}
