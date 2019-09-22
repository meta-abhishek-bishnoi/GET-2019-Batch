package com.metacube.parkingjdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.metacube.parkingjdbc.dao.EmployeeDAO;
import com.metacube.parkingjdbc.mapper.EmployeeMapper;
import com.metacube.parkingjdbc.mapper.FriendMapper;
import com.metacube.parkingjdbc.mapper.VehicleMapper;
import com.metacube.parkingjdbc.model.dto.EmployeeLogin;
import com.metacube.parkingjdbc.model.dto.Friend;
import com.metacube.parkingjdbc.model.pojo.Employee;
import com.metacube.parkingjdbc.model.pojo.Vehicle;
/**
 * @author Abhishek Bishnoi
 * This is DAO Class for DB opeartions
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	// JDBC Template Object
	private JdbcTemplate jdbcTemplate;
	/**
	 * DBMS Queries
	 */
	private final String SQL_INSERT_EMPLOYEE = "insert into employee(employeeId, fullName, gender, emailId, password, "+
					" contactNo, organisation, profileImageUrl, hasVehicle, hasPlan) values(?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_QUERY_AUTHENTICATE = "SELECT emailID FROM employee WHERE emailId=? AND password=?";
	private final String SQL_QUERY_GET_EMPLOYEE_BY_EMAIL = "select * from employee where emailId = ?";
	private final String SQL_QUERY_INSERT_VEHICLE = "insert into vehicle(employeeId, vehicleName, vehicleType, vehicleNumber, identification, amount) values(?,?,?,?,?,?)";
	private final String SQl_QUERY_UPDATE_HAS_VEHICLE ="update employee set hasVehicle = ? where id = ?";
	private final String SQl_QUERY_GET_VEHICLE = "select * from vehicle where employeeId = ?";
	private final String SQL_QUERY_UPDATE_HAS_PLAN = "update employee set hasPlan = ? where id = ?";
	private final String SQL_QUERY_UPDATE_PLAN_AMOUNT = "update vehicle set amount = ? where id = ?";
	private final String SQL_QUERY_UPLOAD_IMAGE = "update employee set profileImageUrl = ? where id = ?";
	private final String SQl_QUERY_FRIEND_LIST = "select profileImageUrl, fullName, contactNo, emailId from employee "+
						" where id not in(?) and organisation = ?";
	private final String SQl_QUERY_UPDATE_EMPLOYEE ="update employee set fullName = ?, contactNo = ? where id = ?";
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#addEmployee(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean addEmployee(Employee employee) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_EMPLOYEE,
                		new String[] { "id"}); 
                ps.setString(1, employee.getEmployeeId());
                ps.setString(2, employee.getFullName());
                ps.setString(3, employee.getGender());
                ps.setString(4, employee.getEmailId());
                ps.setString(5, employee.getPassword());
                ps.setString(6, employee.getContactNo());
                ps.setString(7, employee.getOrganisation());
                ps.setString(8, employee.getProfileImageUrl());
                ps.setBoolean(9, employee.isHasVehicle());
                ps.setBoolean(10, employee.isHasPlan());
                return ps;
            }
        }, keyHolder);
		employee.setId(keyHolder.getKey().intValue());	 
		return row > 0 ?true : false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#authenticate(com.metacube.parkingjdbc.model.dto.EmployeeLogin)
	 */
	@Override
	public boolean authenticate(EmployeeLogin employee) {
		boolean userExists = false;
		String email = jdbcTemplate.queryForObject(SQL_QUERY_AUTHENTICATE, new Object[] {
				employee.getUsername(), employee.getPassword() }, String.class);
		if(employee.getUsername().equals(email)){
			userExists = true;
		}
		return userExists;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#getEmployeeByMail(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByMail(String email) {
		return jdbcTemplate.queryForObject(SQL_QUERY_GET_EMPLOYEE_BY_EMAIL, new Object[] { email }, new EmployeeMapper());
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#addVehicle(com.metacube.parkingjdbc.model.pojo.Vehicle)
	 */
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_QUERY_INSERT_VEHICLE,
                		new String[] { "id"}); 
                ps.setString(1, vehicle.getEmployeeId());
                ps.setString(2, vehicle.getVehicleName());
                ps.setString(3, vehicle.getVehicleType());
                ps.setString(4, vehicle.getVehicleNumber());
                ps.setString(5, vehicle.getIdentification());
                ps.setDouble(6, vehicle.getAmount());
                return ps;
            }
        }, keyHolder);
		vehicle.setId(keyHolder.getKey().intValue());	 
		return row > 0 ?true : false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#setVehicleFalg(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean setVehicleFalg(Employee employee) {
		return jdbcTemplate.update(SQl_QUERY_UPDATE_HAS_VEHICLE, employee.isHasVehicle(), employee.getId()) > 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#loadVehicle(java.lang.String)
	 */
	@Override
	public Vehicle loadVehicle(String employeeId) {
		return jdbcTemplate.queryForObject(SQl_QUERY_GET_VEHICLE, new Object[] { employeeId }, new VehicleMapper());
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#savePlan(com.metacube.parkingjdbc.model.pojo.Vehicle)
	 */
	@Override
	public boolean savePlan(Vehicle vehicle) {
		return jdbcTemplate.update(SQL_QUERY_UPDATE_PLAN_AMOUNT, vehicle.getAmount(), vehicle.getId()) > 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#savePlanFlag(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean savePlanFlag(Employee employee) {
		return jdbcTemplate.update(SQL_QUERY_UPDATE_HAS_PLAN, employee.isHasPlan(), employee.getId()) > 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#updateProfileImage(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean updateProfileImage(Employee employee) {
		return jdbcTemplate.update(SQL_QUERY_UPLOAD_IMAGE, employee.getProfileImageUrl(), employee.getId()) > 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#getFriends(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public List<Friend> getFriends(Employee employee) {
		return jdbcTemplate.query(SQl_QUERY_FRIEND_LIST, new FriendMapper(), employee.getId(),employee.getOrganisation());
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parkingjdbc.dao.EmployeeDAO#updateUserProfile(com.metacube.parkingjdbc.model.pojo.Employee)
	 */
	@Override
	public boolean updateUserProfile(Employee employee) {
		return jdbcTemplate.update(SQl_QUERY_UPDATE_EMPLOYEE, employee.getFullName(),employee.getContactNo() ,employee.getId()) > 0;
	}
}
