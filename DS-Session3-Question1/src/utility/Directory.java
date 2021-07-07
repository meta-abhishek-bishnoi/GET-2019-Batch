/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This is Structure Class Of Directory
 */
package utility;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Directory {
	String dirName;
	Directory parents;
	Date date;
	String path;
	Map<String,Directory> mapDirectory = new LinkedHashMap<String,Directory>();
	/**
	 * This Constructor is used to create new Directory
	 * @param dirName String as directory name
	 * @param parents Directory parent Node
	 * @param date Directory creation Time Stamp
	 * @param path 
	 * 
	 */
	public Directory(String dirName, Directory parents, Date date, String path){
		this.dirName = dirName.trim();
		this.parents = parents;
		this.date = date;
		this.path = path;
	}
	/**
	 * These are getter methods for each variable
	 */
	public String getDirName() {
		return dirName;
	}
	public Directory getParents() {
		return parents;
	}
	
	public Date getDate() {
		return date;
	}
	public Map<String, Directory> getMapDirectory() {
		return mapDirectory;
	}
	// toString provides time stamp and directory name as string
	public String toString(){
		return Service.getDate(date)+" "+this.getDirName();
	}
	
	public String getPath() {
		return path;
	}
	/**
	 * Adding Child Directory To Parent Directory Map
	 * @param directory
	 * @return boolean value
	 * @exception AssertionError if child is null object
	 */
	public boolean addDirectoryToMap(Directory directory){
		if(directory==null){
			throw new AssertionError("Null Can't Be Directory");
		}
		
		mapDirectory.put(directory.getDirName(), directory);
		return true;
	}
}
