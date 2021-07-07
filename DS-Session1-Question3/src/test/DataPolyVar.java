/**
 * @author Abhishek Bishnoi
 * @since Jul 31, 2019
 * This class Contains Data in form of PolyVar, polyVar String, and degree 
 */
package test;

import utility.PolyVar;
import utility.Variable;

public class DataPolyVar {
	public static PolyVar getPolyVarOne(){
		PolyVar polyVar = new PolyVar(3,'+');
		polyVar.addVariable(new Variable('x',2));
		polyVar.addVariable(new Variable('y',2));
		polyVar.addVariable(new Variable('z',-3));
		return polyVar;
	}
	public static String getPolyOneString(){
		return "+3(x^2)(y^2)(z^-3)";
	}
	public static int getPolyOneDegree(){
		return 1;
	}
	public static PolyVar getPolyVarTwo(){
		PolyVar polyVar = new PolyVar(2,'-');
		polyVar.addVariable(new Variable('x',1));
		polyVar.addVariable(new Variable('y',2));
		polyVar.addVariable(new Variable('w',-1));
		return polyVar;
	}
	public static String getPolyTwoString(){
		return "-2(x)(y^2)(w^-1)";
	}
	public static int getPolyTwoDegree(){
		return 2;
	}
	
	public static PolyVar getPolyVarThree(){
		PolyVar polyVar = new PolyVar(12,'+');
		polyVar.addVariable(new Variable('p',3));
		polyVar.addVariable(new Variable('q',5));
		polyVar.addVariable(new Variable('r',13));
		return polyVar;
	}
	public static String getPolyThreeString(){
		return "+12(p^3)(q^5)(r^13)";
	}
	public static int getPolyThreeDegree(){
		return 21;
	}
	
	public static PolyVar getPolyVarFour(){
		PolyVar polyVar = new PolyVar(7,'+');
		polyVar.addVariable(new Variable('p',7));
		polyVar.addVariable(new Variable('r',9));
		polyVar.addVariable(new Variable('s',11));
		return polyVar;
	}
	public static String getPolyFourString(){
		return "+7(p^7)(r^9)(s^11)";
	}
	public static int getPolyFourDegree(){
		return 27;
	}
	/**
	 * 
	 * @param var: array of degrees
	 * @return max degree
	 */
	public static int getDegree(int var[]){
		int max = Integer.MIN_VALUE;
		for(int val: var){
			if(val>max){
				max = val;
			}
		}
		return max;
	}
}
