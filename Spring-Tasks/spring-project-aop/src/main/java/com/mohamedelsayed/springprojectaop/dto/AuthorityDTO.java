package com.mohamedelsayed.springprojectaop.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mohamedelsayed.springprojectaop.entity.Authority;
import com.mohamedelsayed.springprojectaop.entity.AuthorityType;
import com.mohamedelsayed.springprojectaop.entity.View;

public class AuthorityDTO {

	private int id;
	@Enumerated(EnumType.STRING)
	private AuthorityType name;
	public AuthorityDTO() {
		// TODO Auto-generated constructor stub
	}
	public AuthorityDTO(int id, AuthorityType name) {

		this.id = id;
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
	public Authority mapDtoToEntity() 
	{
		Authority user = new Authority(name);
		return user;
	}
}
