/*
 * This is generalized class structure of mark system
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.helper;

public interface MarksheetInterface {
	public double averageGrade(double[] grades) throws ArithmeticException;
	public double maximumGrade(double[] grades) throws ArithmeticException;
	public double minimumGrade(double[] grades) throws ArithmeticException;
	public double getPassedStudentPercentage(double[] grades) throws ArithmeticException;
}
