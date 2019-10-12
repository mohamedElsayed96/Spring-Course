package com.mohamedelsayed.springprojectaop.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.springprojectaop.config.JwtTokenUtil;
import com.mohamedelsayed.springprojectaop.dto.JwtTokenResponseDTO;
import com.mohamedelsayed.springprojectaop.dto.LoginDTO;
import com.mohamedelsayed.springprojectaop.dto.UserDetails;
import com.mohamedelsayed.springprojectaop.dto.UsernamePasswordAuthenticationToken;
import com.mohamedelsayed.springprojectaop.security.AuthenticationManager;
import com.mohamedelsayed.springprojectaop.service.UserDetailsService;



@RestController

@CrossOrigin

public class JwtAuthenticationController {

	@Autowired
	
	private AuthenticationManager authenticationManager;
	
	@Autowired
	
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)

	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDTO authenticationRequest) 
	{
	
		boolean valid = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		if(valid) 
		{
		
			final UserDetails userDetails = userDetailsService.findByUsername(authenticationRequest.getUsername());
			
			final String token = jwtTokenUtil.generateToken(userDetails);
		
			
			return ResponseEntity.ok(new JwtTokenResponseDTO(token));
		}
		return ResponseEntity.status(401).build();
	}

	private boolean authenticate(String username, String password)
	{
	
	//try {
	
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	/*
	} catch (DisabledException e) {
	
	throw new Exception("USER_DISABLED", e);
	
	} catch (BadCredentialsException e) {
	
	throw new Exception("INVALID_CREDENTIALS", e);
	
	}*/
	
	}

}