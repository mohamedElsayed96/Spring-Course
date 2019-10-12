package com.microservices.currencyconversionservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyconversionservice.entities.CurrencyConversion;
import com.microservices.currencyconversionservice.feignproxies.CurrencyExchangeServicesProxy;

@RestController
public class CurrencyConversionApi {
	@Autowired
	private CurrencyExchangeServicesProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrecy(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) 
	{
		CurrencyConversion c =  proxy.currencyExchange(from, to);
		return new CurrencyConversion(c.getId(), from, to, c.getPort() ,c.getConversionMultiple(), quantity, quantity.multiply(c.getConversionMultiple()));
	}

}
