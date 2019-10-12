package com.mohamedelsayed.springprojectaop.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohamedelsayed.springprojectaop.entity.Action;
import com.mohamedelsayed.springprojectaop.entity.User;
import com.mohamedelsayed.springprojectaop.entity.View;

@XmlRootElement(name="userDto")
public class UserDto {
	
	
	private String username;
	private String password;
	private String address;
	@Email
	private String email;
	private List<ViewDTO> views;
	private List<ActionDTO> actions;
	
	
	public UserDto(String username, String password, String address, @Email String email, List<ViewDTO> views,
			List<ActionDTO> actions) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.views = views;
		this.actions = actions;
	}
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor  stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User mapDtoToEntity(PasswordEncoder passwordEncoder) 
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
		String encoddedPassword = passwordEncoder.encode(password);
		User user = new User(this.username, encoddedPassword, email, this.address, new Timestamp(System.currentTimeMillis()), null, views, actions);
		return user;
	
	
   }
}
