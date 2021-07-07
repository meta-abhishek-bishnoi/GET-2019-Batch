/*
 * This is utility class of split array function and it returns index where 
 * left sum of of array is equal to right sum of array
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 17-July-2019
 */
package meta.utility;

import java.util.Properties;

public class SplitArray{

	/*
	 * @param int[] this is data on which we perform splitArray Function to get index
	 * @return int index of balanced array where left sum equal to right sum
	 * Assumption array should is not empty
	 * Complexity - O(n)+O(n) ~ O(n)
	 */
	public int splitArray(int[] array) throws Exception {
		ArrOperations operations = new ArrOperations(); // Object of ArrOperation Class
		Properties properties = new Properties(); // Object Of Properties Class
		properties = operations.getMessages(); // loading messages from .properties file
		int returnIndex=-1;
		int arraySum = getArraySum(array); // calling getArraySum function Complexity O(n)
		int leftSum=0;
		int arrayLength = array.length;
		/*
		 * throws Exception if size is zero
		 */
		if(arrayLength==0){
			throw new AssertionError(properties.getProperty("SIZE_ZERO"));
		}
		/*
		 * Checking Sum Of leftside and rightside
		 * Complexity O(n)
		 */
		for(int i=0; i<arrayLength; i++)
		{
			leftSum+=array[i];
			if(arraySum-(2*leftSum)==0){
				returnIndex=i+1;
				return returnIndex;
			}
		}
		return returnIndex;
	}

	/*
	 * @param int[] array to get sum 
	 * return int sum of array elements
	 * Complexity O(n)
	 */
	private int getArraySum(int[] array) {
		int arraySum=0;
		for(int value:array){
			arraySum+=value;
		}
		return arraySum;
	}

}
