package com.metacube.parking.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.parking.hibernatejpa.model.pojo.Employee;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Integer>{

	public Employee getEmployeeByEmailId(String username);

}
