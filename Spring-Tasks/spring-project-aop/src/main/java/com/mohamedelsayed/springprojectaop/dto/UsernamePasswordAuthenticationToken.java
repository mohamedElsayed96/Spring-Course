package com.mohamedelsayed.springprojectaop.dto;

public class UsernamePasswordAuthenticationToken {
	private String username;
	private String password;
	public UsernamePasswordAuthenticationToken(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
}
