package com.genuinegames.service;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;

public interface IGameService {
	
	public Game createGame(Game game) ;
	
	public String deleteGame(Long id);
	
	public String updateGame(Long id, Game game);
	
	public Game findByGameName(String gamename);
	
	
	
}
