package com.metacube.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.LoadOrderDAO;
import com.metacube.model.Order;

public class EditOrder extends HttpServlet{
	public EditOrder() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int orderId= Integer.parseInt(request.getParameter("id"));
		Order order = LoadOrderDAO.loadOrdersById(orderId);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/edit.jsp");
		request.setAttribute("order", order);
		dispatcher.forward(request, response);
	}
}
