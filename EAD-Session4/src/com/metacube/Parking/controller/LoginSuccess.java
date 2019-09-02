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

public class LoginSuccess extends HttpServlet{
	public LoginSuccess(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getSession().getAttribute("username").toString();
    	Employee employee = Authentication.getUser(username);
    	RequestDispatcher dispatcher;
    	if(employee.getIsVehicle()==0){
			dispatcher = getServletContext().getRequestDispatcher("/addVehical");
			dispatcher.forward(request, response);
		}else if(employee.isPlan()==0){
			dispatcher = getServletContext().getRequestDispatcher("/addPlan");
			dispatcher.forward(request, response);
    	}
    	else {
    		dispatcher = getServletContext().getRequestDispatcher("/dashboard");
			dispatcher.forward(request, response);
		}
	}
}
