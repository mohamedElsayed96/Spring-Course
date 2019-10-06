package com.microservices.demo.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.demo.DOA.UserRepository;
import com.microservices.demo.Entity.User;
import com.microservices.demo.exception.UserNotFoundException;
import com.microservices.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserApi {
	
	private UserService userservice;
	
	@Autowired
	public UserApi(UserService userservice) {
		this.userservice = userservice;
	}

	@GetMapping("/users")
	public List<User> getAllUser()
	{
		return userservice.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id)
	{
		return userservice.findById(id);
	}
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user)
	{
		User savedUser = userservice.Save(user);
		//System.out.println(user.birthdate());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		 
	}
	
	
	@PutMapping("/users/{id}")
	public User UpdateUser(@RequestBody User user, @PathVariable int id)
	{
		User us = userservice.findById(id);
		if(us !=null)
			return userservice.Save(user);
		throw new UserNotFoundException("id-" + id);
	}
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id)
	{
		User u = userservice.findById(id);
		if(u != null)
		{
			userservice.delete(id);
			return "Deleted User with Id = " + id;
		}
		throw new UserNotFoundException("id-" + id);
		
	}
	

}
