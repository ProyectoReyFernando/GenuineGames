package com.genuinegames.service;

import com.genuinegames.entity.User;

public interface IUserService {

	public User findByUsername(String username);
	
	public User registerUser(User user);
	
}
