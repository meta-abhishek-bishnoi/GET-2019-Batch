/*
 * This class is utility class where 
 * we exchange position of y wrt to x 
 * and return to caller funtion
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 16-July-2019
 */
package meta.utility;

import java.util.Properties;

public class FixXY {
	/*
	 * This function rearrange value of x-axis and y-axis 
	 * as y axis value is just next value of x-axis
	 * @param int x-axis value
	 * @param int y-axis value
	 * @param int[] data array containing x-axis and y-axis values
	 * @return return rearranged array as per requirement
	 * Assumption
	 * Assumption
	 * Complexity : O(n)+O(n)+O(n)+O(m)+O(m) = 3*O(n)+2*O(m) where m<n
	 */
	public int[] fixXy( int x, int y, int dataXY[] ) throws Exception{
		ArrOperations operations = new ArrOperations(); // Class ArrOperations object
		Properties properties = new Properties(); // Class Properties object
		properties = operations.getMessages(); // loading messages in properties format
		int dataLength = dataXY.length ; 
		if(dataLength==0){ // throw Exception when size is zero
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
		int indexesOfX[] = new int[dataLength]; // 
		int indexesOfY[] = new int[dataLength]; //
		int countOfX = getIndexCount( indexesOfX ); 
		// getting total no of X axis in data; Complexity O(n/2) = O(m)
		int countOfY = getIndexCount( indexesOfY ); 
		// getting total no of Y axis in data; Complexity O(n/2) = O(m)
		boolean isXValAdjacent = isAdjacent( x, indexesOfX );
		// checking if X-axis is adjacent or not; Complexity O(n)
		indexesOfX = getIndexOf( x, dataXY ); 
		// getting indexNo of X Axis; Complexity O(n)
		indexesOfY = getIndexOf( y, dataXY ); 
		// getting indexNo of Y Axis; Complexity O(n)
		/*
		 * section where we through an exception
		 */
		if(countOfX!=countOfY){ // if no of X-axis & Y-axis are not equal throw an Exception
			throw new IllegalArgumentException(properties.getProperty("NOT_EQUAL_NUMBER"));
			// msg from .properties
		}else if( x == dataXY[dataLength-1] ){ // if X-axis value is last value of array throw an Exception
			throw new IllegalArgumentException(properties.getProperty("X_LAST_INDEX"));
		}
		else if(isXValAdjacent){ // if we found X-axis values adjacent then throw an Exception
			throw new IllegalArgumentException(properties.getProperty("A_ADJACENT_VALUE"));
		}
		/*
		 *  Complexity O(n)
		 */
		for(int i=0; i<dataLength; i++){
			if( i==0 && ( indexesOfX[i] == 0 || indexesOfY[i] == 0 )){ // if we 0 as value on index 0
				int currentXIndex = indexesOfX[i];
				int currentYIndex =  indexesOfY[i];
				if( currentYIndex - currentXIndex !=1 ){
					int tempElement = dataXY[currentXIndex+1];
					dataXY[currentXIndex+1] = dataXY[currentYIndex];
					dataXY[currentYIndex] = tempElement;
				}
			}
			else if( indexesOfX[i]>0 && indexesOfY[i]>0 ){ //otherwise
				int currentXIndex = indexesOfX[i];
				int currentYIndex =  indexesOfY[i];
				if( currentYIndex - currentXIndex !=1 ){
					int tempElement = dataXY[currentXIndex+1];
					dataXY[currentXIndex+1] = dataXY[currentYIndex];
					dataXY[currentYIndex] = tempElement;
				}
			}
			if( indexesOfX[i]==0 && indexesOfY[i]==0 && i != 0 ){ 
				// if we get 0 at any other index we return result
				// because we store indxes of x & y axis so zero means no more elements
				return dataXY;
			}
		}
		return dataXY;
	}

	/*
	 * calculate if x axis is adjacent or not
	 * @param int value which we are checking adjacent or not
	 * @param int[] array/data value 
	 * @return boolean true or false as result
	 * Assumption Array is Not Empty
	 * Complexity O(n)
	 */
	private boolean isAdjacent(int x, int[] data) {
		boolean result = false;
		int lastVal = Integer.MIN_VALUE;
		for(int val : data){
			if( val==x && lastVal== val){
				result = true;
				return result;
			}
		}
		return result;
	}

	/*
	 * provide no of x or y axis in array 
	 * @param Array in which we are checking counting no of axis
	 * @return value of axis (occrance time)
	 * Complexity O(n/2) - worst case if array is full of x-axis & y-axis Value Only
	 */
	private int getIndexCount( int[] indexes ) {
		int numCount=0;
		int length = indexes.length;
		for( int i=0; i<length; i++ )
		{
			if(i==0&& indexes[i]==0){ // if we get 0 at index at 0
				numCount++;
			}
			else if(indexes[i]>0){ // other non zero indexes
				numCount++;
			}
			
			if(indexes[i]==0 && i!=0){ // if we get zero at any other index
				return numCount;
			}
		}
		return numCount;
	}

	/*
	 * this function calculate indexValue of axis and store them into an array
	 * @param int value of that axis
	 * @param int[] all array value
	 * @return int[] return that particular index array in array
	 * Complexity O(n)
	 */
	private int[] getIndexOf(int data, int[] dataXY) {
		int length = dataXY.length;
		int returnArray[] = new int[length];
		int index=0;
		for(int i=0; i<length;  i++ ){
			int val = dataXY[i];
			if(val==data){
				returnArray[index]=i; // updating index from start
				index++;
			}
		}
		return returnArray;
	}
}
