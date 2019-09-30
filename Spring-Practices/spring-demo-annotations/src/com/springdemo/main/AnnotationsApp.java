package com.springdemo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.interfaces.Coach;

public class AnnotationsApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(myCoach.getDialyWorkout());
		System.out.println(myCoach.getDailyFotune());

	}

}
