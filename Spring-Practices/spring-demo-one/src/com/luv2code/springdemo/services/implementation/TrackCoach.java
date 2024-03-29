package com.luv2code.springdemo.services.implementation;
import com.luv2code.springdemo.services.interfaces.*;;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDialyWorkout() 
	{
		return "run a hard 50 minute";
	}

	@Override
	public String getDialyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
