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

import com.genuinegames.entity.Answer;
import com.genuinegames.entity.Comments;
import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.entity.Valorar;
import com.genuinegames.repository.AnswerRepository;
import com.genuinegames.repository.CommentRepository;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.repository.ValorarRepository;
import com.genuinegames.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private ValorarRepository valorarRepository;
	
	@Autowired
	private IUserService iUserService;

	/* SETTINGS */
	@GetMapping("/user/ajustes")
	public String ajustes(ModelMap model, HttpSession session) {
		model.put("user", session.getAttribute("user"));
		model.put("games", gameRepository.findAll());
		return "user/ajustes";
	}

	@GetMapping("/user/perfil")
	public String perfil(HttpSession session, ModelMap model) {
		User usuario = (User) session.getAttribute("user");

		model.put("user", session.getAttribute("user"));
		model.put("comments", commentRepository.findByUser(usuario));
		model.put("games", gameRepository.findAll());

		return "user/perfil";
	}

	/* OPINION GAMES */
	@GetMapping("/user/infoGame/{name}")
	public String opinion(HttpSession session, ModelMap model, @PathVariable String name) {
		Game game = gameRepository.findByName(name);

		model.put("games", gameRepository.findAll());
		model.put("gamers", gameRepository.findByName(name));
		model.put("comments", commentRepository.findByGame(game));
		model.put("answers", answerRepository.findAll());
		model.put("points", valorarRepository.findAll());
		model.put("users", session.getAttribute("user"));
		return "user/infoGame";
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

		return "redirect:user/index";
	}
	
	@PostMapping("/user/answer")
	public String answerGame(HttpSession session, @RequestParam("texto") String text,
			@RequestParam("comment") Long comments, ModelMap model, Long id) {
		User user = (User) session.getAttribute("user");
		Comments comment = commentRepository.findByid(comments);

		Answer answer = new Answer();
		answer.setUser(user);
		answer.setText(text);
		answer.setComment(comment);

		model.put("games", gameRepository.findAll());
		model.put("user", session.getAttribute("user"));

		new ResponseEntity<>(iUserService.createAnswer(answer), HttpStatus.OK);

		return "redirect:user/index";
	}
	
	@GetMapping("/user/categoria/{name}")
	public String categoriaGame(HttpSession session,@PathVariable String name, ModelMap model) {
		model.put("games", gameRepository.findAll());
		model.put("gamer", gameRepository.findAllByCategory(name));
		return "user/index";
	}
	
	@GetMapping("/user/infogame/valoration/{valor}/{name}")
	public String valoration(HttpSession session,@PathVariable int valor,@PathVariable String name, ModelMap model) {
		User user=(User)session.getAttribute("user");
		Game game=gameRepository.findByName(name);
		int votes=game.getVotes();
		float punct=(game.getPunctuation()!=null)?game.getPunctuation():0;
		punct=(punct*votes)+valor;
		punct=punct/(votes+1);
		game.setPunctuation(punct);
		game.setVotes(votes+1);
		Valorar valorar= new Valorar();
		valorar.setPuntuacion(valor);
		valorar.setPunG(game);
		valorar.setPunU(user);
		new ResponseEntity<>(iUserService.puntuar(valorar), HttpStatus.OK);
		model.put("games", gameRepository.findAll());
		model.put("gamers", gameRepository.findByName(name));
		model.put("comments", commentRepository.findByGame(game));
		model.put("answers", answerRepository.findAll());
		return "redirect:user/infoGame/"+name+"?";
	}

}