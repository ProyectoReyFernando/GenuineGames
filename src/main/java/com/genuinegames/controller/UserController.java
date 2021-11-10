package com.genuinegames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.genuinegames.entity.User;
import com.genuinegames.repository.UserRepository;

@Controller
public class UserController {

	@GetMapping("/user/ajustes")
	public String ajustes() {
		return "/user/ajustes";
	}
	
	@GetMapping("/user/perfil")
		public String perfil() {
		return "/user/perfil";
	}
	
}
