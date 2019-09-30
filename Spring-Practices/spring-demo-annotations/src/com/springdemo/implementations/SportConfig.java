package com.springdemo.implementations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.springdemo.interfaces.Coach;
import com.springdemo.interfaces.FortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan
public class SportConfig {
	@Bean
	public FortuneService happyFortuneService() 
	{
		return new HappyFortuneService();
		
	}
	@Bean
	public Coach swimCoach(FortuneService happyFortuneService) 
	{
		Coach swimCoach = new SwimCoach(happyFortuneService());
		return swimCoach;
	}

}
