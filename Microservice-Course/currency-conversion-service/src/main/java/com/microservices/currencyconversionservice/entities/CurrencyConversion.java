package com.microservices.currencyconversionservice.entities;

import java.math.BigDecimal;

public class CurrencyConversion {
	private int id;
	private String from;
	private String to;
	private int port;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal calculatedAmount;
	
	public CurrencyConversion(int id, String from, String to,int port, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal calculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.port = port;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultple) {
		this.conversionMultiple = conversionMultple;
	}
	public BigDecimal getQuantitiy() {
		return quantity;
	}
	public void setQuantitiy(BigDecimal quantitiy) {
		this.quantity = quantitiy;
	}
	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	


}
