package com.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.interfaces.Coach;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve a bean from spring container 
		Coach theCoach =  context.getBean("myCoach", Coach.class);
		Coach _theCoach = context.getBean("myCoach", Coach.class);
		//Use the bean 
		boolean result = (theCoach == _theCoach);
		System.out.println("Pointing to the same object : " + result);
		System.out.println("the memory loc of theCoach object : " + theCoach.getDialyFortune());
		System.out.println("the memory loc of theCoach object : " + _theCoach.getDialyFortune());
	}

}
