package com.spring.service.implementation;
import com.spring.service.interfaces.*;;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"Good Luck", "Bad Luck", "May god help you", "Be positive", "Today is your day", "you will hit by a car accident"};
	private int fortuneIndex;
	@Override
	
	public String getFortune() {
		
		return fortunes[fortuneIndex];
	}
	public RandomFortuneService() {
		System.out.println("Creating a Random Fortune instance Instance");
		fortuneIndex = (int) (Math.random() * fortunes.length);
	}

}
