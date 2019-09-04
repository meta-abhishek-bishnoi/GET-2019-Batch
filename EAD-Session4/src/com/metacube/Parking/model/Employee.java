/**
* this is employee model class 
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.model;
public class Employee {
	int sn;
	private String employeeId;
	private String employeeName;
	private String employeeGender;
	private String employeeEmail;
	private String employeePassword;
	private String employeeConfirmPassword;
	private String employeeContact;
	private String oragnization;
	private int isVehicle;
	private int isPlan;
	public Employee() {
		super();
	}
	public Employee(String employeeId, String employeeName,
			String employeeGender, String employeeEmail,
			String employeePassword, String employeeConfirmPassword,
			String employeeContact, String oragnization) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeeConfirmPassword = employeeConfirmPassword;
		this.employeeContact = employeeContact;
		this.oragnization = oragnization;
	}
	public Employee(int sn, String employeeId, String employeeName,
			String employeeGender, String employeeEmail,
			String employeeContact, String oragnization, int isVehicle, int isPlan) {
		super();
		this.sn = sn;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeEmail = employeeEmail;
		this.employeeContact = employeeContact;
		this.oragnization = oragnization;
		this.isVehicle = isVehicle;
		this.isPlan = isPlan;
	}
	
	public Employee(int sn, String employeeId, String employeeName,
			String employeeGender, String employeeEmail,
			String employeePassword, String employeeConfirmPassword,
			String employeeContact, String oragnization, int isVehicle, int isPlan) {
		super();
		this.sn = sn;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeeConfirmPassword = employeeConfirmPassword;
		this.employeeContact = employeeContact;
		this.oragnization = oragnization;
		this.isVehicle = isVehicle;
		this.isPlan = isPlan;
	}
	
	public Employee(String employeeId, String employeeName,
			String employeeEmail, String employeeContact) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeContact = employeeContact;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeConfirmPassword() {
		return employeeConfirmPassword;
	}
	public void setEmployeeConfirmPassword(String employeeConfirmPassword) {
		this.employeeConfirmPassword = employeeConfirmPassword;
	}
	public String getEmployeeContact() {
		return employeeContact;
	}
	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}
	public String getOragnization() {
		return oragnization;
	}
	public void setOragnization(String oragnization) {
		this.oragnization = oragnization;
	}
	public int getIsVehicle() {
		return isVehicle;
	}
	public void setIsVehicle(int isVehicle) {
		this.isVehicle = isVehicle;
	}
	public int isPlan() {
		return isPlan;
	}
	public void setPlan(int isPlan) {
		this.isPlan = isPlan;
	}
	
}
