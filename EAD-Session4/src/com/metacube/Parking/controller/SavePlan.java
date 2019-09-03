package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.AddVehicleDAO;
import com.metacube.Parking.utility.AddVehicalHtml;

public class SavePlan extends HttpServlet{
	public SavePlan(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter write = response.getWriter();
		String username = request.getSession().getAttribute("username").toString();
		double planAmount = Double.parseDouble(request.getParameter("plan"));
		if(new AddVehicleDAO().savePlan(planAmount,username)){
			write.print("Vehicale Added Successfully <a href=\"login/loginSuccess\">DashBoard </a>");
		}else{
			write.print("<div align=\"center\" style=\"color: red\"> Please Try After Sometime </div>");
			write.print("<a href=\"login/loginSuccess\">Add Again </a>");
		}
	}

}
