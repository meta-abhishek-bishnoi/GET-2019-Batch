package com.metacube.parking.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.parking.model.pojo.Vehicle;


public class TableVehicle {
	private static TableVehicle single_instance = null;
	private static Map<String,Vehicle> vehicles;

	private TableVehicle() {
		vehicles = new HashMap<String,Vehicle>();
	}

	public static TableVehicle getInstance() {
		if (single_instance == null)
			single_instance = new TableVehicle();
		return single_instance;
	}
	
	public static boolean addVehicle(String username,Vehicle vehicle){
		vehicles.put(username, vehicle);
    	return true;
    }
	
	public static Map<String,Vehicle> getElements(){
    	return vehicles;
    }
}
