package com.springdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.*;

import com.springdemo.implementations.SportConfig;
import com.springdemo.implementations.SwimCoach;
import com.springdemo.interfaces.Coach;

public class JavaConfigDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		Coach myCoach = context.getBean("swimCoach", Coach.class);
		SwimCoach swimCoach = (SwimCoach) myCoach;
		System.out.println(myCoach.getDialyWorkout());
		System.out.println(myCoach.getDailyFotune());
		System.out.println(swimCoach.getEmail());
		System.out.println(swimCoach.getTeam());

	}

}
