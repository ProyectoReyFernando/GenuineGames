package com.genuinegames.service;

import java.util.List;

import com.genuinegames.entity.Game;

public interface IGameService {
		
	public Game createGame(Game game);
	
	public String deleteGame(Long id);
	
	public String updateGame(Long id, Game game);
	
}
