package com.mohamedelsayed.randomgenerationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.randomgenerationservice.models.ResponseModel;
@RestController
public class RandomStringApi {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	@Autowired
	private Environment env;
	@Value("${spring.application.name}")
	private String appName;	
	@GetMapping("/random-string/{count}")
	public  ResponseEntity<?> randomAlphaNumeric(@PathVariable int count) {

		StringBuilder builder = new StringBuilder();
	
		while (count-- != 0) {
	
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		
		}
	
		return ResponseEntity.status(200).body(new ResponseModel(Integer.parseInt(env.getProperty("local.server.port")), appName, builder.toString() ));

	}
}
