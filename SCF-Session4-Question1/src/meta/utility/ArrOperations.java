package meta.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ArrOperations {
	/*
	 * 
	 */
	public int getClumpsCount( int arrayData[] ) throws Exception{
		Clumps clumps = new Clumps();
		return clumps.getClumpsCount(arrayData);
	}
	/*
	 * 
	 */
	public int[] fixXy( int x, int y, int dataXY[] ) throws Exception{
		FixXY obj = new FixXY();
		return obj.fixXy(x, y, dataXY);
	}
	/*
	 * 
	 */
	public int getLargestMirrorSection(int arrayData[]) throws Exception{
		MirrorSection object = new MirrorSection();
		return object.getLargestMirrorSection(arrayData);
	}
	/*
	 * 
	 */
	public int splitArray(int[] array) throws Exception {
		SplitArray object = new SplitArray();
		return object.splitArray(array);
	}
	/*
	 * 
	 */
	public Properties getMessages() throws IOException{
		FileReader reader=new FileReader("src/meta/test/message.properties");
		Properties properties=new Properties();  
		properties.load(reader);
		return properties;
	}
}
