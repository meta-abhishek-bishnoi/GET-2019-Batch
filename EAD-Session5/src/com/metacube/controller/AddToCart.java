package com.metacube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.fasade.AddProducts;

public class AddToCart extends HttpServlet {
    
	public AddToCart() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int productCode = Integer.parseInt(request.getParameter("id"));
		boolean result = AddProducts.getProductCount(productCode);
		if(result){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("WEB-INF/view/dashboard.jsp");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: green\">Product Added Successfully</div>");
			rd.include(request, response);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("WEB-INF/view/dashboard.jsp");
			PrintWriter out= response.getWriter();
			out.println("<div align=\"center\" style=\"color: red\">Please Try Again later</div>");
			rd.include(request, response);
		}
	}

}
