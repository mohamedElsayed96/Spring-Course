package com.luv2code.springdemo.services.implementation;
import com.luv2code.springdemo.services.interfaces.*;;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"Good Luck", "Bad Luck", "May god help you"};
	@Override
	public String getFortune() {
		int index = (int) (Math.random()* fortunes.length);
		return fortunes[index];
	}

}
