package com.metacube.parking.service;

import java.util.Map;

import com.metacube.parking.dao.TableEmployee;
import com.metacube.parking.model.dto.EmployeeLogin;
import com.metacube.parking.model.pojo.Employee;

public class Authentication {
	public static boolean authenticate (EmployeeLogin employeeLogin){
		 Map<String,Employee> data = TableEmployee.getElements();
		 for (Map.Entry mapElement : data.entrySet()){
			 Employee employee = (Employee) mapElement.getValue();		 
			if(mapElement.getKey().equals(employeeLogin.getUsername()) && employee.getEmployeePassword().equals(employeeLogin.getPassword())){
				return true;
			}
		 }
		 return false;
	}
}
