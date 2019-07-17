// Task: Message Pass Through .properties File
package meta.utility;

import java.util.Properties;

public class FixXY {
	public int[] fixXy( int x, int y, int dataXY[] ) throws Exception{
		ArrOperations operations = new ArrOperations();
		Properties properties = new Properties();
		properties = operations.getMessages();
		int dataLength = dataXY.length ;
		if(dataLength==0){
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
		int indexesOfX[] = new int[dataLength]; //
		int indexesOfY[] = new int[dataLength]; //
		int countOfX = getIndexCount( indexesOfX ); //
		int countOfY = getIndexCount( indexesOfY ); //
		boolean isXValAdjacent = isAdjacent( x, indexesOfX );//
		indexesOfX = getIndexOf( x, dataXY ); //
		indexesOfY = getIndexOf( y, dataXY ); //
		/*
		 * 
		 */
		if(countOfX!=countOfY){
			throw new IllegalArgumentException(properties.getProperty("NOT_EQUAL_NUMBER"));
			// msg from .properties
		}else if( x == dataXY[dataLength-1] ){
			throw new IllegalArgumentException(properties.getProperty("X_LAST_INDEX"));
		}
		else if(isXValAdjacent){
			throw new IllegalArgumentException(properties.getProperty("A_ADJACENT_VALUE"));
		}
		/*
		 * 
		 */
		for(int i=0; i<dataLength; i++){
			if( i==0 && ( indexesOfX[i] == 0 || indexesOfY[i] == 0 )){
				int currentXIndex = indexesOfX[i];
				int currentYIndex =  indexesOfY[i];
				if( currentYIndex - currentXIndex !=1 ){
					int tempElement = dataXY[currentXIndex+1];
					dataXY[currentXIndex+1] = dataXY[currentYIndex];
					dataXY[currentYIndex] = tempElement;
				}
			}
			else if( indexesOfX[i]>0 && indexesOfY[i]>0 ){
				int currentXIndex = indexesOfX[i];
				int currentYIndex =  indexesOfY[i];
				if( currentYIndex - currentXIndex !=1 ){
					int tempElement = dataXY[currentXIndex+1];
					dataXY[currentXIndex+1] = dataXY[currentYIndex];
					dataXY[currentYIndex] = tempElement;
				}
			}
			if( indexesOfX[i]==0 && indexesOfY[i]==0 && i != 0 ){
				
			}
		}
		return dataXY;
	}

	/*
	 * 
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
	 * 
	 */
	private int getIndexCount( int[] indexes ) {
		int numCount=0;
		int length = indexes.length;
		for( int i=0; i<length; i++ )
		{
			if(i==0&& indexes[i]==0){ //
				numCount++;
			}
			else if(indexes[i]>0){
				numCount++;
			}
			if(indexes[i]==0 && i!=0)
			{
				return numCount;
			}
		}
		return numCount;
	}

	/*
	 * 
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
