/**
* This Servlet is a controller After Authenticating User
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.Authentication;
import com.metacube.Parking.model.Employee;
// this servlets checks if user is login first time or not and had added vehical and choose plans
public class LoginSuccess extends HttpServlet{
	public LoginSuccess(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getSession().getAttribute("username").toString();
    	Employee employee = Authentication.getUser(username);
    	RequestDispatcher dispatcher;
    	if(employee.getIsVehicle()==0){ // if vehical is not added 
			dispatcher = getServletContext().getRequestDispatcher("/login/addVehical");
			dispatcher.forward(request, response);
		}else if(employee.isPlan()==0){ // if plan is not selected
			dispatcher = getServletContext().getRequestDispatcher("/login/addPlan");
			dispatcher.forward(request, response);
    	}
    	else { // othereise
    		dispatcher = getServletContext().getRequestDispatcher("/login/dashboard");
			dispatcher.forward(request, response);
		}
	}
}
