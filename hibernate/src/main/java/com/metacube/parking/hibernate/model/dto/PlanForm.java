package com.metacube.parking.hibernate.model.dto;

import javax.validation.constraints.NotBlank;

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
