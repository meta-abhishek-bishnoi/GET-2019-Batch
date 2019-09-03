package com.metacube.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.LoadOrderDAO;
import com.metacube.model.Order;
import com.metacube.model.Product;

public class CartItem extends HttpServlet{
	public CartItem(){
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/cart.jsp");
		List<Order> orders = LoadOrderDAO.loadOrders();
		System.out.println(orders.size());
		request.setAttribute("orders", orders);
		dispatcher.forward(request, response);
	}
}
