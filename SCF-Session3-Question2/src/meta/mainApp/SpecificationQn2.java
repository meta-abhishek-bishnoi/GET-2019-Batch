/*
 * This is driven class for marks/grade system
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.SpecificationQn2_MarksheetImple;
import meta.helper.SpecificationQn2_Message;

public class SpecificationQn2 {
	public static void main(String[] args) {
		SpecificationQn2_MarksheetImple service = new SpecificationQn2_MarksheetImple();
		// service class object
		int NoOfStudents = getIntInput( SpecificationQn2_Message.NO_OF_STUDENTS );
		// getting no of students
		double studentsGradesData[] = new double[NoOfStudents]; // array to store data of students
		/*
		 * loop for getting data(grades) from user
		 */
		for(int i=0; i<NoOfStudents; i++){
			String message = SpecificationQn2_Message.GRADES_FOR_STUDENT;
			studentsGradesData[i] = getDoubleInput( message, i+1 );
		}
		double averageGrades = service.averageGrade(studentsGradesData); // average grades in class room
		double maximumGrades = service.maximumGrade(studentsGradesData); // maximum grade of classroom
		double minimumGrades = service.minimumGrade(studentsGradesData); // minimum grade of classroom
		double studentsPassingPercentage = service.getPassedStudentPercentage(studentsGradesData);
		String message = SpecificationQn2_Message.AVG_MARKS;
		printResult(message,averageGrades); // printing result
		message = SpecificationQn2_Message.MAX_MARKS;
		printResult(message,maximumGrades);
		message = SpecificationQn2_Message.MIN_MARKS;
		printResult(message,minimumGrades);
		message = SpecificationQn2_Message.PASS_STU;
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
			System.out.println(SpecificationQn2_Message.ERROR_MARKS);
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
			System.out.println(SpecificationQn2_Message.ERROR_INPUT);
			return getIntInput(noOfStudents);
		}
		return studentsNo;
	}
}
