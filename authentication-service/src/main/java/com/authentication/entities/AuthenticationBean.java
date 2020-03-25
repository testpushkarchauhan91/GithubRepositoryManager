package com.authentication.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AuthenticationBean {

	private String message;
	private String username;
	private String password;

	public AuthenticationBean() {

	}

	public AuthenticationBean(String message) {
		this.message = message;
	}

	public AuthenticationBean(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	@Override
	public String toString() {
		return "AuthenticationBean [message=" + message + ", username=" + username + ", password=" + password + "]";
	}

}
