package com.mohamedelsayed.springprojectaop.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.mohamedelsayed.springprojectaop.dto.UserDto;


@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username", nullable = false, unique = true)
	private String username;
	@NotEmpty
	private String password;
	@Email
	private String email;
	
	private String address;
	@Column(name = "create_time")
	private Timestamp createdTime;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_authority",

    joinColumns = { @JoinColumn(name = "user_id") },

    inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	
	private List<Authority> authority;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_view",

    joinColumns = { @JoinColumn(name = "user_id") },

    inverseJoinColumns = { @JoinColumn(name = "view_id") })
	private List<View> view;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_action",

    joinColumns = { @JoinColumn(name = "user_id") },

    inverseJoinColumns = { @JoinColumn(name = "action_id") })
	private List<Action> action;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String address, Timestamp createdTime ) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.createdTime = createdTime;
	}
	
	public User(String username, @NotEmpty String password, @Email String email, String address, Timestamp createdTime,
			List<Authority> authority, List<View> view, List<Action> action) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.createdTime = createdTime;
		this.authority = authority;
		this.view = view;
		this.action = action;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
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
		return new UserDto(username, password, address);
	}
}
