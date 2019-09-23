/**
* This Servlet is a controller for Updating Item Quantity
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

import com.metacube.dao.AddProductsDAO;
import com.metacube.dao.DeleteProductDAO;

public class SaveChanges extends HttpServlet{
	public SaveChanges(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int productCode= Integer.parseInt(request.getParameter("product_id"));
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		int quantity= Integer.parseInt(request.getParameter("quantity"));
		if(quantity==0){ // if user put quantity as zero
			boolean result = DeleteProductDAO.deleteProduct(orderId);
			if(result){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
				PrintWriter out= response.getWriter();
				out.println("<div align=\"center\" style=\"color: green\">Updated Successfully</div>");
				rd.include(request, response);
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
				PrintWriter out= response.getWriter();
				out.println("<div align=\"center\" style=\"color: red\">Please Try Again later</div>");
				rd.include(request, response);
			}
		}else{ //otherswise
			boolean result = AddProductsDAO.updateProduct(productCode, quantity);
			if(result){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
				PrintWriter out= response.getWriter();
				out.println("<div align=\"center\" style=\"color: green\">Updated Successfully</div>");
				rd.include(request, response);
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/view/registerSuccess.html");
				PrintWriter out= response.getWriter();
				out.println("<div align=\"center\" style=\"color: red\">Please Try Again later</div>");
				rd.include(request, response);
			}
		}
	}
}
