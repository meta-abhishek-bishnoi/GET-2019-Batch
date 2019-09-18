package com.metacube.parking.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.parking.hibernatejpa.model.pojo.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	public Vehicle getVehicleByEmployeeId(String employeeId);

}
