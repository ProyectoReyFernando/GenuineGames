package com.genuinegames.service;

import java.util.List;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;

public interface IGameService {

	public Game createGame(Game game);

	public String deleteGame(Long id);

	public String updateGame(Long id, Game game);

	public Game findByGameName(String name);

	public List<Game> findbyCategory(String name);

}
