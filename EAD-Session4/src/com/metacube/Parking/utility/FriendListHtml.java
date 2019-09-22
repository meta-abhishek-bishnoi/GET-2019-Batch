/**
* this is utility class for generating html string for showing friend list
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.utility;

import java.util.List;

import com.metacube.Parking.model.Employee;

public class FriendListHtml {
	public static String getFriendList(List<Employee> friends){
		StringBuilder htmlStringTop = new StringBuilder(); 
		htmlStringTop.append("<html>")
		.append("    <head>")
		.append("        <title>FriendList</title>")
		.append("    </head>")
		.append("    <body>")
		.append("            <div id=\"profile\">")
		.append("            <table>")
		.append("                <tr>")
		.append("                    <th>ID</th>")
		.append("                    <th>NAME</th>")
		.append("                    <th>EMAIL</th>")
		.append("                    <th>CONTACT</th>")
		.append("                </tr>");
		StringBuilder htmlStringMid = new StringBuilder();
		for(Employee emp : friends){
			System.out.println("Hello");
			htmlStringMid.append("                <tr>")
			.append("                    <td>"+emp.getEmployeeId()+"</td>")
			.append("                    <td>"+emp.getEmployeeName()+"</td>")
			.append("                    <td>"+emp.getEmployeeEmail()+"</td>")
			.append("                    <td>"+emp.getEmployeeContact()+"</td>")
			.append("                </tr>");
		}
		StringBuilder htmlStringDown = new StringBuilder();
		htmlStringDown.append("            </table>")
		.append("        </div>")
		.append("        <div id=\"links\">")
		.append("            <a href=\"dashboard\">Go To Dashboard</a>")
		.append("        </div>")
		.append("    </body>")
		.append("</html>");
		return 	htmlStringTop.toString()+htmlStringMid.toString()+htmlStringDown.toString();
	}
}
