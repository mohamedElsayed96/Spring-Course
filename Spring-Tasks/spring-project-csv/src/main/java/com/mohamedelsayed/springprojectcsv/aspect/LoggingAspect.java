package com.mohamedelsayed.springprojectcsv.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Before("execution(* com.mohamedelsayed.springproject.controllers.*.*(..))")
	public void before(JoinPoint joinPoint) 
	{
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}

}
