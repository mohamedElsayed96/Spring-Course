package com.mohamedelsayed.springprojectaop.controller;


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
import com.mohamedelsayed.springprojectaop.exception.ExceptionEnum;
import com.mohamedelsayed.springprojectaop.exception.ExceptionHandler;
import com.mohamedelsayed.springprojectaop.security.AuthenticationManager;
import com.mohamedelsayed.springprojectaop.service.UserDetailsService;



@RestController

@CrossOrigin

public class JwtAuthenticationController {

	@Autowired
	private ExceptionHandler exceptionHandler;
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
		
		return exceptionHandler.throwExeption(ExceptionEnum.INVALID_CREDENTIALS, "Wrong username or password");
	}

	private boolean authenticate(String username, String password)
	{
	
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

	}

}