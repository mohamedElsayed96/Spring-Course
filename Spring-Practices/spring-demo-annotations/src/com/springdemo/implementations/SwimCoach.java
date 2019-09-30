package com.springdemo.implementations;

import org.springframework.beans.factory.annotation.Value;

import com.springdemo.interfaces.Coach;
import com.springdemo.interfaces.FortuneService;

public class SwimCoach implements Coach {
	private FortuneService fortuneService;
	@Value("${email}")
	private String email;
	@Value("${team}")

	private String team;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDialyWorkout() {
		// TODO Auto-generated method stub
		return "Practice in the pool for an hour";
	}

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
