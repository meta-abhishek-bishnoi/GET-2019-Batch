package com.metacube.parkingjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingjdbc.model.pojo.Employee;

/**
 * @author Abhishek Bishnoi
 * Employee Mapper Class
 */
public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		Employee employee = new Employee();
		employee.setId(resultSet.getInt("id"));
		employee.setEmployeeId(resultSet.getString("employeeId"));
		employee.setFullName(resultSet.getString("fullName"));
		employee.setGender(resultSet.getString("gender"));
		employee.setEmailId(resultSet.getString("emailId"));
		employee.setPassword(resultSet.getString("password"));
		employee.setContactNo(resultSet.getString("contactNo"));
		employee.setOrganisation(resultSet.getString("organisation"));
		employee.setProfileImageUrl(resultSet.getString("profileImageUrl"));
		employee.setHasVehicle(resultSet.getBoolean("hasVehicle"));
		employee.setHasPlan(resultSet.getBoolean("hasPlan"));
		return employee;
	}

}
