package com.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyexchangeservice.entities.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer> {

	ExchangeValue findByFromAndTo(String  from, String to);
}
