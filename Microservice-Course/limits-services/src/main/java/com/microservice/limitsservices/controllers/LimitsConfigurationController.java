package com.microservice.limitsservices.controllers;

import com.microservice.limitsservices.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.limitsservices.bean.LimitConfiguration;
import com.microservice.limitsservices.config.Configuration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfiguration() 
	{
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
}
