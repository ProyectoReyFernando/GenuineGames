package com.genuinegames.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.genuinegames.entity.Comments;
import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.repository.CommentRepository;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private IUserService iUserService;

	/* SETTINGS */
	@GetMapping("/user/ajustes")
	public String ajustes(ModelMap model, HttpSession session) {
		model.put("user", session.getAttribute("user"));
		return "/user/ajustes";
	}

	/* PROFILE */
	/* UPDATE USER */
	/* @PostMapping("/user/ajustes")
	public String intermedio(HttpSession session, ModelMap model, @RequestParam("user") String user) {
		return "/user/perfil";
	}*/

	@GetMapping("/user/perfil")
	public String perfil(HttpSession session, ModelMap model) {
		User usuario = (User) session.getAttribute("user");

		model.put("user", session.getAttribute("user"));
		model.put("comments", commentRepository.findByUser(usuario));

		return "/user/perfil";
	}

	/* OPINION GAMES */
	@GetMapping("/user/infoGame/{name}")
	public String opinion(HttpSession session, ModelMap model, @PathVariable String name) {
		Game game = gameRepository.findByName(name);

		model.put("games", gameRepository.findByName(name));
		model.put("comments", commentRepository.findByGame(game));
		
		return "/user/infoGame";
	}

	@PostMapping("/user/comment")
	public String commentGame(HttpSession session, @RequestParam("texto") String text,
			@RequestParam("nombre") String name, ModelMap model, Long id) {
		User user = (User) session.getAttribute("user");
		Game game = gameRepository.findByName(name);

		Comments comment = new Comments();
		comment.setUser(user);
		comment.setText(text);
		comment.setGame(game);

		model.put("games", gameRepository.findAll());
		model.put("user", session.getAttribute("user"));

		new ResponseEntity<>(iUserService.createComment(comment), HttpStatus.OK);

		return "redirect:/user/perfil";
	}
	
	@GetMapping("/user/categoria/{name}")
	public String categoriaGame(HttpSession session,@PathVariable String name, ModelMap model) {
		model.put("games", gameRepository.findAll());
		model.put("gamer", gameRepository.findAllByCategory(name));
		return "/user/index";
	}

}