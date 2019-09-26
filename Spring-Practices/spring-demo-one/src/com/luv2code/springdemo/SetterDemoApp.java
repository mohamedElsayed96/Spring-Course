package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luv2code.springdemo.services.interfaces.*;
import com.luv2code.springdemo.services.implementation.*;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve a bean from spring container 
		CricketCoah theCoach =  context.getBean("myCricketCoach", CricketCoah.class);
		
		//Use the bean 
		System.out.println(theCoach.getDialyWorkout());
		System.out.println(theCoach.getDialyFortune());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		// close the context
		context.close();
	}

}
