package com.metacube.parking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.metacube.parking.dao.TableEmployee;
import com.metacube.parking.model.dto.Friends;
import com.metacube.parking.model.pojo.Employee;
/**
* @author Abhishek Bishnoi
* This is Service Class Retuen Employee Object
*/
public class LoadProfile {
	/**
	* @param String emailId
	* @return Employee
	*/
	public static Employee LoadProfile(String email){
		 Map<String,Employee> data = TableEmployee.getElements();
		 for (Map.Entry mapElement : data.entrySet()){	 
			if(mapElement.getKey().equals(email)){
				return (Employee) mapElement.getValue();
			}
		 }
		 return null;
	}
	/**
	* @param String emailId
	* @param String oragnization
	* @return Return List<Friends>
	*/
	public static List<Friends> loadFriends(String email, String oragnization){
		List<Friends> list = new ArrayList<Friends>();
		Map<String,Employee> data = TableEmployee.getElements();
		 for (Map.Entry mapElement : data.entrySet()){	 
			if(!mapElement.getKey().equals(email)){
				Employee employee = (Employee) mapElement.getValue();
				if(employee.getEmployeeOragnization().equals(oragnization)){
					list.add(employee.getFrindObject());
				}
			}
		 }
		return list;
	}
}
