package com.metacube.parking.hibernate.service;

import java.util.List;

import com.metacube.parking.hibernate.model.dto.EmployeeLogin;
import com.metacube.parking.hibernate.model.dto.Friend;
import com.metacube.parking.hibernate.model.pojo.Employee;
import com.metacube.parking.hibernate.model.pojo.Vehicle;


public interface CommonService {
	/**
	 * This method is used to register employee in db
	 * @return boolean value
	 */
	public abstract boolean register(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public abstract boolean authenticate(EmployeeLogin employee);
	/**
	 * 
	 * @param email
	 * @return
	 */
	public abstract Employee getEmployeeByMail(String email);
	/**
	 * 
	 * @param vehicle
	 */
	public abstract boolean addVehicle(Vehicle vehicle);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public abstract boolean setVehicleFalg(Employee employee);
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	public abstract Vehicle loadVehicle(String employeeId);
	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	public abstract boolean savePlan(Vehicle vehicle);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public abstract boolean setPlanFalg(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public abstract boolean updateProfileImage(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public abstract List<Friend> getFriends(Employee employee);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public abstract boolean updateUserProfile(Employee employee);
}
