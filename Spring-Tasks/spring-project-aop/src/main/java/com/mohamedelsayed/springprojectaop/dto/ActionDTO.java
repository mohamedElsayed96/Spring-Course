package com.mohamedelsayed.springprojectaop.dto;

import java.sql.Timestamp;

import com.mohamedelsayed.springprojectaop.entity.Action;
import com.mohamedelsayed.springprojectaop.entity.User;

public class ActionDTO {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActionDTO(String name) {
		super();
		this.name = name;
	}

	public ActionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Action mapDtoToEntity() 
	{
		Action user = new Action(name);
		return user;
	}
}
