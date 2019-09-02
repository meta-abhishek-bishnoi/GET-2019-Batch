package com.metacube.Parking.utility;

import java.text.DecimalFormat;

public class RegisterHtmlGenerator {
	public static String registerHtmlOpen(){
		StringBuilder htmlString= new StringBuilder(); 
		htmlString.append("<html>")
		.append("    <head>")
		.append("        <title>Register</title>")
		.append("    </head>")
		.append("    <body>");
		return htmlString.toString();
	}
	public static String registerBodyHtml(){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("<div align=\"center\">")
		.append("	<h2>Register Employee</h2>")
		.append("	<form action=\"registerEmployee\" method=\"post\">")
		.append("		<table>")
		.append("			<tr>")
		.append("				<td><label for=\"name\"> Employee Name *: </label></td>")
		.append("				<td><input type=\"text\" placeholder=\"Employee's Full Name\"")
		.append("					id=\"name\" name=\"name\"></td>")
		.append("			</tr>")
		.append("			<tr>")
		.append("				<td><label for=\"empid\"> Employee ID *: </label></td>")
		.append("				<td><input type=\"text\" placeholder=\"Employee's ID\"")
		.append("					id=\"empid\" name=\"empid\"></td>")
		.append("			</tr>")
		.append("			<tr>")
		.append("				<td><label> Gender:</label></td>")
		.append("				<td><input type=\"radio\" id=\"gender\" name=\"gender\" value=\"male\"")
		.append("					checked> <label for=\"male\"> male</label> <input")
		.append("					type=\"radio\" id=\"gender\" name=\"gender\" value=\"female\"> <label")
		.append("					for=\"female\"> female</label></td>")
		.append("			</tr>")
		.append("			<tr>")
		.append("				<td><label for=\"email\"> Email Id *: </label></td>")
		.append("				<td><input type=\"text\" placeholder=\"Email Id\" id=\"email\"")
		.append("					name=\"email\"></td>")
		.append("			</tr>")
		.append("			<tr>")
		.append("				<td><label for=\"password\"> Password *: </label></td>")
		.append("				<td><input type=\"password\" placeholder=\"Password\" id=\"password\"")
		.append("					name=\"password\"></td>")
		.append("			</tr>")
		.append("			<tr>")
		.append("				<td><label type=\"password\"> Confirm Password *: </label></td>")
		.append("				<td><input type=\"password\" placeholder=\"Confirm Password\"")
		.append("					id=\"confirm\" name=\"confirm\"></td>")
		.append("			</tr>")
		.append("			<tr>")
		.append("				<td><label for=\"contact\"> Contact No *: </label></td>")
		.append("				<td><input type=\"text\" placeholder=\"Contact Number\"")
		.append("					id=\"contact\" name=\"contact\"></td>")
		.append("			</tr>")
		.append("<tr>")
		.append("                        <td>Oragnization: </td><td>")
		.append("                        <select id=\"oragnization\" name=\"oragnization\">")
		.append("                            <option value=\"metacube\">metacube</option>")
		.append("                            <option value=\"ecb\">ecb</option>")
		.append("                            <option value=\"royal group\">royal group</option>")
		.append("                            <option value=\"pitsol\"> pitsol</option>")
		.append("                        </select>")
		.append("                    </td></tr>")
		.append("			<tr>")
		.append("				<td></td>")
		.append("				<td><input type=\"submit\" value=\"register\"></td>")
		.append("			</tr>")
		.append("		</table>")
		.append("	</form>")
		.append("<a href=\"login.html\">Already Have Account Click Here To Login</a>")
		.append("</div>");
		return htmlString.toString();
	}

	public static String registerHtmlClose(){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("</body>")
		.append("</html>");
		return htmlString.toString();
	}
}
