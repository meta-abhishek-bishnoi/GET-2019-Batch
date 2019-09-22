/**
* This is a DAO class for friend list  
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.utility.Connector;
import com.metacube.Parking.utility.Query;

public class FriendListDAO {
	/**
	* @param username Employee's Email
	* @param oragnigation Employee's Oragnixzation
	* @return List<Employee> List of Employees
	*/
	public static List<Employee> getFriends(String username, String oragnigation){
		List<Employee> friends = new ArrayList<Employee>();
		Connector connector = new Connector();
		String query = Query.getFriends();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, oragnigation);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String employeeId = resultSet.getString("employee_id");
				String employeeName = resultSet.getString("employee_name");
				String employeeEmail = resultSet.getString("employee_email");
				String employeeContact = resultSet.getString("employee_contact");
				friends.add(new Employee(employeeId, employeeName, employeeEmail, employeeContact));
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return friends;
	}
}
