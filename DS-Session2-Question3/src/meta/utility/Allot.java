package meta.utility;

public class Allot {
	public MyQueue<Student> allotCources(){
		Loader load = new Loader();
		MyQueue<Course> queueCourse = load.loadCourses();
		MyQueue<Student> queueStudents = load.loadStudents();
		MyQueue<Student> alloatedStudents = new MyQueue<Student>();
		MyQueue<Course> currentCourse;
		/**
		 * iterating students
		 */
		while(queueStudents.size()!=0){
			Student currentStudent = queueStudents.remove();
			String courses[]=currentStudent.getChoosenCourse();
			/**
			 * checking for user choice
			 */
			for(int i=0; i<5; i++){
				currentCourse = queueCourse;
				if(currentStudent.getStudentId() == null){
					while(currentCourse.size()!=0){
						Course course = currentCourse.remove();
						System.out.println(courses[i]+" "+course.getCourseName());
						if(courses[i].equals(course.getCourseName())){
							currentStudent.setCourseId(course.getCourseId());
							currentStudent.setCourseName(course.getCourseName());
							alloatedStudents.add(currentStudent);
							break;
						}
					}
				}else{
					currentStudent.setCourseId("NA");
					currentStudent.setCourseName("NA");
					alloatedStudents.add(currentStudent);
					break;
				}
			}
		}
		return alloatedStudents;
	}
}
