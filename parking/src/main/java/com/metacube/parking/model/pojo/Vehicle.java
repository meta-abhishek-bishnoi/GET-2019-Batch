package com.metacube.parking.model.pojo;

import javax.validation.constraints.NotBlank;

import com.metacube.parking.model.dto.RegisterEmployee;
import com.metacube.parking.model.dto.VehicleForm;
/**
* @author Abhishek Bishnoi
* This is DAO class of vehicle
*/
public class Vehicle {
	private int id;
	private String name;
	private String type;
	private String number;
	private String employeeId;
	private String identification;
	private double amount;
	public Vehicle() {
		super();
	}
	public Vehicle(int id, String name, String type, String number,
			String employeeId, String identification, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.number = number;
		this.employeeId = employeeId;
		this.identification = identification;
		this.amount = amount;
	}
	// getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void registerVehicle(int id, VehicleForm vehicleForm){
		this.id = id;
		this.name = vehicleForm.getName();
		this.type = vehicleForm.getType();
		this.number = vehicleForm.getNumber();
		this.employeeId = vehicleForm.getEmployeeId();
		this.identification = vehicleForm.getIdentification();
	}
}
