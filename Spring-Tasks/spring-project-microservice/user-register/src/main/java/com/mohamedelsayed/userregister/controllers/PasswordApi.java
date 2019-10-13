package com.mohamedelsayed.userregister.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.userregister.feignproxies.RandomStringProxy;
import com.mohamedelsayed.userregister.models.ResponseModel;

@RestController
public class PasswordApi {

	 
	@Autowired
	private RandomStringProxy proxy;
	@Autowired
	private Environment env;
	@Value("${spring.application.name}")
	private String appName;	
	@GetMapping("/recommend-password/{count}")
	public ResponseEntity<?> getRecommendedPassword(@PathVariable int count)
	{
		ResponseModel response = proxy.getRandomString(count);
		response.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		response.setApplicationName(appName);
		return ResponseEntity.status(200).body(response);
	}
}
