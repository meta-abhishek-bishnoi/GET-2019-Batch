package meta.test;

import meta.utility.Allot;
import meta.utility.Course;
import meta.utility.Loader;
import meta.utility.MyQueue;
import meta.utility.Student;

public class Main {

	public static void main(String[] args) {
		Allot allot = new Allot();
		MyQueue<Student> students = allot.allotCources();
		while(students.size()!=0){
			Student student = (Student) students.remove();
			System.out.println(student.getRank()+" "+student.getStudentName()+" "+student.getCourseId()+" "+student.getCourseName());
		}
	}

}
