package com.metacube.parkingjdbc.model.dto;

import javax.validation.constraints.NotBlank;
/**
 * 
 * @author Abhishek Bishnoi
 * Employee Login DTO
 */
public class EmployeeLogin {
	@NotBlank(message="{emptyUsername}")
	private String username;
	@NotBlank (message="{emptyPassword}")
	private String password;
	public EmployeeLogin() {
		super();
	}
	public EmployeeLogin(
			@NotBlank(message = "{emptyUsername}") String username,
			@NotBlank(message = "{emptyPassword}") String password) {
		super();
		this.username = username;
		this.password = password;
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
	
}
