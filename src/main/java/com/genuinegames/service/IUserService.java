package com.genuinegames.service;

import com.genuinegames.entity.Answer;
import com.genuinegames.entity.Comments;
import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;
import com.genuinegames.entity.Valorar;

public interface IUserService {

	public User findByUsername(String username);

	public User registerUser(User user);

	public User registerAdmin(User user);

	public String updateUser(Long id, User User);

	public String deleteUser(Long id);

	public Comments createComment(Comments comment);

	public Answer createAnswer(Answer answer);

	public Valorar puntuar(Valorar valorar);

	public String deleteComment(Long id);

	public String deleteAnswer(Long id);

}
