package com.spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.service.interfaces.Coach;
import com.spring.service.interfaces.FortuneService;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	public FootballCoach(FortuneService fortuneService) 
	{
		this.fortuneService = fortuneService;
		System.out.println("Creating Football Coach instance");
	}
	@Override
	public String getDialyWorkout() {
		return "Train on shooting the ball fot 30 minutes";
	}
	

	@Override
	public String getDialyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
