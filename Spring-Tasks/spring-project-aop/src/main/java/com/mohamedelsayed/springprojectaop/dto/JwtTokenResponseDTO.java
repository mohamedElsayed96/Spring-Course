package com.mohamedelsayed.springprojectaop.dto;

public class JwtTokenResponseDTO {
	private final String jwttoken;

	public JwtTokenResponseDTO(String jwttoken) {

	this.jwttoken = jwttoken;

	}

	public String getToken() {

	return this.jwttoken;

	}
}
