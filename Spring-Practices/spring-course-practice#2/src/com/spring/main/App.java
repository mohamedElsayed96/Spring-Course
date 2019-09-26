package com.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.interfaces.*;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// TODO Auto-generated method stub
		Coach theCoach =  context.getBean("myCoach", Coach.class);
		
		
		System.out.println(theCoach.getDialyWorkout());
		System.out.println(theCoach.getDialyFortune());
	}

}
