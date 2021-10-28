package com.genuinegames.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		auth
			.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN");
		auth
			.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable();
			
		http
			.authorizeRequests()
			.antMatchers("/", "/auth/**", "/public/**", "/css/**", "/js/**", "/img/**", "/media/**")
				.permitAll()
			.antMatchers("/user/**")
				.access("hasAuthority('USER')")
			.antMatchers("/user/**")
				.access("hasRole('ADMIN')")
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/login")
				.defaultSuccessUrl("/user/index", true)
				.failureForwardUrl("/auth/login?error=true")
				.loginProcessingUrl("/auth/login-post").permitAll()
			.and()
				.logout().logoutUrl("/logout?success=true")
				.logoutSuccessUrl("/public/inicio");
		}
	}




