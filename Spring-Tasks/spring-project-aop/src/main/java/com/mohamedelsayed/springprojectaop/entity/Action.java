package com.mohamedelsayed.springprojectaop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mohamedelsayed.springprojectaop.dto.ActionDTO;
import com.mohamedelsayed.springprojectaop.dto.ViewDTO;

@Entity
public class Action {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public Action(String name) {
		super();
		this.name = name;
	}
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ActionDTO convertToDTO() 
	{
		return new ActionDTO(id, name);
	}


}
