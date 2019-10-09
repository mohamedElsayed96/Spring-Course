package com.mohamedelsayed.springproject.models;

public class DataModel {
	private String data;
	private String color;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public DataModel(String data, String color) {
		super();
		this.data = data;
		this.color = color;
	}
	

}
