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

/**
 * 
 * @author Abhishek Bishnoi
 * This is service implementation
 */
@Service
@Transactional
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#register(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean register(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#authenticate(com.metacube.parking.hibernate.model.dto.EmployeeLogin)
	 */
	@Override
	public boolean authenticate(EmployeeLogin employee) {
		return employeeDAO.authenticate(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#getEmployeeByMail(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByMail(String email) {
		return employeeDAO.getEmployeeByMail(email);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#addVehicle(com.metacube.parking.hibernate.model.pojo.Vehicle)
	 */
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		return employeeDAO.addVehicle(vehicle);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#setVehicleFalg(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean setVehicleFalg(Employee employee) {
		return employeeDAO.setVehicleFalg(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#loadVehicle(java.lang.String)
	 */
	@Override
	public Vehicle loadVehicle(String employeeId) {
		return employeeDAO.loadVehicle(employeeId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#savePlan(com.metacube.parking.hibernate.model.pojo.Vehicle)
	 */
	@Override
	public boolean savePlan(Vehicle vehicle) {
		return employeeDAO.savePlan(vehicle);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#setPlanFalg(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean setPlanFalg(Employee employee) {
		return employeeDAO.savePlanFlag(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#updateProfileImage(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean updateProfileImage(Employee employee) {
		return employeeDAO.updateProfileImage(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#getFriends(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public List<Friend> getFriends(Employee employee) {
		return employeeDAO.getFriends(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.service.CommonService#updateUserProfile(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean updateUserProfile(Employee employee) {
		return employeeDAO.updateUserProfile(employee);
	}

}
