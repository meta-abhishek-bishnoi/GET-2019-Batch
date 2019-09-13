package com.metacube.parking.model.dto;

import javax.validation.constraints.NotBlank;

public class EmployeeLogin {
	@NotBlank(message="{emptyUsername}")
	private String emailId;
	@NotBlank (message="{emptyPassword}")
	private String password;
	public EmployeeLogin() {
		super();
	}
	public EmployeeLogin(
			@NotBlank(message = "{emptyUsername}") String emailId,
			@NotBlank(message = "{emptyPassword}") String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public String getUsername() {
		return emailId;
	}
	public void setUsername(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
