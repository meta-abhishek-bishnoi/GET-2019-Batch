package com.metacube.Parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.Parking.dao.InsertEmployees;
import com.metacube.Parking.model.Employee;
import com.metacube.Parking.utility.RegisterHtmlGenerator;
import com.metacube.Parking.utility.Validate;

public class RegisterEmployee extends HttpServlet{
	public RegisterEmployee(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		String htmlOpen = RegisterHtmlGenerator.registerHtmlOpen();
		String employeeId = request.getParameter("empid");
		String employeeName = request.getParameter("name");
		String employeeGender = request.getParameter("gender");
		String employeeEmail = request.getParameter("email");
		String employeePassword = request.getParameter("password");
		String employeeConfirmPassword = request.getParameter("confirm");
		String employeeContact = request.getParameter("contact");
		String employeeOragnization = request.getParameter("oragnization");
		Employee employee = new Employee(employeeId, employeeName, employeeGender, employeeEmail, 
				employeePassword,employeeConfirmPassword,employeeContact,employeeOragnization);
		String errorHtml = "";
		String bodyHtml = "";
		if( (employeeName != null && employeeName != "") && (employeeId != null && employeeId != "") && 
			(employeeEmail != null && employeeEmail != "") && (employeePassword != null && employeePassword != "") &&
			(employeeConfirmPassword != null && employeeConfirmPassword != "") && (employeeContact != null && employeeContact != "") ){
			String error = Validate.getValidation(employee);
			if(error.equals("")){
				if(new InsertEmployees().addEmployee(employee)){
					bodyHtml =  "<div align=\"center\"> "+"You Are Registerd Succesfully!!<br><a href=\"login.html\">Click Here To Login</a>"+ "</div>";
				}else{
					errorHtml+= "<div align=\"center\" style=\"color: red\"> Sorry For Inconvenience Please Try After Sometime </div>";
					bodyHtml = RegisterHtmlGenerator.registerBodyHtml();
				}
			}else{
				errorHtml+= "<div align=\"center\" style=\"color: red\"> "+error+ "</div>";
				bodyHtml = RegisterHtmlGenerator.registerBodyHtml();
			}
		}else{
			if(employeeName == "" || employeeId == "" || employeeEmail == "" || employeePassword == "" || employeeConfirmPassword == "" || employeeContact == ""){
				errorHtml = "<div align=\"center\" style=\"color: red\"> *please enter all mandatory fields </div>";
			}
			bodyHtml = RegisterHtmlGenerator.registerBodyHtml();
		}
		
		String htmlClose = RegisterHtmlGenerator.registerHtmlClose();
		writer.print(htmlOpen+errorHtml+bodyHtml+htmlClose);
	}
}
