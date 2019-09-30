package com.springdemo.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springdemo.interfaces.Coach;
import com.springdemo.interfaces.FortuneService;

@Component
public class TennisCoach implements Coach {

	@Autowired
//	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	

/*	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Configuring Fortune Dependancy");
		this.fortuneService = fortuneService;
	}*/
	
	
	public TennisCoach() {
		System.out.println("Creating Instance from Tennis coach");
	} 

	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDialyWorkout() {
		
		return "Practice your backend volley";
	}

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
