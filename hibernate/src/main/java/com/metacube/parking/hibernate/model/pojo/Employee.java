package com.metacube.parking.hibernate.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="employeeId")
	private String employeeId;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="organisation")
	private String organisation;
	
	@Column(name="profileImageUrl")
	private String profileImageUrl = "/images/default.jpg";
	
	@Column(name="hasVehicle")
	private boolean hasVehicle = false;
	
	@Column(name="hasPlan")
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
