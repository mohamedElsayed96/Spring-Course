package com.springdemo.implementations;

import org.springframework.stereotype.Component;

import com.springdemo.interfaces.Coach;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDialyWorkout() {
		
		return "Practice your backend volley";
	}

}
