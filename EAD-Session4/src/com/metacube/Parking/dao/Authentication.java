/**
* This is a DAO class for Authentication
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.Vehical;
import com.metacube.Parking.utility.Connector;
import com.metacube.Parking.utility.Query;

public class Authentication {
	/**
	* @param username employeeEmail Id
	* @param password Employee Password
	* @return boolean return true or false for authentiction
	*/
	public static boolean authenticate(String username, String password){
		Connector connector = new Connector();
		String query = Query.login();
		boolean result = true;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int count = resultSet.getInt("count");
				if(count>0){
					result = true;
				}else{
					result = false;
				}
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	/**
	* @param username EmployeeEmail
	* @return Employee Object after authentication
	*/
	public static Employee getUser(String username) {
		Connector connector = new Connector();
		String query = Query.getAuthUser();
		Employee employee=null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int sn = resultSet.getInt("sn");
				String employeeId = resultSet.getString("employee_id");
				String employeeName = resultSet.getString("employee_name");
				String employeeGender = resultSet.getString("employee_gender");
				String employeeEmail = resultSet.getString("employee_email");
				String employeeContact = resultSet.getString("employee_contact");
				String oragnization = resultSet.getString("employee_oragnization");
				int hasVehicle = resultSet.getInt("isVehicle");
				int hasPlan = resultSet.getInt("isPlan");
				employee = new Employee(sn, employeeId, employeeName, employeeGender, employeeEmail, employeeContact, oragnization, hasVehicle, hasPlan);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return employee;
	}
	/**
	* @param username EmployeeEmail
	* @return Vehical Object for that user
	*/
	public static Vehical getVehicle(String username){
		Connector connector = new Connector();
		String query = Query.getvehical();
		Vehical vahical=null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int sn = resultSet.getInt("sn");
				String employeeEmail = resultSet.getString("employee_email");
				String vehicleType = resultSet.getString("vehicle_type");
				String vehicleNumber = resultSet.getString("vehicle_number");
				String description = resultSet.getString("description");
				double amount = resultSet.getDouble("amount");
				vahical = new Vehical(sn, employeeEmail, vehicleType, vehicleNumber, description, amount);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return vahical;
	}
}
