package com.metacube.parking.model.dto;

import javax.validation.constraints.NotBlank;
/**
* @author Abhishek Bishnoi
* This is dto class for editing employee
*/
public class EditEmployee {
	@NotBlank(message="{employeeFullName}")
	private String fullName;
	@NotBlank(message ="{employeeContactNo}")
	private String contactNo;
	public EditEmployee() {
		super();
	}
	public EditEmployee(
			@NotBlank(message = "{employeeFullName}") String fullName,
			@NotBlank(message = "{employeeContactNo}") String contactNo) {
		super();
		this.fullName = fullName;
		this.contactNo = contactNo;
	}
	// getter and setter
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}
