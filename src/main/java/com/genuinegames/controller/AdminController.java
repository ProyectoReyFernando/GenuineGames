package com.genuinegames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinegames.entity.User;
import com.genuinegames.service.IUserService;

@Controller
public class AdminController {
	
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/auth/register/admin")
	public String addUserAdmin(@RequestBody User user, Model model) {
		model.addAttribute("user", iUserService.registerAdmin(user));
		return "redirect:/auth/login";
	}
	
}
	
