package meta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.dao.Service;
import meta.model.Student;
/**
 * 
 * @author Abhishek Bishnoi
 * Since Aug 28,2019
 * This is Controller Servlet for adding student into databsase
 *
 */
public class AddStudent extends HttpServlet {

	public AddStudent() {
        super();
       
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("email");
		String className = request.getParameter("class");
		int age = Integer.parseInt(request.getParameter("age"));
		Student student = new Student(firstName,lastName,fatherName,email,className,age);
		Service service = new Service();
		boolean result = false;
		try {
			result = service.addStudent(student);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(result){
			// redirecting to sucess.html
			response.sendRedirect("sucess.html");
		}else{
			// in any error case 
			PrintWriter write = response.getWriter();
			write.print("Error In Inserting Data");
			write.print("<a href='addStudent.html'>Insert Student</a><br>");
			write.print("<a href='index.html'> Go To Home</a>");
		}
	}
}
