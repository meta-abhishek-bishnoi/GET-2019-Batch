package meta.utility;

public class LCM {
	public static int firstValue=0;
	public static int secondValue=0;
	public static int lcmValue;
	static int flag = -1;
	/*
	 * this function calculates LCM of 2 values using Recursion
	 * @param int this is the first value for lcm opertaion
	 * @param int int this is the second value for lcm opertaion
	 * return int returns lcm 
	 * Assumption All Values Are Positive
	 */
	public int lcm(){
		/*
		 * if we get 0 values as input First Time
		 */
		if(flag==-1){
			if( firstValue==0 || secondValue == 0){
				return 0;
			}
		}
		flag=0; // disabling flag
		/*
		 * if first value is greater then second value then we swap the values
		 */
		if(firstValue>secondValue){
			int tempValue = firstValue;
			firstValue = secondValue;
			firstValue = firstValue;
		}
		
		lcmValue += secondValue;
		// adding largest values in lcmValue
		if( lcmValue%firstValue == 0 && lcmValue%secondValue == 0 ){
			 return lcmValue;
		}
		return lcm();
	}
}
