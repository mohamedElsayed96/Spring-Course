package com.spring.service.implementation;

import com.spring.service.interfaces.Coach;
import com.spring.service.interfaces.FortuneService;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	public FootballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDialyWorkout() {
		// TODO Auto-generated method stub
		return "Train on shooting the ball fot 30 minutes";
	}

	@Override
	public String getDialyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
