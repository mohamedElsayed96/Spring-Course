package com.mohamedelsayed.springprojectaop.dto;

import java.sql.Timestamp;

import com.mohamedelsayed.springprojectaop.entity.User;
import com.mohamedelsayed.springprojectaop.entity.View;

public class ViewDTO {
	private String name;

	public ViewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public View mapDtoToEntity() 
	{
		View user = new View(name);
		return user;
	}
	
}
