package com.metacube.parking.hibernate.model.dto;

import javax.validation.constraints.NotBlank;
/**
 * 
 * @author Abhishek Bishnoi
 * DTO vehicle Form
 */
public class VehicleForm {
	@NotBlank(message = "{vehicleName}")
	private String vehicleName;
	@NotBlank(message = "{vehicleType}")
	private String vehicleType;
	@NotBlank(message = "{vehicleNumber}")
	private String vehicleNumber;
	@NotBlank(message = "{employeeId}")
	private String employeeId;
	private String identification;

	public VehicleForm() {
		super();
	}

	public VehicleForm(@NotBlank(message = "{vehicleName}") String vehicleName,
			@NotBlank(message = "{vehicleType}") String vehicleType,
			@NotBlank(message = "{vehicleNumber}") String vehicleNumber,
			@NotBlank(message = "{employeeId}") String employeeId,
			String identification) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.employeeId = employeeId;
		this.identification = identification;
	}

	// getter and setter
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
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
