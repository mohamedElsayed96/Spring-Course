package com.spring.service.implementation;
import com.spring.service.interfaces.*;;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"Good Luck", "Bad Luck", "May god help you"};
	private int fortuneIndex;
	@Override
	
	public String getFortune() {
		
		return fortunes[fortuneIndex];
	}
	public RandomFortuneService() {
		fortuneIndex = (int) (Math.random()* fortunes.length);
	}

}
