package com.metacube.parkingjdbc.model.pojo;

public class Employee {
	private Integer id;
	private String employeeId;
	private String fullName;
	private String gender;
	private String emailId;
	private String password;
	private String contactNo;
	private String organisation;
	private String profileImageUrl = "/images/default.jpg";
	private boolean hasVehicle = false;
	private boolean hasPlan = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public boolean isHasVehicle() {
		return hasVehicle;
	}

	public void setHasVehicle(boolean hasVehicle) {
		this.hasVehicle = hasVehicle;
	}

	public boolean isHasPlan() {
		return hasPlan;
	}

	public void setHasPlan(boolean hasPlan) {
		this.hasPlan = hasPlan;
	}

}
