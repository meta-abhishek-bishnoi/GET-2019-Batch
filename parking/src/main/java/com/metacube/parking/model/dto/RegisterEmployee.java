package com.metacube.parking.model.dto;

import javax.validation.constraints.NotBlank;
/**
* @author Abhishek Bishnoi
* This is dto class for Registering Employee
*/
public class RegisterEmployee {
	@NotBlank(message="{employeeFullName}")
	private String fullName;
	@NotBlank(message="{employeeGender}")
	private String gender;
	@NotBlank(message="employeeId")
	private String employeeId;
	@NotBlank(message="{employeeEmailId}")
	private String emailId;
	@NotBlank(message="{employeePassword}")
	private String password;
	@NotBlank(message="{employeeConfirmPassword}")
	private String confirmPassword;
	@NotBlank(message ="{employeeContactNo}")
	private String contactNo;
	@NotBlank(message ="{employeeOragnization}")
	private String oragnization;
	public RegisterEmployee() {
		super();
	}
	
	public RegisterEmployee(
			@NotBlank(message = "{employeeFullName}") String fullName,
			@NotBlank(message = "{employeeGender}") String gender,
			@NotBlank(message = "employeeId") String employeeId,
			@NotBlank(message = "{employeeEmailId}") String emailId,
			@NotBlank(message = "{employeePassword}") String password,
			@NotBlank(message = "{employeeConfirmPassword}") String confirmPassword,
			@NotBlank(message = "{employeeContactNo}") String contactNo,
			@NotBlank(message = "{employeeOragnization}") String oragnization) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.employeeId = employeeId;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.contactNo = contactNo;
		this.oragnization = oragnization;
	}

	// getters and setters
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOragnization() {
		return oragnization;
	}

	public void setOragnization(String oragnization) {
		this.oragnization = oragnization;
	}

	
}
