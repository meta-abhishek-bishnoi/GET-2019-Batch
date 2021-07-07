/*
 * This is Interface Class Defining Structure for Polynomial Function
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-JUly-2019
 */
package meta.utility;

public interface PolyInterface {
	public double evalute(Poly array[], int value);
	public int degree(Poly array[]);
	public Poly[] addPolynomial(Poly polyArrayOne[], Poly polyArrayTwo[]);
	public Poly[] multiplyPolynomial(Poly polyArrayOne[], Poly polyArrayTwo[]);
}
