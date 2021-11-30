package com.genuinegames.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.exception.DangerException;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.repository.UserRepository;
import com.genuinegames.service.IGameService;
import com.genuinegames.service.IUserService;

@Controller
public class AdminController {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IGameService iGameService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	/* REGISTER ADMIN */
	@PostMapping("/auth/register/admin")
	public String addUserAdmin(@RequestBody User user, Model model) {
		model.addAttribute("user", iUserService.registerAdmin(user));
		return "redirect:/auth/login";
	}

	/* USERS */
	@GetMapping("/user/adminPanel/getAllUser")
	public String getAllUser(Long id, ModelMap model) {
		model.put("user", userRepository.findAll());
		return "/user/adminPanel/getAllUser";
	}
	
	@GetMapping("/user/adminPanel/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		new ResponseEntity<>(iUserService.deleteUser(id), HttpStatus.OK);
		return "redirect:/user/adminPanel/getAllUser";
	}

	/* GAMES */
	@GetMapping("/user/admin/getAllGame")
	public String getAllGame(Long id, ModelMap model) {
		model.put("games", gameRepository.findAll());
		return "/user/admin/getAllGame";
	}

	// CREATE
	@GetMapping("/user/admin/createGame")
	public String createGame() {
		return "/user/admin/createGame";
	}

	@PostMapping("/user/admin/createGame")
	public void createGame(@RequestBody Game game) throws DangerException {
		new ResponseEntity<>(iGameService.createGame(game), HttpStatus.OK);
	}

	// DELETE
	@GetMapping("/user/admin/deleteGame/{id}")
	public String deleteGame(@PathVariable Long id) {
		new ResponseEntity<>(iGameService.deleteGame(id), HttpStatus.OK);
		return "redirect:/user/admin/getAllGame";
	}

	// UPDATE
	@GetMapping("/user/admin/updateGame/{id}")
	public String updateGame(@PathVariable Long id, ModelMap model) {
		model.addAttribute("game", gameRepository.findById(id));
		return "/user/admin/updateGame";
	}

	@PostMapping("/user/admin/updateGame/{id}")
	public String updateGame(Long id, Game game) {
		new ResponseEntity<>(iGameService.updateGame(id, game), HttpStatus.OK);
		return "redirect:/user/admin/getAllGame";
	}

	/* UPLOAD IMAGE */
	@GetMapping("/user/admin/uploadImage/{id}")
	public String uploadImage(@PathVariable Long id, ModelMap model) {
		model.addAttribute("game", gameRepository.findById(id));
		return "/user/admin/uploadImage";
	}

	@PostMapping("/user/admin/uploadImage")
	public String uploadImage(@RequestPart("file") MultipartFile img, Game game) {
		if (!img.isEmpty()) {
			Path directory = Paths.get("src//main//resources//static/img/");
			String absoluteRute = directory.toFile().getAbsolutePath();

			try {
				byte[] bytes = img.getBytes();
				Path completeRute = Paths.get(absoluteRute + "//" + img.getOriginalFilename());
				Files.write(completeRute, bytes);

				game.setImg(img.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}

			gameRepository.save(game);
		}

		return "redirect:/user/admin/getAllGame";
	}

}
