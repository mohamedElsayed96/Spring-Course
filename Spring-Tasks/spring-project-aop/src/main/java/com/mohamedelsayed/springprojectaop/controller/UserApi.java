package com.mohamedelsayed.springprojectaop.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.springprojectaop.annotation.Authorize;
import com.mohamedelsayed.springprojectaop.annotation.AuthorizeType;
import com.mohamedelsayed.springprojectaop.dto.UserDto;
import com.mohamedelsayed.springprojectaop.entity.AuthorityType;
import com.mohamedelsayed.springprojectaop.exception.ExceptionHandler;
import com.mohamedelsayed.springprojectaop.service.UserService;

@RestController
public class UserApi {
	
	private UserService userService;
	@Autowired
	private ExceptionHandler exceptionHandler;

	@Autowired
	public UserApi(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody UserDto register) 
	{
		try {
			userService.save(register);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
		
	                  
				return exceptionHandler.throwExeption(HttpStatus.CONFLICT, "Username already register");
	                           
	                        
			 }
	}
	

	
	@GetMapping("/users")
	@Authorize(role_type = AuthorityType.ROLE_ADMIN, name = "Admin", type = AuthorizeType.TYPE_ROLE)
	public ResponseEntity<?> getUsers() 
	{
		return ResponseEntity.status(200).body(userService.findAll());
	}
	@GetMapping("/hello")
	@Authorize(name = "hello", type = AuthorizeType.TYPE_ACTION)
	public ResponseEntity<?> sayhello() 
	{
		return ResponseEntity.status(200).body("hello");
	}

}
