package meta.util;

import java.util.List;

import meta.model.Student;
/**
 * This class is to generate a HTML String for generating html pages in servlet
 * @author Abhishek Bishnoi
 * @since Aug 28, 2019
 *
 */
public class HtmlString {
	/**
	 * this function return a tables in html tangs
	 * @param header data of table-header
	 * @param students data of Student Object
	 * @return String in html tag
	 */
	public static String getTabularData(String[] header, List<Student> students){
		StringBuilder tabularString = new StringBuilder();
		tabularString.append("<table border='0.1'><tr>");
		for(String th : header){
			tabularString.append("<th>"+th+"</th>");
		}
		tabularString.append("</tr>");
		for(Student student : students){
			tabularString.append("<tr>");
			tabularString.append("<td>"+student.getFirstName()+" "+student.getLastName()+"</td>");
			tabularString.append("<td>"+student.getFatherName()+"</td>");
			tabularString.append("<td>"+student.getEmail()+"</td>");
			tabularString.append("<td>"+student.getClassName()+"</td>");
			tabularString.append("<td>"+student.getAge()+"</td>");
			tabularString.append("<td>"+"<a href='editStudent?id="+student.getId()+"'>Action"+"</td>");
			tabularString.append("</tr>");
		}
		tabularString.append("</table>");
		return tabularString.toString();
	}
	/**
	 * return html string as form to edit data of student
	 * @param student Student Object which values set into form
	 * @return String html form
	 */
	public static String getEditHtmlPage(Student student){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("<html>")
		     .append("    <head>")
		     .append("        <title>Edit Student</title>")
		     .append("    </head>")
		     .append("    <body>")
		     .append("        <div align= 'center'>") 
		     .append("            <form action= 'saveChanges' method='post'>")
		     .append("                Student ID: "+student.getId()+"<input type='hidden' name='id' id='id' value= '"+student.getId()+"' ><br><br>")
		     .append("                First Name:<input type='text' name='first_name' id='first_name' value= '"+student.getFirstName()+"'><br><br>")
		     .append("                Last Name:<input type='text' name='last_name' id='last_name' value= '"+student.getLastName()+"'><br><br>")
		     .append("                Father Name:<input type='text' name='father_name' id='father_name' value= '"+student.getFatherName()+"'><br><br>")
		     .append("                Email Id:<input type='text' name='email' id='email' value= '"+student.getEmail()+"'><br><br>")
		     .append("                Class Name:<input type='text' name='class' id='class' value= '"+student.getClassName()+"'><br><br>")
		     .append("                Student Age:<input type='text' name='age' id='age' value= '"+student.getAge()+"'><br><br>")
		     .append("                <input type= 'submit' value= 'editStudent '>")
		     .append("            </form>")
		     .append("<a href='index.html'> Go To Home</a>")
		     .append("        </div>")
		     .append("    </body>")
		     .append("</html>");
		return htmlString.toString();
	}
	/**
	 * Html String for Search Servlet0
	 * @return html string
	 */
	public static String getSearchStudentCommon(){
		StringBuilder htmlString = new StringBuilder(); 
		htmlString.append("<html>")
		.append("    <head>")
		.append("        <title>Search Student</title>")
		.append("    </head>")
		.append("    <body>")
		.append("        <div  align=\"center\">")
		.append("            <form action=\"searchStudent\">")
		.append("                <input type=\"text\" placeholder=\"student name\" id=\"name\" name=\"name\">")
		.append("                <input type=\"checkbox\" name=\"checked\" id=\"checked\"> sort by class<br><br>")
		.append("                <input type=\"submit\" value=\"Search\"><br><br>")
		.append("            </form>")
		.append("        </div>")
		.append("        <div align=\"center\">")
		.append("            <h2> List</h2>");
		return htmlString.toString();
	}
}
