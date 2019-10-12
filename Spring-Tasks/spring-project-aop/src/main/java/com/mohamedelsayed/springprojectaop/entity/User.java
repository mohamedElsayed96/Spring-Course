package com.mohamedelsayed.springprojectaop.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.mohamedelsayed.springprojectaop.dto.ActionDTO;
import com.mohamedelsayed.springprojectaop.dto.UserDto;
import com.mohamedelsayed.springprojectaop.dto.ViewDTO;


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
	
	private List<Authority> authorities;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_view",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "view_id") })
	private List<View> views;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_action",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "action_id") })
	private List<Action> actions;
	
	
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
		this.authorities = authority;
		this.views = view;
		this.actions = action;
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
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public List<View> getViews() {
		return views;
	}
	public void setViews(List<View> views) {
		this.views = views;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public UserDto Convert() 
	{
		List<ViewDTO> views = new ArrayList<ViewDTO>();
		List<ActionDTO> actions = new ArrayList<ActionDTO>();
		for(View view :this.views) 
		{
			views.add(view.convertToDTO());
		}
		for(Action view :this.actions) 
		{
			actions.add(view.convertToDTO());
		}
		return new UserDto( username, password, email ,address,  views,  actions);
	}
}
