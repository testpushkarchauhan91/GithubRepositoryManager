package com.favourite.model;

public class User {

	public int id;
	public String name;
	public String password;
	public String confirmPassword;
	
	public User() {}

	public User(int id, String name, String password, String confirmPassword) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
