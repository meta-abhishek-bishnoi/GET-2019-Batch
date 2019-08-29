package meta.util;
/**
 * This class Contains MySql Queries for various opeartions
 * @author Abhishek Bishnoi
 * @since Aug 29, 2019
 */
public class Query {
	// query for adding student
	public static String addStudent(){
		return "insert into student(first_name,last_name,father_name,email,class,age) values(?,?,?,?,?,?)";
	}
	// showing all students
	public static String getStudents(){
		return "select sn as id, first_name as firstName, last_name as lastName, father_name as fatherName, "+
				"email as email, class as className, age as age from student";
	}
	// query for showing student of a particular student id
	public static String getStudentWithId(){
		return "select first_name as firstName, last_name as lastName, father_name as fatherName, "+
				"email as email, class as className, age as age from student where sn = ?";
	}
	// query to update students
	public static String updateStudent(){
		return "update student set first_name = ?, last_name = ?, father_name = ? , email = ?, "+
				"class = ?, age = ? where sn = ?";
	}
	// query to get student to get student with fix naming pattern into first and last name
	public static String getStudentFromName(){
		return "select sn as id, first_name as firstName, last_name as lastName, father_name as fatherName, "+
				"email as email, class as className, age as age from student where first_name like ? or last_name like ?";
	}
	// query for sorting students in order of class
	public static String getStudentOrderByClass(){
		return "select sn as id, first_name as firstName, last_name as lastName, father_name as fatherName, "+
				"email as email, class as className, age as age from student order by class";
	}
	// query for searching student with a fix naming pattern and order by class
	public static String getStudentFromNameOrderByClass(){
		return "select sn as id, first_name as firstName, last_name as lastName, father_name as fatherName, "+
				"email as email, class as className, age as age from student where first_name like ? or last_name like ? order by class";
	}
}
