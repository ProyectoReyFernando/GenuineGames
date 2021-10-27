package com.genuinegames.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinegames.entity.User;
import com.genuinegames.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String index(Authentication auth, HttpSession session) {
		
		String username = auth.getName();
		
		if(session.getAttribute("user") == null) {
			User user = userService.findByUsername(username);
			user.setPwd(null);
			session.setAttribute("user", user);
		}
		
		return "/user/index";
	}
}
