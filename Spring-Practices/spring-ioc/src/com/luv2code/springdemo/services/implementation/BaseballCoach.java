package com.luv2code.springdemo.services.implementation;
import com.luv2code.springdemo.services.interfaces.*;;

public class BaseballCoach  implements Coach{
	private FortuneService fortuneService;
	@Override
	public String getDialyWorkout() 
	{
		return "spend 30 minute in push ups";
	}
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDialyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
