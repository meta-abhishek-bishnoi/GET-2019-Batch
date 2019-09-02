package com.metacube.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.LoadProductDAO;
import com.metacube.model.Product;


public class Dashboard extends HttpServlet{
	public Dashboard(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/dashboard.jsp");
		List<Product> products = LoadProductDAO.loadProducts();
		request.setAttribute("products", products);
		dispatcher.forward(request, response);
	}

}
