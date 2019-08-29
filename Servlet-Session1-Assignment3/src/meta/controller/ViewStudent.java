package meta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.dao.Service;
import meta.model.Student;
import meta.util.HtmlString;
/**
 * This class is used to show all students present into database
 * @author Abhishek Bishnoi
 * @since Aug 28, 2019
 *
 */
public class ViewStudent extends HttpServlet{
	public ViewStudent(){
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response){
		Service service = new Service();
		List<Student> students = new ArrayList<Student>();
		String header[] = {"Student Name", "Father Name", "Email", "Class", "Age", "Action"};
		try {
			students = service.getStudents();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		String tableString = HtmlString.getTabularData(header, students);
		try(PrintWriter writer = response.getWriter();) {
			writer.print("<html>");
			writer.print("<head><title>List</title><head>");
			writer.print("<body>");
			writer.print(tableString);
			writer.print("<a href='index.html'> Go To Home</a>");
			writer.print("</body>");
			writer.print("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
