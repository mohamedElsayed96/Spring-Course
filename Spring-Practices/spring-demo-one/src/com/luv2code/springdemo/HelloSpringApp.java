package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luv2code.springdemo.services.interfaces.*;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve a bean from spring container 
		Coach theCoach =  context.getBean("myCoach", Coach.class);
		
		//Use the bean 
		System.out.println(theCoach.getDialyWorkout());
		System.out.println(theCoach.getDialyFortune());
		// close the context
		context.close();

	}

}
