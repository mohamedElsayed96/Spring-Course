package com.mohamedelsayed.springprojectaop.dto;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

import com.mohamedelsayed.springprojectaop.entity.User;

@XmlRootElement(name="userDto")
public class UserDto {
	
	private String username;
	private String password;
	private String address;
	
	
	public UserDto(String username, String password, String address) {
		super();
		this.username = username;
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User mapDtoToEntity() 
	{
		User user = new User(this.username, this.password, this.address, new Timestamp(System.currentTimeMillis()));
		return user;
	}
	
	

}
