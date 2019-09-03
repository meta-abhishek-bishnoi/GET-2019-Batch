package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.AddVehicleDAO;
import com.metacube.Parking.model.Vehical;
import com.metacube.Parking.utility.AddVehicalHtml;

public class AddVehicle extends HttpServlet{
	public AddVehicle(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter write = response.getWriter();
		write.print(AddVehicalHtml.vehicleHtmlOpen());
		String username = request.getSession().getAttribute("username").toString();
		String vehicleType = request.getParameter("type");
		String vehicleNumber = request.getParameter("number");
		String description = request.getParameter("description");
		Vehical vehical  = new Vehical();
		vehical.addVehical(username, vehicleType, vehicleNumber, description);
		if( (vehicleNumber != null && vehicleNumber != "") && (description != null && description != "")){
			if(new AddVehicleDAO().addEmployee(vehical)){
				write.print("Vehicale Added Successfully <a href=\"login/loginSuccess\">Select Plan </a>");
			}else{
				write.print("<div align=\"center\" style=\"color: red\"> Please Try After Sometime </div>");
				write.print(AddVehicalHtml.vehicalBodyHtml());
			}
		}else{
			if(vehicleNumber == "" || description == "" ){
				write.print("<div align=\"center\" style=\"color: red\"> *please enter all mandatory fields </div>");
			}
			write.print(AddVehicalHtml.vehicalBodyHtml());
		}
		write.print(AddVehicalHtml.vehicleHtmlClose());
	}
}
