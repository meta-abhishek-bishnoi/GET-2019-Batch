package com.metacube.Parking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.Vehical;
import com.metacube.Parking.utility.Connector;
import com.metacube.Parking.utility.Query;

public class AddVehicleDAO {
	public boolean addEmployee(Vehical vehicle){
		Connector connector = new Connector();
		String query = Query.addVehicle();
		boolean result = true;
		PreparedStatement prepared = null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			connect.setAutoCommit(false);
			preparedStatement.setString(1, vehicle.getEmployeeEmail());
			preparedStatement.setString(2, vehicle.getVehicleType());
			preparedStatement.setString(3, vehicle.getVehicleNumber());
			preparedStatement.setString(4, vehicle.getDescription());
			preparedStatement.execute();
			query = Query.updateIsVehicle();
			prepared = connect.prepareStatement(query);
			prepared.setInt(1, 1);
			prepared.setString(2, vehicle.getEmployeeEmail());
			int i = prepared.executeUpdate();
			connect.commit();
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				prepared.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean savePlan(double planAmount, String username) {
		Connector connector = new Connector();
		String query = Query.savePlan();
		boolean result = true;
		PreparedStatement prepared = null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setDouble(1, planAmount);
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
			//
			query = Query.updateIsPlan();
			prepared = connect.prepareStatement(query);
			prepared.setInt(1, 1);
			prepared.setString(2,username);
			prepared.executeUpdate();

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}
}
