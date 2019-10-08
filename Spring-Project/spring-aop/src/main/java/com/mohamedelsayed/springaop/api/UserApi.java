package com.mohamedelsayed.springaop.api;

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

import com.mohamedelsayed.springaop.dto.UserDto;
import com.mohamedelsayed.springaop.service.UserService;

@RestController
public class UserApi {
	
	private UserService userService;
	
	@Autowired
	public UserApi(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users")
	public String saveUser(@RequestBody UserDto user) 
	{
		System.out.println(user.getUsername());

		userService.save(user);
		return "created";
	}
	
	@GetMapping("/users")
	public List<UserDto> saveUser() 
	{
		return userService.findAll();
	}

}
