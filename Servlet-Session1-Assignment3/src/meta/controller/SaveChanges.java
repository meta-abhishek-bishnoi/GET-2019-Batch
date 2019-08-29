package meta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meta.dao.Service;
import meta.model.Student;
/**
 * This class is to design to update student info into db
 * @author Abhishek Bishnoi
 * @since Aug 28, 2019
 *
 */
public class SaveChanges extends HttpServlet {
	public SaveChanges(){
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response){
		Service service = new Service();
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("email");
		String className = request.getParameter("class");
		int age = Integer.parseInt(request.getParameter("age"));
		Student student = new Student(id,firstName,lastName,fatherName,email,className,age);
		try(PrintWriter writer = response.getWriter()) {
			int result = service.updateStudent(student);
			// result as per opertion sucessing
			if(result>0){
				writer.print("Updated Successful<br>");
				writer.print("<a href='index.html'> Go To Home</a>");
			}else{
				writer.print("Error During Update<br>");
				writer.print("<a href='index.html'> Go To Home</a>");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
