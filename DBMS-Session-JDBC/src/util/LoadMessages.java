/**
 * 
 */
package util;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class LoadMessages {
	public static FileReader reader; 
	public static Properties properties; 
	/**
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public  LoadMessages( String filename ) throws IOException{
		reader=new FileReader("src/resources/"+filename);
		properties=new Properties();  
		properties.load(reader);
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public String getMessage( String string ){
		return properties.getProperty(string);
	}
	/**
	 * 
	 * @return
	 */
	public Properties getProperties(){
		return properties;
	}
}
