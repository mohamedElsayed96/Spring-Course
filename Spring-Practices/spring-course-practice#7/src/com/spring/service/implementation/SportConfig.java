package com.spring.service.implementation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.spring.service.interfaces.*;

@Configuration
@PropertySource("classpath:fortunes.properties")
public class SportConfig {
	@Bean
	@Scope("prototype")
	public FortuneService sadFortuneService() 
	{
		return new RandomFortuneService();
	}
	@Bean
	@Scope("prototype")
	public Coach footballCoach(FortuneService sadFortuneService) 
	{
		return new FootballCoach(sadFortuneService);
	}
}
