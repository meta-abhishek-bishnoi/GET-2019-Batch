package com.metacube.parkingjdbc.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingjdbc.dao.EmployeeDAO;
import com.metacube.parkingjdbc.model.dto.EmployeeLogin;
import com.metacube.parkingjdbc.model.dto.Friend;
import com.metacube.parkingjdbc.model.pojo.Employee;
import com.metacube.parkingjdbc.model.pojo.Vehicle;
import com.metacube.parkingjdbc.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private EmployeeDAO employeeDAO;

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#register(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean register(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#authenticate(com.metacube.parkingjdbc.model.dto.EmployeeLogin)
	 */
	@Override
	public boolean authenticate(EmployeeLogin employee) {
		return employeeDAO.authenticate(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#getEmployeeByMail(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByMail(String email) {
		return employeeDAO.getEmployeeByMail(email);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#addVehicle(com.metacube.parkingjdbc.model.pojo.Vehicle)
	 */
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		return employeeDAO.addVehicle(vehicle);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#setVehicleFalg(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean setVehicleFalg(Employee employee) {
		return employeeDAO.setVehicleFalg(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#loadVehicle(java.lang.String)
	 */
	@Override
	public Vehicle loadVehicle(String employeeId) {
		return employeeDAO.loadVehicle(employeeId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#savePlan(com.metacube.parkingjdbc.model.pojo.Vehicle)
	 */
	@Override
	public boolean savePlan(Vehicle vehicle) {
		return employeeDAO.savePlan(vehicle);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#setPlanFalg(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean setPlanFalg(Employee employee) {
		return employeeDAO.savePlanFlag(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#updateProfileImage(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean updateProfileImage(Employee employee) {
		return employeeDAO.updateProfileImage(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#getFriends(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public List<Friend> getFriends(Employee employee) {
		return employeeDAO.getFriends(employee);
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.service.CommonService#updateUserProfile(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean updateUserProfile(Employee employee) {
		return employeeDAO.updateUserProfile(employee);
	}

}
