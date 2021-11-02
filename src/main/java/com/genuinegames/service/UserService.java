package com.genuinegames.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.genuinegames.entity.Role;
import com.genuinegames.entity.User;
import com.genuinegames.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

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

}
