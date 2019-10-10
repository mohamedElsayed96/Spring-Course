package com.microservices.currencyconversionservice.entities;

import java.math.BigDecimal;

public class CurrencyConversion {
	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultple;
	private BigDecimal quantitiy;
	private BigDecimal calculatedAmount;
	
	public CurrencyConversion(int id, String from, String to, BigDecimal conversionMultple, BigDecimal quantitiy,
			BigDecimal calculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultple = conversionMultple;
		this.quantitiy = quantitiy;
		this.calculatedAmount = calculatedAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public BigDecimal getConversionMultple() {
		return conversionMultple;
	}
	public void setConversionMultple(BigDecimal conversionMultple) {
		this.conversionMultple = conversionMultple;
	}
	public BigDecimal getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(BigDecimal quantitiy) {
		this.quantitiy = quantitiy;
	}
	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	


}
