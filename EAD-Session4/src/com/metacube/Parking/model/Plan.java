/**
* this is plan model class 
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.model;

public class Plan {
	int sn;
	String vehicalType;
	double daily;
	double monthly;
	double yearly;
	public Plan() {
		super();
	}
	public Plan(int sn, String vehicalType, double daily, double monthly,
			double yearly) {
		super();
		this.sn = sn;
		this.vehicalType = vehicalType;
		this.daily = daily;
		this.monthly = monthly;
		this.yearly = yearly;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getVehicalType() {
		return vehicalType;
	}
	public void setVehicalType(String vehicalType) {
		this.vehicalType = vehicalType;
	}
	public double getDaily() {
		return daily;
	}
	public void setDaily(double daily) {
		this.daily = daily;
	}
	public double getMonthly() {
		return monthly;
	}
	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}
	public double getYearly() {
		return yearly;
	}
	public void setYearly(double yearly) {
		this.yearly = yearly;
	}
	
}
