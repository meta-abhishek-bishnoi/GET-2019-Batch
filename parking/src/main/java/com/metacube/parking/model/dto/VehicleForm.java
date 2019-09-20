package com.metacube.parking.model.dto;

import javax.validation.constraints.NotBlank;
/**
* @author Abhishek Bishnoi
* This is dto class for Vehicle Form
*/
public class VehicleForm {
	@NotBlank(message="{vehicleName}")
	private String name;
	@NotBlank(message="{vehicleType}")
	private String type;
	@NotBlank(message="{vehicleNumber}")
	private String number;
	@NotBlank(message="{employeeId}")
	private String employeeId;
	private String identification;
	public VehicleForm() {
		super();
	}
	public VehicleForm(@NotBlank(message = "{vehicleName}") String name,
			@NotBlank(message = "{vehicleType}") String type,
			@NotBlank(message = "{vehicleNumber}") String number,
			@NotBlank(message = "{employeeId}") String employeeId,
			String identification) {
		super();
		this.name = name;
		this.type = type;
		this.number = number;
		this.employeeId = employeeId;
		this.identification = identification;
	}
	// getter and setter
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
	
}
