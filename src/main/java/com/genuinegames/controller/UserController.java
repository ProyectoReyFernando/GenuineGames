package com.genuinegames.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinegames.entity.Game;
import com.genuinegames.repository.GameRepository;

@Controller
public class UserController {
	private GameRepository Gamerepository;

	@GetMapping("/user/ajustes")
	public String ajustes() {
		return "/user/ajustes";
	}

	@GetMapping("/user/perfil")
	public String perfil() {
		return "/user/perfil";
	}

}
