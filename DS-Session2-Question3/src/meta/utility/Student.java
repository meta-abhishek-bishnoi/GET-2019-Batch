/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 * This Class Contains Data Structure for Student (short listed & alloted course both)
 */
package meta.utility;

public class Student {
	int rank;
	String studentId;
	String studentName;
	String choosenCourse[];
	String courseId;
	String courseName;
	/**
	 * This Constructor is used to assign values in the structure
	 * @param rank : int value as a rank
	 * @param studentId : string value as student id
	 * @param studentName
	 * @param choosenCourse
	 */
	public Student(int rank, String studentId, String studentName,
			String[] choosenCourse) {
		super();
		this.rank = rank;
		this.studentId = studentId;
		this.studentName = studentName;
		this.choosenCourse = choosenCourse;
	}
	/**
	 * getter method of rank
	 * @return
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * getter method for student id
	 * @return
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * getter method of student name
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * getter method for chosen courses
	 * @return
	 */
	public String[] getChoosenCourse() {
		return choosenCourse;
	}
	/**
	 * getter method of course id
	 * @return
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * getter method of course name
	 * @return
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * setter method of course id
	 * @param courseId
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * setter method of course name
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
