package meta.utility;

public class Course {
	String courseId;
	String courseName;
	int totalSeats=0;
	int occupiedSeats=0;
	public Course(String courseId, String courseName, int totalSeats){
		this.courseId = courseId;
		this.courseName = courseName;
		this.totalSeats = totalSeats;
	}
	/**
	 * 
	 * @return
	 */
	public boolean occupySeat(){
		if(totalSeats-occupiedSeats>0){
			occupiedSeats++;
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public String getCourseId(){
		return this.courseId;
	}
	/**
	 * 
	 */
	public String getCourseName(){
		return this.courseName;
	}
}
