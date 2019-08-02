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
	public Directory(String dirName, Directory parents, Date date, String path){
		this.dirName = dirName;
		this.parents = parents;
		this.date = date;
		this.path = path;
	}
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
	public String toString(){
		return Service.getDate(date)+" "+this.getDirName();
	}
	
	public String getPath() {
		return path;
	}
	public boolean addDirectoryToMap(Directory directory){
		if(directory==null){
			throw new AssertionError("Null Can't Be Directory");
		}
		
		mapDirectory.put(directory.getDirName(), directory);
		return true;
	}
}
