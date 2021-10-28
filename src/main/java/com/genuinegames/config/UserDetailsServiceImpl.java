package com.genuinegames.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.genuinegames.entity.Role;
import com.genuinegames.entity.User;
import com.genuinegames.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		
		if(user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username).authorities(this.getGrantedAuthority(user));
			builder.disabled(false);
			builder.password(user.getPwd());
		} else {
			throw new UsernameNotFoundException("No se pudo encontrar el usuario");
		}
		
		return builder.build();
	}

	public List<GrantedAuthority>getGrantedAuthority(User user) {
		List<GrantedAuthority>roleName = new ArrayList<>();
		Set<Role>roles = user.getRole();
		
		try {
			for (Role role : roles) {
				roleName.add(new SimpleGrantedAuthority(role.getUsername()));
			}
		} catch (Exception io){
			io.printStackTrace();
		}
		
		return roleName;
	}
}
