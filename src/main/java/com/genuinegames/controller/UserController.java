package com.genuinegames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genuinegames.dto.UserDTO;
import com.genuinegames.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserDTO userDtoRegistration() {
		return new UserDTO();
	}

	@GetMapping
	public String loadRegister(ModelMap model) {
		model.addAttribute("user", new UserDTO());
		return "registration";
	}
	
	@PostMapping
	public String registerNewUser(@ModelAttribute("user") UserDTO userDTO) {
		userService.saveUser(userDTO);
		return "redirect:/login";
	}
}
