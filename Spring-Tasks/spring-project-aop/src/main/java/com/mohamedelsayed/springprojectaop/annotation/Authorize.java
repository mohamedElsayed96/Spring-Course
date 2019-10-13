package com.mohamedelsayed.springprojectaop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mohamedelsayed.springprojectaop.entity.AuthorityType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorize {
	AuthorizeType type() default AuthorizeType.TYPE_VIEW;
	String name(); 
	AuthorityType role_type() default AuthorityType.ROlE_USER;
}
