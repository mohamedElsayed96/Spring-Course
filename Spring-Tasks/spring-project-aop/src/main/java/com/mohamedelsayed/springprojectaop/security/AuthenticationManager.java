package com.mohamedelsayed.springprojectaop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mohamedelsayed.springprojectaop.dto.UserDetails;
import com.mohamedelsayed.springprojectaop.dto.UsernamePasswordAuthenticationToken;
import com.mohamedelsayed.springprojectaop.service.UserDetailsService;

@Component
public class AuthenticationManager {
	@Autowired
	private UserDetailsService userDetailsservice;

	public boolean authenticate(UsernamePasswordAuthenticationToken auth ) 
	{
		UserDetails userDetails = userDetailsservice.findByUsername(auth.getUsername());
		if(userDetails != null) 
		{
			if(userDetails.getPassword().equals(auth.getPassword()))
			{
				return true;
			}
		}
		
		return false;
	}
}
