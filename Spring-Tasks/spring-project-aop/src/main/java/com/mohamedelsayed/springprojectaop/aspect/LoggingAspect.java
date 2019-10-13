package com.mohamedelsayed.springprojectaop.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Before("execution(* com.mohamedelsayed.springprojectaop.controller.*.*(..))")
	public void beforeLogger(JoinPoint joinPoint) 
	{
		 Object[] args= joinPoint.getArgs();
         Map<String, String> typeValue= new HashMap<>();
         for(Object obj: args) {
             if(obj!=null) {
                 typeValue.put(obj.getClass().getName(), obj.toString());
             }
         }
         logger.info("calling Method:"+joinPoint.getSignature().getDeclaringTypeName()+", "+joinPoint.getSignature().getName()+", Parameter:-> "+ typeValue);
     
		
		
	}
	@AfterReturning(pointcut ="execution(* com.mohamedelsayed.springprojectaop.controller.*.*(..))", returning = "result")
	public void afterLogger(JoinPoint joinPoint, Object result) 
	{
		
		logger.info("Method returned:" + 
                joinPoint.getSignature().getName() + ", Result: " + result.getClass().getName()+" -->"+result);
   
	}

}