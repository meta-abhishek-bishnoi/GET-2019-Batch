/**
* This Servlet is a controller for Delete Items From  Cart
* @author Abhishek Bishnoi
* @since Sept 2,2019
*/
package com.metacube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.DeleteProductDAO;


public class DeleteItem extends HttpServlet{
	public DeleteItem(){
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int orderId= Integer.parseInt(request.getParameter("id"));
		boolean result = DeleteProductDAO.deleteProduct(orderId);
		if(result){ // if deleted successfully
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: green\">Deleted Successfully</div>");
			rd.include(request, response);
		}else{ // if SQL Exception raise
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: red\">Please Try Again later</div>");
			rd.include(request, response);
		}
	}
}
