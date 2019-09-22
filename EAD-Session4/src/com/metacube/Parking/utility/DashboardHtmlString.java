/**
* this is utility class for generating html string for user dashboard
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.utility;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.Vehical;

public class DashboardHtmlString {
	public static String getHtmlString(Employee employee, Vehical vehical){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("<html>")
		     .append("    <head>")
		     .append("        <title>Dashbord</title>")
		     .append("    </head>")
		     .append("    <body>")
		     .append("        <div id=\"nav\" align=\"right\">Welcome, "+employee.getEmployeeName()+" <a href=\"logout\">logout</a></div>")
		     .append("        <div id=\"profile\">")
		     .append("            <table>")
		     .append("                <tr><td>Name:</td><td>"+employee.getEmployeeName()+"</td></tr>")
		     .append("                <tr><td>Email:</td><td>"+employee.getEmployeeEmail()+"</td></tr>")
		     .append("                <tr><td>Employee Id:</td><td>"+employee.getEmployeeId()+"</td></tr>")
		     .append("                <tr><td>Vehile Type:</td><td>"+vehical.getVehicleType()+"</td></tr>")
		     .append("                <tr><td>Vehicle Number:</td><td>"+vehical.getVehicleNumber()+"</td></tr>")
		     .append("                <tr><td>Identification:</td><td>"+vehical.getDescription()+"</td></tr>")
		     .append("                <tr><td>Plan:</td><td>"+vehical.getAmount()+"</td></tr>")
		     .append("                <tr><td>Oragnization:</td><td>"+employee.getOragnization()+"</td></tr>")
		     .append("            </table>")
		     .append("        </div>")
		     .append("        <div id=\"links\">")
		     .append("            <a href=\"login/friendlist\">Click Here to get friend list</a>")
		     .append("        </div>")
		     .append("    </body>")
		     .append("</html>");
		return htmlString.toString();
	}
}
