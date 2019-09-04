/**
* This is a DAO class for Authenticate Users 
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.Plan;
import com.metacube.Parking.utility.Connector;
import com.metacube.Parking.utility.Query;

public class PlanDao {
	/**
	*	@param vehicleType type of vehical
	*	@return Plan for that that particular vahical
	*/
	public static Plan getPlan(String vehicleType){
		Connector connector = new Connector();
		String query = Query.getPlan();
		Plan plan = null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, vehicleType);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int sn = resultSet.getInt("sn");
				String type = resultSet.getString("type");
				double daily = resultSet.getDouble("daily");
				double monthly = resultSet.getDouble("monthly");
				double yearly = resultSet.getDouble("yearly");
				plan = new Plan(sn,type,daily,monthly,yearly);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return plan;
	}
	/**
	* @param username 
	* @return String vehical type
	*/
	public static String getVehicleType(String username){
		Connector connector = new Connector();
		String query = Query.getVehicleType();
		String type = null;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				type = resultSet.getString("type");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return type;
	}
}
