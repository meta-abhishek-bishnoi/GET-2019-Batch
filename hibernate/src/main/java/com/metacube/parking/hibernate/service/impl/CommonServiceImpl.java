package com.metacube.parking.hibernate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parking.hibernate.dao.EmployeeDAO;
import com.metacube.parking.hibernate.model.dto.EmployeeLogin;
import com.metacube.parking.hibernate.model.dto.Friend;
import com.metacube.parking.hibernate.model.pojo.Employee;
import com.metacube.parking.hibernate.model.pojo.Vehicle;
import com.metacube.parking.hibernate.service.CommonService;


@Service
@Transactional
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public boolean register(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public boolean authenticate(EmployeeLogin employee) {
		return employeeDAO.authenticate(employee);
	}

	@Override
	public Employee getEmployeeByMail(String email) {
		return employeeDAO.getEmployeeByMail(email);
	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		return employeeDAO.addVehicle(vehicle);
		
	}

	@Override
	public boolean setVehicleFalg(Employee employee) {
		return employeeDAO.setVehicleFalg(employee);
	}

	@Override
	public Vehicle loadVehicle(String employeeId) {
		return employeeDAO.loadVehicle(employeeId);
	}

	@Override
	public boolean savePlan(Vehicle vehicle) {
		return employeeDAO.savePlan(vehicle);
	}

	@Override
	public boolean setPlanFalg(Employee employee) {
		return employeeDAO.savePlanFlag(employee);
	}

	@Override
	public boolean updateProfileImage(Employee employee) {
		return employeeDAO.updateProfileImage(employee);
	}

	@Override
	public List<Friend> getFriends(Employee employee) {
		return employeeDAO.getFriends(employee);
	}

	@Override
	public boolean updateUserProfile(Employee employee) {
		return employeeDAO.updateUserProfile(employee);
	}

}
