/*
 * This class is utility class where 
 * this class calculates clupms as per requests
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 16-July-2019
 */
package meta.utility;

import java.util.Properties;

public class Clumps{

	/*
	 * this function is calculate clupms into an array 
	 * where clumps are no of adjacent values in array
	 * @param int[] array where we have to calculate clupms
	 * @return no of clumps
	 * Assumption Array Values are Positive 
	 * Assumption Array is Not Empty
	 * Complexity O(n)
	 */
	public int getClumpsCount( int arrayData[] ) throws Exception{
		ArrOperations operations = new ArrOperations();
		Properties properties = new Properties();
		properties = operations.getMessages();
		int countClumps = 0;
		int secondLastDigit = 0;
		int lastDigit = 0;
		int currentDigit = 0;
		int arrayLength = arrayData.length;
		/*
		 * throw an Exception if arraySize is zero
		 */
		if(arrayLength==0){
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
		/*
		 * 
		 */
		for(int i = 0 ; i < arrayLength ; i++ ){
			currentDigit = arrayData[i];
			/*
			 * if second last and last digit are not same then it is a new clump in array
			 */
			if((lastDigit==currentDigit)&&(lastDigit!=secondLastDigit)){
				countClumps++;
			}
			/*
			 *  if i ==0 then update only last value 
			 *  otherwise update secondLast and lastValue
			 */
			if(i!=0){
				secondLastDigit = lastDigit;
				lastDigit = currentDigit;
			}else{
				lastDigit = currentDigit;
			}
		}
		return countClumps;
	}
}
