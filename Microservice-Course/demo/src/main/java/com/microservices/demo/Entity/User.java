package com.microservices.demo.Entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
@Entity
public class User {
	@Id
	@GeneratedValue 
	private int id;
	@Size(min=2)
	private String name;
	@Past
	private Date birthdate;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public User(String name, Date birtheDate) {
		
		
		this.name = name;
		this.birthdate = birtheDate;
	}
	public User() 
	{
	}
	
	
	

}
