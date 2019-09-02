package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.Authentication;
import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.Vehical;
import com.metacube.Parking.utility.DashboardHtmlString;

public class UserDashboard extends HttpServlet {

    private static final String PrintWriter = null;
	public UserDashboard() {
        super();

    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String username = request.getSession().getAttribute("username").toString();
    	Employee employee = Authentication.getUser(username);
    	Vehical vehical = Authentication.getVehicle(username);
    	String htmlString = DashboardHtmlString.getHtmlString(employee,vehical);
    	PrintWriter write = response.getWriter();
    	write.print(htmlString);
    }
}
/*
Cookie[] cookies = request.getCookies();
String email="";
String sessionId = "";
if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("email")){
			email = cookie.getValue();
		}
		if(cookie.getName().equals("JSESSIONID")){
			sessionId = cookie.getValue();
		}
	}
}
*/