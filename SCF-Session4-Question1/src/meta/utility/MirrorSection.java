/*
 * This class is utility class where we calculate
 * maximum index of mirror image
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 17-July-2019
 */
package meta.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MirrorSection {
	/*
	 * @param int[] array data to find maximum length of array index
	 * return int size of mirror image
	 * Assumption All Array values are Positive
	 * Assumption Array size is not zero
	 * Complexity O(n*2)
	 */
	public int getLargestMirrorSection(int arrayData[]) throws Exception{
		ArrOperations operations = new ArrOperations(); // ArrOperations object 
		Properties properties = new Properties(); //Properties object
		properties = operations.getMessages(); // loading message
		int arraySize = arrayData.length;
		int maxResultValue=0;
		/*
		 * throws an exception if size is zero
		 */
		if(arraySize==0){
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
		int arrayResultValue[][] = new int[arraySize+1][arraySize+1];
		// 2-D array to track the data of last string matches
		/*
		 * this loop is used for finding common/ mirror digits in array
		 * complexity O(n*2)
		 */
		for( int i=0; i<=arraySize; i++ ){
			for(int j=0; j<=arraySize; j++){
				if(i==0||j==0){ // when i and j both equals to zero
					arrayResultValue[i][j]=0;
				}else if(arrayData[i-1]==arrayData[arraySize-j] ){ 
					// when from front and last side both side digits matches 
					arrayResultValue[i][j]=arrayResultValue[i-1][j-1]+1;
					maxResultValue = Math.max(maxResultValue, arrayResultValue[i][j]);
				}else{
					arrayResultValue[i][j]=0;
				}
			}
		}
		return maxResultValue;
	}
	
}
