package meta.utility;

public class LCM {
	private static int divisor=0;
	/*
	 * @param int as a first value
	 * @param int as a second value
	 * return int lcm value
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
