package com.metacube.Parking.utility;

public class Query {
	public static String registerEmployee(){
		return "insert into employee(employee_id, employee_name, employee_gender, employee_email, "+
				"employee_password, employee_contact, employee_oragnization) values(?,?,?,?,?,?,?)";
	}
	public static String login(){
		return "select count(*) as count from employee where employee_email = ? AND employee_password = ?";
	}
	public static String getAuthUser(){
		return "select sn, employee_id, employee_name, employee_gender, employee_email, employee_contact, "+
				"employee_oragnization, isVehicle, isPlan from employee where employee_email = ?";
	}
	public static String addVehicle(){
		return "insert into vehicle(employee_email, vehicle_type, vehicle_number, description) values(?,?,?,?)";
	}
	public static String updateIsVehicle(){
		return "update employee set isVehicle = ? where employee_email = ?";
	}
	public static String getPlan(){
		return "select sn, vehicle_type as type, daily, monthly, yearly from plans where vehicle_type = ?";
	}
	public static String getVehicleType(){
		return "select vehicle_type as type from vehicle where employee_email = ?";
	}
	public static String savePlan(){
		return "update vehicle set amount = ? where employee_email = ?";
	}
	public static String updateIsPlan(){
		return "update employee set isPlan = ? where employee_email = ?";
	}
	public static String getvehical(){
		return "select sn, employee_email, vehicle_type, "+
				"vehicle_number, description, amount from vehicle where employee_email = ?";
	}
	public static String getFriends(){
		return "select employee_id, employee_name, employee_email, employee_contact "+
				" from employee where employee_email != ? and employee_oragnization=?";
	}
}
