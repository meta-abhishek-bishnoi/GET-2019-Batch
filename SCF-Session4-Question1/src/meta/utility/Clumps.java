/*
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 16-July-2019
 */
package meta.utility;

import java.util.Properties;

public class Clumps{

	/*
	 * (non-Javadoc)
	 * @see meta.utility.Clumps#getClumpsCount(int[])
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
		if(arrayLength==0){
			throw new IllegalArgumentException(properties.getProperty("SIZE_ZERO"));
		}
		/*
		 * 
		 */
		for(int i = 0 ; i < arrayLength ; i++ ){
			currentDigit = arrayData[i];
			/*
			 * 
			 */
			if((lastDigit==currentDigit)&&(lastDigit!=secondLastDigit)){
				countClumps++;
			}
			/*
			 * 
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
