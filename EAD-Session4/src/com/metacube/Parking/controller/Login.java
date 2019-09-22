/**
* This Servlet is a controller to authenticate login of user
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.Parking.dao.Authentication;
import com.metacube.Parking.model.Employee;

public class Login extends HttpServlet{
	public Login(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String employeeEmail = request.getParameter("email").trim();
		String employeePassword = request.getParameter("password");
		boolean result = Authentication.authenticate(employeeEmail, employeePassword); // authenticating user
		if(result){ // if authentication success
			HttpSession oldSession = request.getSession(false); // if any old session is exisiting, invalidate that
	        if (oldSession != null) {
	        	oldSession.invalidate();
	        }
	        HttpSession newSession = request.getSession(true); // creating new session
	        newSession.setMaxInactiveInterval(5*60);
	        newSession.setAttribute("username", employeeEmail); // adding email as username in session attribute
	        Cookie message = new Cookie("email", employeeEmail);
            response.addCookie(message);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login/loginSuccess");
            rd.forward(request, response);
		}else{ // if authenticatiion failed
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: red\">Authentication Fail, Invalid Username Or Password</div>");
			rd.include(request, response);
		}
	}
}
