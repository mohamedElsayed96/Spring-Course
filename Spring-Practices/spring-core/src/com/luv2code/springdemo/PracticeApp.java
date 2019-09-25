package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.services.interfaces.Coach;

public class PracticeApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-practice.xml");
		//Retrieve a bean from spring container 
		Coach theCoach =  context.getBean("myCoach", Coach.class);
		Coach _theCoach = context.getBean("myCoach", Coach.class);
		//Use the bean 
		boolean result = (theCoach == _theCoach);
		System.out.println("Pointing to the same object : " + result);
		System.out.println("the memory loc of theCoach object : " + theCoach);
		System.out.println("the memory loc of theCoach object : " + _theCoach);
		
		System.out.println(theCoach.getDialyWorkout());
		System.out.println(theCoach.getDialyFortune());
		// close the context
		context.close();

	}

}
