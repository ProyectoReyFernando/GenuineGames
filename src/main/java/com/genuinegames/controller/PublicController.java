package com.genuinegames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("/user/inicio")
	public String index() {
		return "logout";
	}
}
