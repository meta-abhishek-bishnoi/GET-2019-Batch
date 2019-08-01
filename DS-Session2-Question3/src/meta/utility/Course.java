/**
 * @author Abhishek Bishnoi
 * @since Jul 31, 2019
 * This Class Defines Structure Of Course with total and allocated seats
 */
package meta.utility;

public class Course {
	String courseId;
	String courseName;
	int totalSeats=0;
	int occupiedSeats=0;
	/**
	 * 
	 * @param courseId : String value of a course as id
	 * @param courseName : String value As a Course Name
	 * @param totalSeats : available seats
	 */
	public Course(String courseId, String courseName, int totalSeats){
		this.courseId = courseId;
		this.courseName = courseName;
		this.totalSeats = totalSeats;
	}
	/**
	 * 
	 * @return boolean value if a seat can be alloted or not
	 */
	public boolean canOccupySeat(){
		if(totalSeats-occupiedSeats>0){
			return true;
		}
		return false;
	}
	/**
	 * allot seat to user
	 */
	public void occupySet(){
		occupiedSeats++;
	}
	/**
	 * @return getter method for course id
	 */
	public String getCourseId(){
		return this.courseId;
	}
	/**
	 * @return getter method for course name
	 */
	public String getCourseName(){
		return this.courseName;
	}
}
