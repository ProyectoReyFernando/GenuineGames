package com.genuinegames.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetails;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/", "/auth/**", "/public/**", "/css/**", "/js/**", "/img/**", "/media/**")
			.permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/auth/login")
				.defaultSuccessUrl("/user/index", true)
				.failureForwardUrl("/auth/login?error=true")
				.loginProcessingUrl("/auth/login-post").permitAll()
			.and()
				.logout().logoutUrl("/logout")
				.logoutSuccessUrl("/public/inicio");
	}
	
	

}
