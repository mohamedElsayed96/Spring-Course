package com.mohamedelsayed.userregister.models;

public class ResponseModel {
	private int port;
	private String applicationName;
	private Object payload;
	public ResponseModel(int port, String applicationName, Object payload) {
		super();
		this.port = port;
		this.applicationName = applicationName;
		this.payload = payload;
	}
	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	

}
