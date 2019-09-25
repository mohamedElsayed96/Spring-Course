package com.luv2code.springdemo.services.implementation;
import com.luv2code.springdemo.services.interfaces.*;;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	public FootballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDialyWorkout() {
		// TODO Auto-generated method stub
		return "Train on shooting fot 30 minutes";
	}

	@Override
	public String getDialyFortune() {
		
		return fortuneService.getFortune();
	}

}
