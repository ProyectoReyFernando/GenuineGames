package com.genuinegames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/ajustes")
	public String ajustes() {
		return "/user/ajustes";
	}
	
}
