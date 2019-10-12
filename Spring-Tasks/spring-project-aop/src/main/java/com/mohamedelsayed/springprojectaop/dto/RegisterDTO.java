package com.mohamedelsayed.springprojectaop.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mohamedelsayed.springprojectaop.entity.*;



public class RegisterDTO {
	private String username;
	private String password;
	private String email;
	private String address;
	private List<ViewDTO> views;
	private List<ActionDTO> actions;
	public RegisterDTO(String username, String password, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<ViewDTO> getViews() {
		return views;
	}
	public void setViews(List<ViewDTO> views) {
		this.views = views;
	}
	public List<ActionDTO> getActions() {
		return actions;
	}
	public void setActions(List<ActionDTO> actions) {
		this.actions = actions;
	}
	public User mapDtoToEntity() 
	{
		List<View> views = new ArrayList<View>();
		List<Action> actions = new ArrayList<Action>();
		for(ViewDTO view :this.views) 
		{
			views.add(view.mapDtoToEntity());
		}
		for(ActionDTO view :this.actions) 
		{
			actions.add(view.mapDtoToEntity());
		}
		User user = new User(this.username, this.password, email, this.address, new Timestamp(System.currentTimeMillis()), null, views, actions);
		return user;
	}
}
