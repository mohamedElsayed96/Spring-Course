package com.spring.service.implementation;

import org.springframework.stereotype.Component;

import com.spring.service.interfaces.Coach;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getMeDialyWorkout() {
		// TODO Auto-generated method stub
		return "Train on shooting the ball fot 30 minutes";
	}

}
