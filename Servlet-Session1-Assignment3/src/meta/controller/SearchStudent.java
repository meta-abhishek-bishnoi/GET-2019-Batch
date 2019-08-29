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
 * This class is Design for searching from database
 * @author Abhishek Bishnoi
 * @since Aug 28, 2019
 *
 */
public class SearchStudent extends HttpServlet{
	public SearchStudent(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		// common html for each condition
		String commonHtml = HtmlString.getSearchStudentCommon();
		Service service = new Service();
		List<Student> students = new ArrayList<Student>();
		// header for resultSet
		String header[] = {"Student Name", "Father Name", "Email", "Class", "Age", "Action"};
		writer.print(commonHtml);
		/*
		 * if name and checkbox both are not selected or null then it will show all student
		 */
		if(request.getParameter("name")== null ||request.getParameter("name")==""  && request.getParameter("checked")==null){
			try {
				students = service.getStudents();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("checked")==null){ // if only filter by class is not checked then will show results
			String name = request.getParameter("name");
			try {
				students = service.getStudents(name);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("name")==""){ // if search box is empty
			try {
				students = service.getStudentsWhenChecked();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}else{ // if name has value and sort by class is selected
			try {
				students = service.getStudentsWhenChecked();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
		String tableString = HtmlString.getTabularData(header, students);
		writer.print(tableString);
		writer.print("<a href='index.html'> Go To Home</a>");
		writer.print("</body>");
		writer.print("</html>");
	}
}
