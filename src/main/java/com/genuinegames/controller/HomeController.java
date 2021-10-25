package com.genuinegames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class HomeController {

	@GetMapping
	public String login() {
		return "login";
	}
	
	@GetMapping("/user")
	public String validateUser(HttpServletRequest request) {
		String redirect = "";
		
		try {
			if(request.isUserInRole("ROLE_USER")) {
				redirect = "user/index";
			}
		} catch (Exception io) {
			io.printStackTrace();
		}

		return redirect;
	}
	
	@GetMapping("/admin")
	public String validateAdmin() {
		
		String redirect = "";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		try {
			if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
				redirect = "admin/index";
			}
		} catch (Exception io) {
			io.printStackTrace();
		}

		return redirect;
	}
		
}
