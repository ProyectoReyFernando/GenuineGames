package com.genuinegames.service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.genuinegames.entity.Answer;
import com.genuinegames.entity.Comments;
import com.genuinegames.entity.Game;
import com.genuinegames.entity.Role;
import com.genuinegames.entity.User;
import com.genuinegames.entity.Valorar;
import com.genuinegames.repository.AnswerRepository;
import com.genuinegames.repository.CommentRepository;
import com.genuinegames.repository.GameRepository;
import com.genuinegames.repository.UserRepository;
import com.genuinegames.repository.ValorarRepository;

/**
 * @author CGonz
 *
 */
@Service
public class UserService implements IUserService, IGameService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private ValorarRepository valorarRepository;


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User registerAdmin(User user) {
		HashSet<Role> role = new HashSet<>();

		Role roleAdmin = new Role();
		roleAdmin.setName("ADMIN");
		role.add(roleAdmin);

		String pwd = user.getPwd();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPwd(encryptPwd);
		user.setRole(roleAdmin);

		return userRepository.save(user);
	}

	@Override
	public User registerUser(User user) {
		Set<Role> role = new HashSet<Role>();

		Role roleUser = new Role();
		roleUser.setName("USER");
		role.add(roleUser);

		user.setPwd(passwordEncoder.encode(user.getPwd()));
		user.setRole(roleUser);

		return userRepository.save(user);
	}

	@Override
	public String updateUser(Long id, User user) {
		if (userRepository.findById(id).isPresent()) {
			user.setUsername(user.getUsername());
			user.setPwd(passwordEncoder.encode(user.getPwd()));
			userRepository.save(user);
			return "redirect:/";
		} else {
			return "No se pudo realizar la acción";
		}
	}

	public String deleteUser(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "redirect:/";
		} else {
			return "No se pudo realizar la acción";
		}
	}

	// GAMES
	@Override
	public Game createGame(Game game) {
		return gameRepository.save(game);
	}

	@Transactional
	@Override
	public String deleteGame(Long id) {
		if (gameRepository.findById(id).isPresent()) {
			gameRepository.deleteById(id);
			return "redirect:/";
		} else {
			return "No se pudo realizar la acción";
		}
	}

	@Override
	public String updateGame(Long id, Game game) {
		if (gameRepository.findById(id).isPresent()) {
			game.setName(game.getName());
			gameRepository.save(game);
			return "redirect:/";
		} else {
			return "No se pudo realizar la acción";
		}
	}

	@Override
	public Game findByGameName(String game) {
		return gameRepository.findByName(game);
	}

	/* COMMENTS */
	@Override
	public Comments createComment(Comments comment) {
		return commentRepository.save(comment);
	}

	@Override
	public List<Game>findbyCategory(String name) {
		return gameRepository.findAllByCategory(name);
	}

	@Override
	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public Valorar puntuar(Valorar valorar) {
		return valorarRepository.save(valorar);

	}

	@Override
	public String deleteComment(Long id) {
		if(commentRepository.findById(id).isPresent()) {
			commentRepository.deleteById(id);
			return "redirect:";
		} else {
			return "No se pudo realizar la acción";
		}
	}

	@Override
	public String deleteAnswer(Long id) {
		if(answerRepository.findById(id).isPresent()) {
			answerRepository.deleteById(id);
			return "redirect:";
		} else {
			return "No se pudo realizar la acción";
		}
	}
}
