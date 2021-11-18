package com.genuinegames.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/ajustes")
	public String ajustes() {
		return "/user/ajustes";
	}

	@GetMapping("/user/perfil")
	public String perfil(HttpSession session, ModelMap model) {
		model.put("user", session.getAttribute("user"));
		return "/user/perfil";
	}

}
