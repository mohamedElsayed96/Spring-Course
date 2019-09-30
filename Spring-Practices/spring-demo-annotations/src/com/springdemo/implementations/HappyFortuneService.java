package com.springdemo.implementations;

import org.springframework.stereotype.Component;

import com.springdemo.interfaces.FortuneService;
@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "you will have a happy day";
	}

}
