package com.metacube.Parking.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.utility.Connector;
import com.metacube.Parking.utility.Query;

public class InsertEmployees {
	public boolean addEmployee(Employee employee){
		Connector connector = new Connector();
		String query = Query.registerEmployee();
		boolean result = true;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeeGender());
			preparedStatement.setString(4, employee.getEmployeeEmail());
			preparedStatement.setString(5, employee.getEmployeePassword());
			preparedStatement.setString(6, employee.getEmployeeContact());
			preparedStatement.setString(7, employee.getOragnization());
			preparedStatement.execute();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}
}
