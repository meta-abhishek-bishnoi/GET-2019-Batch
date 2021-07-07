/*
* This class is contains expected array for addition and multiplication
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 22-July-2019
*/
package meta.test;

import meta.utility.Poly;

public class testArrayAns {

	public static Poly[] ADDITION_ONE_ONE = {
		new Poly(2,1),
		new Poly(4,0)
	};
	public static Poly[] MULTIPLY_ONE_ONE = {
		new Poly(4,0),
		new Poly(4,1),
		new Poly(1,2)
	};
	public static Poly[] ADDITION_TWO_TWO = {
		new Poly(2,1),
		new Poly(4,3),
		new Poly(4,0)
	};
	public static Poly[] MULTIPLY_TWO_TWO = {
		new Poly(4,0),
		new Poly(4,1),
		new Poly(1,2),
		new Poly(8,3),
		new Poly(4,4),
		new Poly(4,6)
	};
	public static Poly[] ADDITION_ONE_TWO = {
		new Poly(2,1),
		new Poly(4,0),
		new Poly(2,3)
	};
	public static Poly[] MULTIPLY_ONE_TWO = {
		new Poly(4,0),
		new Poly(4,1),
		new Poly(1,2),
		new Poly(4,3),
		new Poly(2,4)
	};
	public static Poly[] ADDITION_THREE_FIVE = {
		new Poly(1,4),
		new Poly(-4,3),
		new Poly(3,0),
		new Poly(1,1)
	};
	public static Poly[] MULTIPLY_THREE_FIVE = {
		new Poly(-4,0),
		new Poly(4,1),
		new Poly(4,3),
		new Poly(-5,4),
		new Poly(1,5)
	};
	public static Poly[] ADDITION_SIX_FIVE = {
		new Poly(1,2),
		new Poly(-4,1),
		new Poly(8,0)
	};
	public static Poly[] MULTIPLY_SIX_FIVE = {
		new Poly(-9,0),
		new Poly(14,1),
		new Poly(-6,2),
		new Poly(1,3)
	};
}
