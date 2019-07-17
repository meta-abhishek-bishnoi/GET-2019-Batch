package meta.utility;

import java.util.Properties;

public class SplitArray{

	public int splitArray(int[] array) throws Exception {
		ArrOperations operations = new ArrOperations();
		Properties properties = new Properties();
		properties = operations.getMessages();
		int returnIndex=-1;
		int arraySum = getArraySum(array);
		int leftSum=0;
		int arrayLength = array.length;
		/*
		 * 
		 */
		if(arrayLength==0){
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
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

	private int getArraySum(int[] array) {
		int arraySum=0;
		for(int value:array){
			arraySum+=value;
		}
		return arraySum;
	}

}
