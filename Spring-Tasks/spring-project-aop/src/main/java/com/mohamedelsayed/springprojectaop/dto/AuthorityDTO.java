package com.mohamedelsayed.springprojectaop.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mohamedelsayed.springprojectaop.entity.AuthorityType;

public class AuthorityDTO {

	private int id;
	@Enumerated(EnumType.STRING)
	private AuthorityType name;
	public AuthorityDTO() {
		// TODO Auto-generated constructor stub
	}
	public AuthorityDTO(AuthorityType name) {

		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AuthorityType getName() {
		return name;
	}
	public void setName(AuthorityType name) {
		this.name = name;
	}
	
}
