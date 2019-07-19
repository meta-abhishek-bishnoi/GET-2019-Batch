/*
* This Class Contains Function to Calculte HCF using Recursive Fn Calling
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 18-July-2019
*/
package meta.utility;

public class HCF {

	public static int firstValue=0;
	public static int secondValue=0;
	/*
	 * this function calculates hcf of 2 values using Euclid Algorithm
	 * To know more About Euclid Algorithm follow this 
	 * https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param int this is the first value for hcf opertaion
	 * @param int int this is the second value for hcf opertaion
	 * return int returns hcf 
	 * Assumption All Values Are Positive
	 */
	static int flag = -1;
	public int hcf( ){ // hcf(3,5)
		int hcf = 1;
		if(flag==-1){
			if( firstValue==0 || secondValue == 0){
				return 0;
			}
		}
		flag=0;
		/*
		 * Euclid Algorithm is works when first value is greater then second value
		 * so in this section we swap the values if second value is larger then first
		 */
		if(secondValue>firstValue){
			int tempValue = secondValue; //5
			secondValue = firstValue; //3
			firstValue = tempValue; //5
		}
		/*
		 * if we found the secondValue as zero
		 * then first value is hcf of them 
		 */
		if(secondValue==0)
		{
			hcf = firstValue;
			return hcf;
		}
		else{
			/*
			 * in Euclid Algorithm 
			 * hcf(a,b) = hcf(b,|a/b|) while b!=0 where || represents to mod()
			 * so following this strategy
			 */
			int tempValue = firstValue; //5
			firstValue = secondValue; //3
			secondValue = (tempValue%secondValue); //2
			return hcf();
		}
		//return hcf;
	}
}
