package com.microservices.currencyconversionservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyconversionservice.entities.CurrencyConversion;

@RestController
public class CurrencyConversionApi {

	@GetMapping("/currency-service/from/{from}/to/{to}/quantitiy/{quantity}")
	public CurrencyConversion convertCurrecy(@PathVariable String from, @PathVariable String to, @PathVariable String quantity) 
	{
		
	}

}
