package com.metacube.Parking.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionValidator implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(false);
		if(session != null){
			chain.doFilter(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			out.println("<div align=\"center\" style=\"color: red\">Session Expried Please Login Again</div>");
        	rd.include(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
