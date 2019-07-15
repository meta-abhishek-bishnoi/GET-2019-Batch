/*
 * This is Service Class Of Mark System 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.helper;

import java.text.DecimalFormat;

public class MarksheetImplementation implements MarksheetInterface{

	private DecimalFormat decimalFormat = new DecimalFormat("##.##");
	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn2_MarksheetInterface#averageGrade(java.lang.Double[])
	 * @param Double[] grades contains error of n number students in double format
	 * @return Double average grades of class in format(##.##) 
	 * Assumption grades are always positive
	 * Assumption grades[] size must be grater then equal to 0
	 */
	@Override
	public double averageGrade(double[] grades) throws ArithmeticException {
		double average=00.00;
		double sumGrades=0;
		int dataLength = grades.length;
		for( int i=0; i<dataLength; i++ ){
			sumGrades += grades[i];
		}
		average = sumGrades/dataLength;
		average = Double.parseDouble( decimalFormat.format(average) );
		return average;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn2_MarksheetInterface#maximumGrade(java.lang.Double[])
	 * @param Double[] grades contains error of n number students in double format
	 * @return Double maximum grades of class in format(##.##) 
	 * Assumption grades are always positive
	 * Assumption grades[] size must be grater then equal to 0
	 */
	@Override
	public double maximumGrade(double[] grades) throws ArithmeticException {
		double maximumGrade=Integer.MIN_VALUE;
		int dataLength = grades.length;
		for( int i=0; i<dataLength; i++ ){
			if(grades[i]>maximumGrade){
				maximumGrade = grades[i];
			}
		}
		maximumGrade = Double.parseDouble( decimalFormat.format(maximumGrade) );
		return maximumGrade;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn2_MarksheetInterface#minimumGrade(java.lang.Double[])
	 * @param Double[] grades contains error of n number students in double format
	 * @return Double minimum grades of class in format(##.##) 
	 * Assumption grades are always positive
	 * Assumption grades[] size must be grater then equal to 0
	 */
	@Override
	public double minimumGrade(double[] grades) throws ArithmeticException {
		double minimumGrade=Integer.MAX_VALUE;
		int dataLength = grades.length;
		for( int i=0; i<dataLength; i++ ){
			if(grades[i]<minimumGrade){
				minimumGrade = grades[i];
			}
		}
		minimumGrade = Double.parseDouble( decimalFormat.format(minimumGrade) );
		return minimumGrade;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn2_MarksheetInterface#getPassedStudent(java.lang.Double[])
	 * @param Double[] grades contains error of n number students in double format
	 * @return Double percents of passing students in format(##.##) 
	 * Assumption grades are always positive
	 * Assumption grades[] size must be grater then equal to 0
	 */
	@Override
	public double getPassedStudentPercentage(double[] grades) throws ArithmeticException {
		int noOfPassedStudents=0;
		double passedStudentPercentage=0;
		int dataLength = grades.length;
		for( int i=0; i<dataLength; i++ ){
			if(grades[i]>=40){
				noOfPassedStudents++;
			}
		}
		passedStudentPercentage = (double)((noOfPassedStudents)/(double)(dataLength)*100);
		passedStudentPercentage = Double.parseDouble( decimalFormat.format(passedStudentPercentage) );
		return passedStudentPercentage;
	}

}
