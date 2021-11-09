package com.genuinegames.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.service.IGameService;
import com.genuinegames.service.IUserService;

@Controller
public class AdminController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IGameService iGameService;
	
	@Autowired
	private GameRepository gameRepository;
	
	/* REGISTER ADMIN */
	@PostMapping("/auth/register/admin")
	public String addUserAdmin(@RequestBody User user, Model model) {
		model.addAttribute("user", iUserService.registerAdmin(user));
		return "redirect:/auth/login";
	}
	
	/* GAMES */
	@GetMapping("/user/admin/getAllGame")
	public String getAllGame(Long id, ModelMap model) {
		model.put("games", gameRepository.findAll());
		return "/user/admin/getAllGame";
	}
	
	@GetMapping("/user/admin/createGame")
	public String createGame() {
		return "/user/admin/createGame";
	}
	
	@PostMapping("/user/admin/createGame")
	public void createGame(@RequestBody Game game){
		new ResponseEntity<>(iGameService.createGame(game), HttpStatus.OK);
	}
	
	@GetMapping("/user/admin/deleteGame")
	public String deleteGame() {
		return "/user/admin/deleteGame";
	}
	
	@PostMapping("/user/admin/deleteGame")
	public String deleteGame(Long id) {
		new ResponseEntity<>(iGameService.deleteGame(id), HttpStatus.OK);
		return "redirect:/user/index";
	}
	
	@GetMapping("/user/admin/updateGame")
	public String updateGame(ModelMap model) {
		return "/user/admin/updateGame";
	}
	
	@PostMapping("/user/admin/updateGame")
	public String updateGame(Long id, Game game) {
		new ResponseEntity<>(iGameService.updateGame(id, game), HttpStatus.OK);
		return "redirect:/user/index";
	}

}
	
