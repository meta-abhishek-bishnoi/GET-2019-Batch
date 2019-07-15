/*
 * This is driven class for marks/grade system
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.MarksheetImplementation;
import meta.helper.Messages;

public class GradeSystem {
	public static void main(String[] args) {
		MarksheetImplementation service = new MarksheetImplementation();
		// service class object
		int NoOfStudents = getIntInput( Messages.NO_OF_STUDENTS );
		// getting no of students
		double studentsGradesData[] = new double[NoOfStudents]; // array to store data of students
		/*
		 * loop for getting data(grades) from user
		 */
		for(int i=0; i<NoOfStudents; i++){
			String message = Messages.GRADES_FOR_STUDENT;
			studentsGradesData[i] = getDoubleInput( message, i+1 );
		}
		double averageGrades = service.averageGrade(studentsGradesData); // average grades in class room
		double maximumGrades = service.maximumGrade(studentsGradesData); // maximum grade of classroom
		double minimumGrades = service.minimumGrade(studentsGradesData); // minimum grade of classroom
		double studentsPassingPercentage = service.getPassedStudentPercentage(studentsGradesData);
		String message = Messages.AVG_MARKS;
		printResult(message,averageGrades); // printing result
		message = Messages.MAX_MARKS;
		printResult(message,maximumGrades);
		message = Messages.MIN_MARKS;
		printResult(message,minimumGrades);
		message = Messages.PASS_STU;
		printResult(message,studentsPassingPercentage);
	}

	/*
	 * @param String as a message string
	 * @param int as a value for that message string
	 * @return nothing(void)
	 * prints the message with value
	 */
	private static void printResult(String message, double value) {
		System.out.println(message+value);
	}

	/*
	 * @param String as a message string
	 * @param int as a value for that message string
	 * @return double to main function from after taking from user
	 */
	private static double getDoubleInput(String message, int i) {
		System.out.println(message+i);
		Scanner scanNumber = new Scanner(System.in);
		double inputGrade = scanNumber.nextDouble();
		/*
		 * if grades are less then 0 then will cause an error 
		 * and return same function or recursively call
		 */
		if(inputGrade<=0){
			System.out.println(Messages.ERROR_MARKS);
			return getDoubleInput(message,i);
		}
		return inputGrade;
	}

	/*
	 *  @param String as a message string
	 *  @return double to main function from after taking from user
	 */
	private static int getIntInput(String noOfStudents) {
		System.out.println(noOfStudents);
		Scanner scanNumber = new Scanner(System.in);
		int studentsNo = scanNumber.nextInt();
		/*
		 * if grades are less then equal to 0 then will cause an error 
		 * and return same function or recursively call
		 */
		if(studentsNo<=0){
			System.out.println(Messages.ERROR_INPUT);
			return getIntInput(noOfStudents);
		}
		return studentsNo;
	}
}
