/**
 * This class is used to load messages from .properties file 
 * and return it to driver function 
 * @author Abhishek Bishnoi
 * @since Aug 16, 2019
 */
package util;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class LoadMessages {
	public static FileReader reader; 
	public static Properties properties; 
	/**
	 * This function Load .properties file of given path
	 * @param filename file which data should be loaded
	 * @throws IOException
	 */
	public  LoadMessages( String filename ) throws IOException{
		reader=new FileReader("src/resources/"+filename);
		properties=new Properties();  
		properties.load(reader);
	}
	/**
	 * 
	 * @param string Property
	 * @return String result
	 */
	public String getMessage( String string ){
		return properties.getProperty(string);
	}
	/**
	 * 
	 * @return Properites
	 */
	public Properties getProperties(){
		return properties;
	}
}
