package com.mohamedelsayed.springprojectaop.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.springprojectaop.dto.RegisterDTO;
import com.mohamedelsayed.springprojectaop.dto.UserDto;
import com.mohamedelsayed.springprojectaop.service.RegisterService;
import com.mohamedelsayed.springprojectaop.service.UserService;

@RestController
public class UserApi {
	
	private UserService userService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	public UserApi(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users")
	public String saveUser(@RequestBody RegisterDTO register) 
	{
		registerService.Register(register);
		return "created";
	}
	
	@GetMapping("/users")
	public List<UserDto> saveUser() 
	{
		return userService.findAll();
	}
	@GetMapping("/hello")
	public String hello() 
	{
		return "hello bitch";
	}

}
