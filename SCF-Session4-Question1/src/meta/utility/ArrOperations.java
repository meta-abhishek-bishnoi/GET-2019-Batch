/*
 * This class calls function of other operational class and return to caller class
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 17-july-2019
 */
package meta.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ArrOperations {
	/*
	 * this function calls Clump class function getClupmsCount and return to caller function
	 * @param int[] array data where we have to find no of clumps
	 * @return int noOfClupms this returns from clump object function
	 */
	public int getClumpsCount( int arrayData[] ) throws Exception{
		Clumps clump = new Clumps();
		return clump.getClumpsCount(arrayData);
	}
	/*
	 * this function calls FixXY class function fixXy and return to caller function
	 * @param int[] array of data
	 * @return int[] an array after fixing x & y from fixXY object function
	 */
	public int[] fixXy( int x, int y, int dataXY[] ) throws Exception{
		FixXY fixXY = new FixXY();
		return fixXY.fixXy(x, y, dataXY);
	}
	/*
	 * this function calls MirrorSection class function getLargestMirrorSection and return to caller function
	 * @param int[] array of data 
	 * @return int value of largest mirror section
	 */
	public int getLargestMirrorSection(int arrayData[]) throws Exception{
		MirrorSection object = new MirrorSection();
		return object.getLargestMirrorSection(arrayData);
	}
	/*
	 * this function calls SplitArray class function splitArray and return to caller function
	 * @param int[] array data where we have to find no of clumps
	 * @return int value of largest mirror section
	 */
	public int splitArray(int[] array) throws Exception {
		SplitArray object = new SplitArray();
		return object.splitArray(array);
	}
	/*
	 * this function returns Property object 
	 * This loads property file and return it to caller function
	 */
	public Properties getMessages() throws IOException{
		FileReader reader=new FileReader("src/meta/test/message.properties");
		Properties properties=new Properties();  
		properties.load(reader);
		return properties;
	}
}
