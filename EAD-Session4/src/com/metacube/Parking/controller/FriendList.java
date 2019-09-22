/**
* This Servlet is a controller to get friendlist of user
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.Authentication;
import com.metacube.Parking.dao.FriendListDAO;
import com.metacube.Parking.model.Employee;
import com.metacube.Parking.utility.FriendListHtml;

public class FriendList extends HttpServlet{
	public FriendList(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getSession().getAttribute("username").toString();
		Employee employee = Authentication.getUser(username);
		String oragnigation = employee.getOragnization();
		List<Employee> friends = FriendListDAO.getFriends(username, oragnigation);
		PrintWriter write = response.getWriter();
		String htmlString = FriendListHtml.getFriendList(friends);
		write.print(htmlString);
	}
}
