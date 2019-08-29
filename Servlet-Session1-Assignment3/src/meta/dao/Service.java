package meta.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meta.model.Student;
import meta.util.Connector;
import meta.util.Query;
/**
 * This class provides services for inserting, searching and updating students
 * @author Abhishek Bishnoi
 * @since Aug 29, 2019
 */
public class Service {
	/**
	 * Adding Students into database
	 * @param student Student Object to insert into DB
	 * @return boolean value
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean addStudent(Student student) throws ClassNotFoundException, IOException{
		Connector connector = new Connector();
		String query = Query.addStudent();
		boolean result = false;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getFatherName());
			preparedStatement.setString(4, student.getEmail());
			preparedStatement.setString(5, student.getClassName());
			preparedStatement.setInt(6, student.getAge());
			preparedStatement.execute();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Showing all students present into db
	 * @return List<Students> list of students
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<Student> getStudents() throws ClassNotFoundException, IOException{
		Connector connector = new Connector();
		String query = Query.getStudents();
		List<Student> students = new ArrayList<Student>();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				String className = resultSet.getString("className");
				int age = resultSet.getInt("age");
				students.add(new Student(id,firstName, lastName, fatherName, email, className, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return students;
	}
	/**
	 * return Student of a particular student id
	 * @param id student id which should search
	 * @return Student Object for that id
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Student getStudent(int id) throws ClassNotFoundException, IOException{
		Student student = null;
		Connector connector = new Connector();
		String query = Query.getStudentWithId();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				String className = resultSet.getString("className");
				int age = resultSet.getInt("age");
				student = new Student(id,firstName, lastName, fatherName, email, className, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	/**
	 * update the student's changes values
	 * @param student Object of Student Type
	 * @return int value for effected rows
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public int updateStudent(Student student) throws ClassNotFoundException, IOException{
		Connector connector = new Connector();
		String query = Query.updateStudent();
		int result = 0;
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getFatherName());
			preparedStatement.setString(4, student.getEmail());
			preparedStatement.setString(5, student.getClassName());
			preparedStatement.setInt(6, student.getAge());
			preparedStatement.setInt(7, student.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * search student with a name pattern
	 * @param name name pattern which must be in the names of student
	 * @return List<Students> those contains the string pattern
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<Student> getStudents(String name) throws ClassNotFoundException, IOException{
		Connector connector = new Connector();
		String query = Query.getStudentFromName();
		List<Student> students = new ArrayList<Student>();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, "%"+name+"%");
			preparedStatement.setString(2, "%"+name+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				String className = resultSet.getString("className");
				int age = resultSet.getInt("age");
				students.add(new Student(id,firstName, lastName, fatherName, email, className, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return students;
	}
	/**
	 * return List<Student> in order of class
	 * @return List<Student>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<Student> getStudentsWhenChecked() throws ClassNotFoundException, IOException{
		Connector connector = new Connector();
		String query = Query.getStudentOrderByClass();
		List<Student> students = new ArrayList<Student>();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				String className = resultSet.getString("className");
				int age = resultSet.getInt("age");
				students.add(new Student(id,firstName, lastName, fatherName, email, className, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return students;
	}
	/**
	 * this will return students with a fix string pattern in their first and last name and sorted by class
	 * @param name string pattern in name
	 * @return List<Student>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<Student> getStudentsFromNameWhenChecked(String name) throws ClassNotFoundException, IOException{
		Connector connector = new Connector();
		String query = Query.getStudentFromNameOrderByClass();
		List<Student> students = new ArrayList<Student>();
		try(Connection connect = connector.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, "%"+name+"%");
			preparedStatement.setString(2, "%"+name+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String fatherName = resultSet.getString("fatherName");
				String email = resultSet.getString("email");
				String className = resultSet.getString("className");
				int age = resultSet.getInt("age");
				students.add(new Student(id,firstName, lastName, fatherName, email, className, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return students;
	}
}
