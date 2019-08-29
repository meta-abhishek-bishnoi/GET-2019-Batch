package meta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.dao.Service;
import meta.model.Student;
import meta.util.HtmlString;
/**
 * 
 * @author Abhishek Bishnoi
 * @since Aug 28, 2019
 * This Controller show page edit form for student 
 */
public class EditStudent extends HttpServlet {
	public EditStudent(){
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Service service = new Service();
		String idInString = request.getParameter("id");
		int id = Integer.parseInt(idInString);
		Student student = null;
		try {
			student = service.getStudent(id);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		PrintWriter writer = response.getWriter();
		// generating html string for Student Object
		String htmlString = HtmlString.getEditHtmlPage(student);
		writer.print(htmlString);
	}
}
