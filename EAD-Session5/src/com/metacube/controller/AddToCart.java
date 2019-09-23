/**
* This Servlet is a controller for Adding Items To Cart
* @author Abhishek Bishnoi
* @since Sept 2,2019
*/
package com.metacube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.metacube.dao.AddProductsDAO;


public class AddToCart extends HttpServlet {
    
	public AddToCart() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int productCode = Integer.parseInt(request.getParameter("id"));
		boolean result = AddProductsDAO.orderProduct(productCode);
		if(result){ // if Addedd Successfully
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: green\">Product Added Successfully</div>");
			rd.include(request, response);
		}else{ // if SQl Exception Raise
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: red\">Please Try Again later</div>");
			rd.include(request, response);
		}
	}

}
