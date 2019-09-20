package com.metacube.parking.model.dto;

import javax.validation.constraints.NotBlank;
/**
* @author Abhishek Bishnoi
* This is dto class for Saving Plan
*/
public class PlanForm {
	@NotBlank(message="{vehicleType}")
	private String type;
	private double amount;
	public PlanForm() {
		super();
	}
	public PlanForm(@NotBlank(message = "{vehicleType}") String type,
			@NotBlank(message = "{planAmount}") double amount) {
		super();
		this.type = type;
		this.amount = amount;
	}
	// getter and setter
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
