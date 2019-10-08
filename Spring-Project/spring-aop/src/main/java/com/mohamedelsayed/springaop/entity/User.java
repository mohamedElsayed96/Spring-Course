package com.mohamedelsayed.springaop.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.mohamedelsayed.springaop.dto.UserDto;


@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username", nullable = false, unique = true)
	private String userName;
	@NotEmpty
	private String password;
	@Email
	private String email;
	
	private String address;
	@Column(name = "create_time")
	private Timestamp createdTime;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_authority",

    joinColumns = { @JoinColumn(name = "user_id") },

    inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	private List<Authority> authority;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password, String address, Timestamp createdTime ) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.createdTime = createdTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserDto Convert() 
	{
		return new UserDto(userName, password, address);
	}
}
