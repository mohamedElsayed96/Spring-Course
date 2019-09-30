package com.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.interfaces.Coach;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("footballCoach", Coach.class);
		System.out.println(theCoach.getMeDialyWorkout());

	}

}
