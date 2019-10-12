package com.mohamedelsayed.springprojectaop.dto;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

import com.mohamedelsayed.springprojectaop.entity.User;

@XmlRootElement(name="userDto")
public class UserDto {
	
	
	private String username;
	private String address;
	
	
	public UserDto(String username, String password, String address) {
		super();
		this.username = username;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User mapDtoToEntity(String password) 
	{
		User user = new User(this.username, password, this.address, new Timestamp(System.currentTimeMillis()));
		return user;
	}
	
	

}
