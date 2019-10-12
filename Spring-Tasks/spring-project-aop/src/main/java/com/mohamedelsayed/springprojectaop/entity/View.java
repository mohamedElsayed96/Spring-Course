package com.mohamedelsayed.springprojectaop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mohamedelsayed.springprojectaop.dto.ViewDTO;

@Entity
public class View {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public View(String name) {
		super();
		this.name = name;
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
	public ViewDTO convertToDTO() 
	{
		return new ViewDTO(id, name);
	}

}
