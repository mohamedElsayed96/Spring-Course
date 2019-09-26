package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luv2code.springdemo.services.interfaces.*;
public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring container config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		//retrieve a  bean 
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach _theCoach = context.getBean("myCoach", Coach.class);
		boolean result = (theCoach == _theCoach);
		System.out.println("Pointing to the same object : " + result);
		System.out.println("the memory loc of theCoach object : " + theCoach);
		System.out.println("the memory loc of theCoach object : " + _theCoach);
		
	}

}
