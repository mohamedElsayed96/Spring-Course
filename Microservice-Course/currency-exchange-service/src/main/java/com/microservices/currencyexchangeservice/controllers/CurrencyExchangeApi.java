package com.microservices.currencyexchangeservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.dao.ExchangeValueRepository;
import com.microservices.currencyexchangeservice.entities.ExchangeValue;

@RestController
public class CurrencyExchangeApi {
	
	@Autowired
	private ExchangeValueRepository repository;
	@GetMapping("/currency-service/from/{from}/to/{to}")
	public ExchangeValue currencyExchange(@PathVariable("from") String from, @PathVariable("to") String to) 
	{
		return repository.findByFromAndTo(from, to);
		
	}

 }
