 /*
 * This class Contains Recurrsive Function 
 * To Find LCM Value Of Two Numbers
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 18-July-2019
 */
 package meta.utility;

public class LCM {
	private static int divisor=0;
	/*
	 * @param int as a first value
	 * @param int as a second value
	 * return int lcm value
	 * Exception throw AssertionError when any value is zero to calculate LCM
	 * Assumption All Values Are Positive
	 */
	public static int lcm(int firstValue, int secondValue)
	{
		if(firstValue==0||secondValue==0){
			throw new AssertionError("Not A Number");
		}
		if(firstValue%secondValue==0){
			return firstValue;
		}
		else{
			divisor++;
			firstValue = firstValue+firstValue/divisor;
			return lcm(firstValue,secondValue);
		}
	}
}
