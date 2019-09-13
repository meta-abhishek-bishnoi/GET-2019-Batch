package com.metacube.parkingjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingjdbc.model.pojo.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet resultSet, int i) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(resultSet.getInt("id"));
		vehicle.setEmployeeId(resultSet.getString("employeeId"));
		vehicle.setVehicleName(resultSet.getString("vehicleName"));
		vehicle.setVehicleType(resultSet.getString("vehicleType"));
		vehicle.setVehicleNumber(resultSet.getString("vehicleNumber"));
		vehicle.setIdentification(resultSet.getString("identification"));
		vehicle.setAmount(resultSet.getDouble("amount"));
		return vehicle;
	}

}
