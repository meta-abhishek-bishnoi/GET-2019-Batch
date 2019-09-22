package com.metacube.parking.hibernatejpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parking.hibernatejpa.model.dto.EmployeeLogin;
import com.metacube.parking.hibernatejpa.model.dto.Friend;
import com.metacube.parking.hibernatejpa.model.pojo.Employee;
import com.metacube.parking.hibernatejpa.model.pojo.Vehicle;
import com.metacube.parking.hibernatejpa.repository.EmployeeRepository;
import com.metacube.parking.hibernatejpa.repository.VehicleRepository;
import com.metacube.parking.hibernatejpa.service.CommonService;
import com.metacube.parking.hibernatejpa.util.DTOMapperUtil;

/**
 * 
 * @author Abhishek Bishnoi
 * This is Implementation for Service
 */
@Service
@Transactional
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private VehicleRepository vehicleRepo;

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#register(com.metacube.parking.hibernatejpa.model.pojo.Employee)
	 */
	@Override
	public boolean register(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#authenticate(com.metacube.parking.hibernatejpa.model.dto.EmployeeLogin)
	 */
	@Override
	public boolean authenticate(EmployeeLogin employeeLogin) {
		Employee employee = employeeRepo.getEmployeeByEmailId(employeeLogin.getUsername());
		if(employeeLogin.getUsername().equals(employee.getEmailId()) && employeeLogin.getPassword().equals(employee.getPassword())){
			return true;
		}else{
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#getEmployeeByMail(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByMail(String email) {
		Employee employee = employeeRepo.getEmployeeByEmailId(email);
		return employee;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#addVehicle(com.metacube.parking.hibernatejpa.model.pojo.Vehicle)
	 */
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#setVehicleFalg(com.metacube.parking.hibernatejpa.model.pojo.Employee)
	 */
	@Override
	public boolean setVehicleFalg(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#loadVehicle(java.lang.String)
	 */
	@Override
	public Vehicle loadVehicle(String employeeId) {
		Vehicle vehicle = vehicleRepo.getVehicleByEmployeeId(employeeId);
		return vehicle;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#savePlan(com.metacube.parking.hibernatejpa.model.pojo.Vehicle)
	 */
	@Override
	public boolean savePlan(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#setPlanFalg(com.metacube.parking.hibernatejpa.model.pojo.Employee)
	 */
	@Override
	public boolean setPlanFalg(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#updateProfileImage(com.metacube.parking.hibernatejpa.model.pojo.Employee)
	 */
	@Override
	public boolean updateProfileImage(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#getFriends(com.metacube.parking.hibernatejpa.model.pojo.Employee)
	 */
	@Override
	public List<Friend> getFriends(Employee employee) {
		List<Employee> listEmployee = employeeRepo.findAll();
		List<Friend> listFriend = new ArrayList<Friend>();
		for(Employee emp : listEmployee){
			Friend friend = DTOMapperUtil.map(emp, Friend.class);
			listFriend.add(friend);
		}
		return listFriend;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernatejpa.service.CommonService#updateUserProfile(com.metacube.parking.hibernatejpa.model.pojo.Employee)
	 */
	@Override
	public boolean updateUserProfile(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

}
