package com.metacube.parking.hibernate.dao;

import java.util.List;

import com.metacube.parking.hibernate.model.dto.EmployeeLogin;
import com.metacube.parking.hibernate.model.dto.Friend;
import com.metacube.parking.hibernate.model.pojo.Employee;
import com.metacube.parking.hibernate.model.pojo.Vehicle;
/**
 * @author Abhishek Bishnoi
 */
public interface EmployeeDAO {
	/**
	 * @param employee
	 * @return boolean value 
	 * Adding Employee to Database
	 */
	public boolean addEmployee(Employee employee);
	/**
	 * @param employee
	 * @return boolean value as result
	 * authenticating users
	 */
	public boolean authenticate(EmployeeLogin employee);
	/**
	 * @param email 
	 * @return Employee
	 * get Employee by email
	 */
	public Employee getEmployeeByMail(String email);
	/**
	 * @param vehicle
	 * @return boolean value
	 * for inserting Vehicle to DB
	 */
	public boolean addVehicle(Vehicle vehicle);
	/**
	 * @param employee
	 * @return boolean
	 * update Vehicle flag 
	 */
	public boolean setVehicleFalg(Employee employee);
	/**
	 * @param employeeId
	 * @return Vehicle 
	 * getting Vehicle from employeeId
	 */
	public Vehicle loadVehicle(String employeeId);
	/**
	 * @param vehicle
	 * @return boolean value
	 * saving plan into db
	 */
	public boolean savePlan(Vehicle vehicle);
	/**
	 * 
	 * @param employee
	 * @return boolean value
	 * update save plan
	 */
	public boolean savePlanFlag(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return boolean value
	 * updating Profile Image
	 */
	public boolean updateProfileImage(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return List<Friend>
	 * 
	 */
	public List<Friend> getFriends(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return boolean value
	 */
	public boolean updateUserProfile(Employee employee);
}
