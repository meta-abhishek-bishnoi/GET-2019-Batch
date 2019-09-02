package com.metacube.Parking.model;

import java.util.Date;

public class Vehical {
	int sn;
	String employeeEmail;
	String vehicleType;
	String vehicleNumber;
	String description;
	double amount;

	public Vehical() {
		super();
	}
	public Vehical(int sn, String employeeEmail, String vehicleType,
			String vehicleNumber, String description,
			double amount) {
		super();
		this.sn = sn;
		this.employeeEmail = employeeEmail;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.description = description;
		this.amount = amount;
	}
	public void addVehical(String employeeEmail, String vehicleType, String vehicleNumber, String description){
		this.employeeEmail = employeeEmail;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.description = description;
	}
	public void addPlan(String employeeEmail, double amount){
		this.amount = amount;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
