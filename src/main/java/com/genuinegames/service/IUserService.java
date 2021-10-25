package com.genuinegames.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.genuinegames.dto.UserDTO;
import com.genuinegames.model.entity.User;

public interface IUserService extends UserDetailsService{

	User saveUser (UserDTO userDTO);
}
