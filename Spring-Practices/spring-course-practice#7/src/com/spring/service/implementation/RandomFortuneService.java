package com.spring.service.implementation;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.service.interfaces.*;;

@Component
public class RandomFortuneService implements FortuneService {

	private int fortuneIndex;
	private String happyFortune_1;
	private String happyFortune_2;
	private String badFortune_1;
	private String badFortune_2;
	private String badFortune_3;
	private String[] fortunes; 
	@PostConstruct
	public void setupData() 
	{
		System.out.println("setting up data");
		fortunes  = new String[] {happyFortune_1, happyFortune_2, badFortune_1, badFortune_2, badFortune_3};
		fortuneIndex = (int) (Math.random() * fortunes.length);

	}
	@Value("${happyFortune_1}")
	public void setHappyFortune_1(String happyFortune_1) {
		this.happyFortune_1 = happyFortune_1;
	}
	@Value("${happyFortune_2}")
	public void setHappyFortune_2(String happyFortune_2) {
		this.happyFortune_2 = happyFortune_2;
	}
	@Value("${badFortune_1}")
	public void setBadFortune_1(String badFortune_1) {
		this.badFortune_1 = badFortune_1;
	}
	@Value("${badFortune_2}")
	public void setBadFortune_2(String badFortune_2) {
		this.badFortune_2 = badFortune_2;
	}
	@Value("${badFortune_3}")
	public void setBadFortune_3(String badFortune_3) {
		this.badFortune_3 = badFortune_3;
	}
	
	public RandomFortuneService() {
		System.out.println("Creating a Random Fortune instance Instance");
	}
	@Override
	public String getFortune() {
		return fortunes[fortuneIndex];
	}

}
