package com.mohamedelsayed.springprojectaop.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;

import com.mohamedelsayed.springprojectaop.annotation.Authorize;
import com.mohamedelsayed.springprojectaop.annotation.AuthorizeType;
import com.mohamedelsayed.springprojectaop.config.JwtTokenUtil;
import com.mohamedelsayed.springprojectaop.dto.UserDetails;
import com.mohamedelsayed.springprojectaop.dto.UserDto;
import com.mohamedelsayed.springprojectaop.dto.ViewDTO;
import com.mohamedelsayed.springprojectaop.exception.ExceptionEnum;
import com.mohamedelsayed.springprojectaop.exception.ExceptionHandler;
import com.mohamedelsayed.springprojectaop.service.UserDetailsService;
import com.mohamedelsayed.springprojectaop.service.UserService;

@Aspect
@Configuration
public class SecurityFilterAspect {

	@Autowired
	private ExceptionHandler exceptionHandler;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JwtTokenUtil jwtTokenUtil; 
	@Around("execution(* com.mohamedelsayed.springprojectaop.controller.*.*(..))")
	public Object authenticateBefore(ProceedingJoinPoint joinPoint)  throws Throwable
	{
		
		String requestTokenHeader = request.getHeader("Authorization");
		MethodSignature signature =  (MethodSignature) joinPoint.getSignature();
	    Method method = signature.getMethod();

	    Authorize myAnnotation = method.getAnnotation(Authorize.class);
	    
	    if(myAnnotation != null) 
	    {
	    	logger.info("Authenticating....");
	    	boolean valid = authenticate(requestTokenHeader, myAnnotation);
	    	if(valid) 
	    	{
	    		logger.info("Authorizating ...");
	    		String token = getTokenFromHeader(requestTokenHeader);
	    		valid = Authorize(jwtTokenUtil.getUsernameFromToken(token), myAnnotation);
	    		if(valid)
	    		{
		    		logger.info("Authenticating + Authorization: succeded Allowed user for {} {}", myAnnotation.type().toString(), myAnnotation.name());
		    		 
		    	    return (ResponseEntity<?>) joinPoint.proceed();
	    		}
	    		else 
	    		{
	    			logger.info("Authorization: failed");
	    			return exceptionHandler.throwExeption(ExceptionEnum.INVALID_TOKEN, "Authorization faild: You are not allowed to use this api");
	    		}
	    		
	    	}
	    	else 
	    	{
	    		logger.info("Authenticating: failed");
	    		return exceptionHandler.throwExeption(ExceptionEnum.INVALID_TOKEN, "Authenticating failed: Invalid Token");
	    	}
	    }
	    else 
	    {
	    	logger.info("Allowed execution No authorization Required ");
	    	
	    	return  joinPoint.proceed();
	     
	    	
	    }
		
	}
	private boolean authenticate(String requestTokenHeader, Authorize authorizeAnnotation) 
	{
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) 
		{
			String token = requestTokenHeader.substring(7);
			String username = jwtTokenUtil.getUsernameFromToken(token);
			if(username != null)
			{
				UserDetails userDetails = userDetailsService.findByUsername(username);
				if(userDetails != null) 
				{
					return jwtTokenUtil.validateToken(token, userDetails);
	
					
				}
			}
		}
		return false;
		
	}
	private String getTokenFromHeader(String requestTokenHeader) 
	{
		return requestTokenHeader.substring(7);
	}
	
	private boolean Authorize(String username, Authorize authorizeAnnotation) 
	{
		UserDto user = userService.findByUsername(username);
		switch(authorizeAnnotation.type())
		{
			case TYPE_VIEW:
				if(user.getViews().stream()
						.filter(o-> o.getName().equals(authorizeAnnotation.name()))
						.findFirst().isPresent())
					return true;
				break;
			case TYPE_ACTION:
				if(user.getActions().stream()
						.filter(o-> o.getName().equals(authorizeAnnotation.name()))
						.findFirst().isPresent())
					return true;
				break;
			case TYPE_ROLE:
				
				if(user.getAuthorities().stream()
						.filter(o-> o.getName() == authorizeAnnotation.role_type())
						.findFirst().isPresent())
				return true;
			break;
			default:
				return false;
				
		}
		return false;
	}
	
}
