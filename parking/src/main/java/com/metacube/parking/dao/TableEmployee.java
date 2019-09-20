package com.metacube.parking.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.metacube.parking.model.pojo.Employee;
/**
* @author Abhishek Bishnoi
**/
public class TableEmployee {

	private static TableEmployee single_instance = null;
	private static Map<String,Employee> employees;

	private TableEmployee() {
		employees = new HashMap<String,Employee>();
	}

	public static TableEmployee getInstance() {
		if (single_instance == null)
			single_instance = new TableEmployee();
		return single_instance;
	}
	
	public static boolean addEmployee(String username,Employee employee){
		employees.put(username, employee);
    	return true;
    }
	
	public static Map<String,Employee> getElements(){
    	return employees;
    }
}
