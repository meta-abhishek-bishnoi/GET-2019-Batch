package com.metacube.parking.hibernate.util;

public class PlanAmount {
	private double daily;
	private double monthly;
	private double yearly;
	public PlanAmount(double daily, double monthly, double yearly) {
		super();
		this.daily = daily;
		this.monthly = monthly;
		this.yearly = yearly;
	}
	public PlanAmount() {
		super();
	}
	public double getDaily() {
		return daily;
	}
	public double getMonthly() {
		return monthly;
	}
	public double getYearly() {
		return yearly;
	}
	public PlanAmount getAmount(String type){
		PlanAmount resultObject = null;
		switch(type){
		case "byCycle": resultObject = new PlanAmount(5, 100, 500);
			break;
		case "motorCycle": resultObject = new PlanAmount(10, 200, 1000);
			break;
		case "fourWheeler": resultObject = new PlanAmount(20, 500, 3500);
			break;
		}
		return resultObject;
	}
}
