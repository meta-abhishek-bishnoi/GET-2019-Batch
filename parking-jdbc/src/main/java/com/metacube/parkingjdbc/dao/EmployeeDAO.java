package com.metacube.parkingjdbc.dao;

import java.util.List;

import com.metacube.parkingjdbc.model.dto.EmployeeLogin;
import com.metacube.parkingjdbc.model.dto.Friend;
import com.metacube.parkingjdbc.model.pojo.Employee;
import com.metacube.parkingjdbc.model.pojo.Vehicle;


public interface EmployeeDAO {
	public boolean addEmployee(Employee employee);
	public boolean authenticate(EmployeeLogin employee);
	public Employee getEmployeeByMail(String email);
	public boolean addVehicle(Vehicle vehicle);
	public boolean setVehicleFalg(Employee employee);
	public Vehicle loadVehicle(String employeeId);
	public boolean savePlan(Vehicle vehicle);
	public boolean savePlanFlag(Employee employee);
	public boolean updateProfileImage(Employee employee);
	public List<Friend> getFriends(Employee employee);
	public boolean updateUserProfile(Employee employee);
}
