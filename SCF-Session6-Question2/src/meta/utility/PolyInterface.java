/*
 * This is Interface Class Defining Structure for Polynomial Function
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-JUly-2019
 */
package meta.utility;

public interface PolyInterface {
	public double evalute(int array[][], int value);
	public int degree(int array[][]);
	public int[][] addPolynomial(int arrayOne[][], int arrayTwo[][]);
	public int[][] multiplyPolynomial(int arrayOne[][], int arrayTwo[][]);
}
