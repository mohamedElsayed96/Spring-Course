package com.mohamedelsayed.springprojectaop.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.springprojectaop.annotation.Authorize;
import com.mohamedelsayed.springprojectaop.annotation.AuthorizeType;
import com.mohamedelsayed.springprojectaop.dto.UserDto;

import com.mohamedelsayed.springprojectaop.service.UserService;

@RestController
public class UserApi {
	
	private UserService userService;

	@Autowired
	public UserApi(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users")
	public String saveUser(@RequestBody UserDto register) 
	{
		userService.save(register);
		return "created";
	}
	
	@GetMapping("/users")
	public List<UserDto> saveUser() 
	{
		return userService.findAll();
	}
	@GetMapping("/hello")
	@Authorize(name = "hello", type = AuthorizeType.TYPE_VIEW)
	public ResponseEntity<?> sayhello() 
	{
		return ResponseEntity.status(200).body("hello");
	}

}
