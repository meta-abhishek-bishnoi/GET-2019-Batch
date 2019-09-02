package com.metacube.Parking.utility;

public class AddVehicalHtml {
	public static String vehicleHtmlOpen(){
		StringBuilder htmlString= new StringBuilder(); 
		htmlString.append("<html>")
		.append("    <head>")
		.append("        <title>Add Vehicle</title>")
		.append("    </head>")
		.append("    <body>");
		return htmlString.toString();
	}
	public static String vehicalBodyHtml(){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("<div align=\"center\">")
	     .append("            <form action=\"addVehical\" method=\"post\">")
	     .append("                    <table>")
	     .append("                            <tr>")
	     .append("                                <td>")
	     .append("                                    vehical Type")
	     .append("                                </td>")
	     .append("                                <td>")
	     .append("                                    <input type=\"radio\" name=\"type\" id=\"type\" value=\"byCycle\" checked>ByCycle")
	     .append("                                    <input type=\"radio\" name=\"type\" id=\"type\" value=\"motorCycle\">Motor Cycle")
	     .append("                                    <input type=\"radio\" name=\"type\" id=\"type\" value=\"fourWheeler\">Four Wheeler")
	     .append("                                </td>")
	     .append("                            </tr>")
	     .append("                            <tr>")
	     .append("                                <td>")
	     .append("                                    Vehical Number")
	     .append("                                </td>")
	     .append("                                <td>")
	     .append("                                    <input type=\"text\" id=\"number\" name=\"number\">")
	     .append("                                </td>")
	     .append("                            </tr>")
	     .append("                            <tr>")
	     .append("                                <td><label for=\"identification\">Identification</label></td>")
	     .append("                                <td><input type=\"text\" name=\"description\" id=\"description\">")
	     .append("                                </td>")
	     .append("                            </tr>")
	     .append("                            <tr>")
	     .append("                                <td></td>")
	     .append("                                <td><input type=\"submit\" value=\"add\"></td>")
	     .append("                            </tr>")
	     .append("                        </table>")
	     .append("            </form>")
	     .append("        </div>");
			
		return htmlString.toString();
	}
	public static String vehicleHtmlClose(){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("</body>")
		.append("</html>");
		return htmlString.toString();
	}
}
