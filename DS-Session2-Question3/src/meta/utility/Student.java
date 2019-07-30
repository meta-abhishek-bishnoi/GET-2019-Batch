/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 */
package meta.utility;

public class Student {
	int rank;
	String studentId;
	String studentName;
	String choosenCourse[];
	String courseId;
	String courseName;
	public Student(int rank, String studentId, String studentName,
			String[] choosenCourse) {
		super();
		this.rank = rank;
		this.studentId = studentId;
		this.studentName = studentName;
		this.choosenCourse = choosenCourse;
	}
	public int getRank() {
		return rank;
	}
	public String getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public String[] getChoosenCourse() {
		return choosenCourse;
	}
	public String getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
