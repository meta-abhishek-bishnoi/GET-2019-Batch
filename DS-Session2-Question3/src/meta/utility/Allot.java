/**
 * @author Abhishek Bishnoi
 * @since  Aug 1, 2019
 * This Class is service class for allotting courses to student
 */
package meta.utility;

public class Allot {
	public MyQueue<Student> allotCources(){
		Loader load = new Loader();
		MyQueue<Course> queueCourse = load.loadCourses(); // loading data of courses as Queue 
		MyQueue<Student> queueStudents = load.loadStudents(); // loading data of students as Queue
		MyQueue<Student> alloatedStudents = new MyQueue<Student>(); // initialize Student Queue
		/**
		 * iterating students from Queue
		 */
		while(queueStudents.size()!=0){
			Student currentStudent = queueStudents.remove(); // getting first Student
			String courses[]=currentStudent.getChoosenCourse(); // getting selected courses
			boolean isAlloted = false; // flag to check if course is allocated or not
			for(int i=0; i<5; i++){
				if(currentStudent.getCourseId()==null){ // if student haven't allocated any course
					for(int j=0; j<queueCourse.size(); j++){
						Course course = queueCourse.get(j);
						/**
						 * checking courses name and checking can occupy or not & should not allocated
						 */
						if(course.getCourseName().equals(courses[i]) && course.canOccupySeat() && !isAlloted){
							course.occupySet();
							currentStudent.setCourseId(course.getCourseId()); // setting course id
							currentStudent.setCourseName(course.getCourseName()); // setting course name
							alloatedStudents.add(currentStudent); // adding to queue
							isAlloted=true; // setting flag (true)
							break;
						}
					}
				}
			}
			if(!isAlloted){
				// if not alloted any course
				currentStudent.setCourseId("--");
				currentStudent.setCourseName("Not Alloted");
				alloatedStudents.add(currentStudent);
			}
		}
		return alloatedStudents;
	}
	public boolean isLoading(){
		Loader load = new Loader();
		MyQueue<Course> queueCourse = load.loadCourses();
		if(queueCourse.size()!=0){
			return true;
		}
		return false;
	}
}
