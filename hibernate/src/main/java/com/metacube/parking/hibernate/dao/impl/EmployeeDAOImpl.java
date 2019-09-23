package com.metacube.parking.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;








import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parking.hibernate.dao.EmployeeDAO;
import com.metacube.parking.hibernate.model.dto.EmployeeLogin;
import com.metacube.parking.hibernate.model.dto.Friend;
import com.metacube.parking.hibernate.model.pojo.Employee;
import com.metacube.parking.hibernate.model.pojo.Vehicle;
import com.metacube.parking.hibernate.util.DTOMapperUtil;
/**
 * @author Abhishek Bishnoi
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#addEmployee(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean addEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#authenticate(com.metacube.parking.hibernate.model.dto.EmployeeLogin)
	 */
	@Override
	public boolean authenticate(EmployeeLogin employeeLogin) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM Employee as employee WHERE employee.emailId = :emailId";
		Query<Employee> query = session.createQuery(selectQuery, Employee.class);
		query.setParameter("emailId", employeeLogin.getUsername());
		Employee employee = query.getSingleResult();
		if(employeeLogin.getUsername().equals(employee.getEmailId()) && employeeLogin.getPassword().equals(employee.getPassword())){
			return true;
		}else{
			return false;
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#getEmployeeByMail(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByMail(String email) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM Employee as employee WHERE employee.emailId = :emailId";
		Query<Employee> query = session.createQuery(selectQuery, Employee.class);
		query.setParameter("emailId",email);
		Employee employee = query.getSingleResult();
		return employee;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#addVehicle(com.metacube.parking.hibernate.model.pojo.Vehicle)
	 */
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(vehicle);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#setVehicleFalg(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean setVehicleFalg(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#loadVehicle(java.lang.String)
	 */
	@Override
	public Vehicle loadVehicle(String employeeId) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM Vehicle as vehicle WHERE vehicle.employeeId = :employeeId";
		Query<Vehicle> query = session.createQuery(selectQuery, Vehicle.class);
		query.setParameter("employeeId",employeeId);
		Vehicle vehicle = query.getSingleResult();
		return vehicle;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#savePlan(com.metacube.parking.hibernate.model.pojo.Vehicle)
	 */
	@Override
	public boolean savePlan(Vehicle vehicle) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(vehicle);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#savePlanFlag(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean savePlanFlag(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#updateProfileImage(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean updateProfileImage(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#getFriends(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public List<Friend> getFriends(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> queryEmployee = session.createQuery("from Employee ",Employee.class);
		List<Employee> listEmployee = queryEmployee.getResultList();
		List<Friend> listFriend = new ArrayList<Friend>();
		for(Employee emp : listEmployee){
			Friend friend = DTOMapperUtil.map(emp, Friend.class);
			listFriend.add(friend);
		}
		return listFriend;
	}

	/*
	 * (non-Javadoc)
	 * @see com.metacube.parking.hibernate.dao.EmployeeDAO#updateUserProfile(com.metacube.parking.hibernate.model.pojo.Employee)
	 */
	@Override
	public boolean updateUserProfile(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return true;
	}

}
