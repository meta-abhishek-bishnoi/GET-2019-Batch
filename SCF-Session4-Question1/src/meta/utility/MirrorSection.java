package meta.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MirrorSection {
	/*
	 * 
	 */
	public int getLargestMirrorSection(int arrayData[]) throws Exception{
		ArrOperations operations = new ArrOperations();
		Properties properties = new Properties();
		properties = operations.getMessages();
		int arraySize = arrayData.length;
		int maxResultValue=0;
		if(arraySize==0){
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
		int arrayResultValue[][] = new int[arraySize+1][arraySize+1];
		for( int i=0; i<=arraySize; i++ ){
			for(int j=0; j<=arraySize; j++){
				if(i==0||j==0){
					arrayResultValue[i][j]=0;
				}else if(arrayData[i-1]==arrayData[arraySize-j]){
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
