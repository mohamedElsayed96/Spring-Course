package com.springboot.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	public FunRestController() 
	{}
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String sayHello() 
	{
		return "Hello World " + LocalDateTime.now();
	}
	@RequestMapping(method = RequestMethod.GET, value="/getDialyWorkout")
	public String getDialyWorkout() 
	{
		return "Run a hard 5K!";
	}
	@RequestMapping(method = RequestMethod.GET, value="/getDialyFortune")
	public String getDialyFortune() 
	{
		return "Today is your lucky day!";
	}
}
