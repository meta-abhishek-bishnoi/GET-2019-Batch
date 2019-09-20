package com.metacube.parking.model.pojo;

import com.metacube.parking.model.dto.EditEmployee;
import com.metacube.parking.model.dto.Friends;
import com.metacube.parking.model.dto.RegisterEmployee;
/**
* @author Abhishek Bishnoi
* This is DAO class of employee
*/
public class Employee {
	private  int id;
	private String employeeName;
	private String employeeGender;
	private String employeeId;
	private String emailId;
	private String employeePassword;
	private String employeeContactNo;
	private String employeeOragnization;
	private String profileImageUrl;
	private boolean hasVehical ;
	private boolean hasPlan ;
	
	public Employee() {
		super();
	}

	
	public Employee(String employeeName, String employeeGender,
			String employeeId, String emailId, String employeePassword,
			String employeeContactNo, String employeeOragnization,
			String profileImageUrl, boolean hasVehical, boolean hasPlan) {
		super();
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeId = employeeId;
		this.emailId = emailId;
		this.employeePassword = employeePassword;
		this.employeeContactNo = employeeContactNo;
		this.employeeOragnization = employeeOragnization;
		this.profileImageUrl = profileImageUrl;
		this.hasVehical = hasVehical;
		this.hasPlan = hasPlan;
	}

	// getter and setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeGender() {
		return employeeGender;
	}


	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
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


	public String getEmployeePassword() {
		return employeePassword;
	}


	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}


	public String getEmployeeContactNo() {
		return employeeContactNo;
	}


	public void setEmployeeContactNo(String employeeContactNo) {
		this.employeeContactNo = employeeContactNo;
	}


	public String getEmployeeOragnization() {
		return employeeOragnization;
	}


	public void setEmployeeOragnization(String employeeOragnization) {
		this.employeeOragnization = employeeOragnization;
	}


	public String getProfileImageUrl() {
		return profileImageUrl;
	}


	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}


	public boolean isHasVehical() {
		return hasVehical;
	}


	public void setHasVehical(boolean hasVehical) {
		this.hasVehical = hasVehical;
	}


	public boolean isHasPlan() {
		return hasPlan;
	}


	public void setHasPlan(boolean hasPlan) {
		this.hasPlan = hasPlan;
	}


	public void registerEmployee(int id, RegisterEmployee registerEmployee){
		this.id = id;
		this.employeeName = registerEmployee.getFullName();
		this.employeeGender = registerEmployee.getGender();
		this.employeeId = registerEmployee.getEmployeeId();
		this.emailId = registerEmployee.getEmailId();
		this.employeePassword = registerEmployee.getPassword();
		this.employeeContactNo = registerEmployee.getContactNo();
		this.employeeOragnization = registerEmployee.getOragnization();
		this.profileImageUrl = "/images/default.jpg";
		this.hasVehical = false;
		this.hasPlan  = false;
	}

	public void editProfile(EditEmployee editEmployee) {
		this.employeeName = editEmployee.getFullName();
		this.employeeContactNo = editEmployee.getContactNo();
	}
	
	public Friends getFrindObject(){
		return new Friends(profileImageUrl, employeeName, employeeContactNo,employeeId);
	}
}
