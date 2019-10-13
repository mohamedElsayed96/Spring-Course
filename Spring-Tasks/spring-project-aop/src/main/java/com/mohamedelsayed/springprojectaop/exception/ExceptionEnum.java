package com.mohamedelsayed.springprojectaop.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
	INVALID_CREDENTIALS,USER_DISABLED,INVALID_TOKEN;

	public HttpStatus getValue() {
		// TODO Auto-generated method stub
		switch(this)
		{
		case INVALID_CREDENTIALS:
		case USER_DISABLED:
		case INVALID_TOKEN:
			return HttpStatus.UNAUTHORIZED;
		
		}
		return HttpStatus.BAD_REQUEST;
	}

}
