package com.mohamedelsayed.springprojectaop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mohamedelsayed.springprojectaop.dto.UserDetails;
import com.mohamedelsayed.springprojectaop.dto.UsernamePasswordAuthenticationToken;
import com.mohamedelsayed.springprojectaop.service.UserDetailsService;

@Component
public class AuthenticationManager {
	@Autowired
	private UserDetailsService userDetailsservice;
	@Autowired
	private PasswordEncoder encoder;

	public boolean authenticate(UsernamePasswordAuthenticationToken auth ) 
	{
		UserDetails userDetails = userDetailsservice.findByUsername(auth.getUsername());
		if(userDetails != null) 
		{
			if(encoder.matches(auth.getPassword(), userDetails.getPassword()))
			{
				return true;
			}
		}
		
		return false;
	}
}
