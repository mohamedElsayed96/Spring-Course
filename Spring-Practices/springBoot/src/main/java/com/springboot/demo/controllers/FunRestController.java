package com.springboot.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	@Value("${coach.name}")
	private String coachName;
	@Value("${coach.team}")
	private String coachTeam;
	public FunRestController() 
	{
		System.out.println(coachName +" "+ coachTeam);
	}
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
	@RequestMapping(method = RequestMethod.GET, value="/getCoachName")
	public String getCoachName() 
	{
		return coachName;
	}
	@RequestMapping(method = RequestMethod.GET, value="/getCoachTeam")
	public String getCoachTeam() 
	{
		return coachTeam;
	}
}
