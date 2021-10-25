package com.genuinegames.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.genuinegames.dto.UserDTO;
import com.genuinegames.model.entity.Role;
import com.genuinegames.model.entity.User;
import com.genuinegames.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(UserDTO userDTO) {
		User user = new User(null, userDTO.getName(), userDTO.getPwd(), userDTO.getCpwd(), userDTO.getTlf(),
				userDTO.getMail(), userDTO.getFnac(), userDTO.getSex(), Arrays.asList(new Role("ROLE_USER")));
		
		//user.setPwd(passwordEncoder.encode(userDTO.getPwd()));
		//user.setCpwd(passwordEncoder.encode(userDTO.getPwd()));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByName(username);
		
		if(user != null) {
			throw new UsernameNotFoundException("Usuario o contraseña inválidos");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPwd(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
