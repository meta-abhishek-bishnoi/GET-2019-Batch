package com.metacube.parking.service;

import java.util.Map;

import com.metacube.parking.dao.TableVehicle;
import com.metacube.parking.model.pojo.Vehicle;

public class LoadVehicle {
	public static Vehicle loadVehicle(String employeeId){
		Map<String,Vehicle> data = TableVehicle.getElements();
		 for (Map.Entry mapElement : data.entrySet()){
			 if(mapElement.getKey().equals(employeeId)){
				 return (Vehicle) mapElement.getValue();
			 }
		 }
		 return null;
	}
}
