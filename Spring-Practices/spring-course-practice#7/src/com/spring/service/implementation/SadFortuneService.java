package com.spring.service.implementation;

import com.spring.service.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "This is a sad day";
	}

}
