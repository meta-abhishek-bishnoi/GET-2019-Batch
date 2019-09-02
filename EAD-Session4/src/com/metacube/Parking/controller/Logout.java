package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	public Logout(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession(false);
        if (session != null) {
        	session.invalidate();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
		PrintWriter out= response.getWriter();
		out.println("<div align=\"center\" style=\"color: green\">logout Successfully</div>");
		rd.include(request, response);
	}
}
