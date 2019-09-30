package com.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.implementation.SportConfig;
import com.spring.service.interfaces.Coach;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		Coach theCoach = context.getBean("footballCoach", Coach.class);
		System.out.println(theCoach.getDialyWorkout());
		System.out.println(theCoach.getDialyFortune());
		theCoach = context.getBean("footballCoach", Coach.class);
		System.out.println(theCoach.getDialyWorkout());
		System.out.println(theCoach.getDialyFortune());

	}

}
