/**
* This Servlet is a controller to add plans
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.PlanDao;
import com.metacube.Parking.model.Plan;
import com.metacube.Parking.utility.SelectPlanHtml;
/**
*	Servlet to Add plan to db
*/
public class AddPlan extends HttpServlet{
	public AddPlan(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getSession().getAttribute("username").toString();
		String vehicleType = PlanDao.getVehicleType(username); // getting plan from db
		Plan plan = PlanDao.getPlan(vehicleType);
		PrintWriter write = response.getWriter();
		String htmlString = SelectPlanHtml.getSelectPlanHtml(plan);
		write.print(htmlString);
	}
}
