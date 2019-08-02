package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Service {
	/**
	 * 
	 * @param dirName
	 * @param parent
	 * @return
	 */
	static int id = 0;
	public static boolean createDir(String dirName, Directory parent){
		Date timeStamp = java.util.Calendar.getInstance().getTime();
		Map<String,Directory> map = parent.getMapDirectory();
		if(map.containsKey(dirName)){
			dirName += "("+(++id)+")";
		}
		Directory newDir = new Directory(dirName,parent,timeStamp, parent.getPath()+"/"+dirName);
		parent.addDirectoryToMap(newDir);
		return true;
	}
	/**
	 * 
	 * @param directries
	 * @param parent
	 * @return
	 */
	public static boolean createDir(List<String> directries, Directory parent){
		for(String directory: directries){
			createDir(directory, parent);
		}
		return true;
	}
	
	public static String getDirList(Directory current){
		StringBuffer result = new StringBuffer();
		int count=0;
		Directory directory = current;
		Map<String,Directory> map = directory.getMapDirectory();
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			result.append(entry.getValue().toString()+"\n");
			count++;
		}
		result.append("\t\t\tFolders ("+count+")");
		return result.toString();
	}
	/**
	 * 
	 */
	public static Directory changeDir(String dirName, Directory current) {
		Map<String,Directory> map = current.getMapDirectory();
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			if(entry.getValue().getDirName().equals(dirName)){
				return entry.getValue();
			}
		}
		return null;
	}
	/**
	 * 
	 */
	public static Directory parentDir(Directory current) {
		return current.getParents();
	}
	/**
	 * 
	 */
	public static String findDir(String find, Directory current){
		StringBuffer result = new StringBuffer();
		if(current.getDirName().contains(find)){
			result.append(current.getPath()+"\n");
		}
		Map<String,Directory> map = current.getMapDirectory();
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			result.append( findDir(find,entry.getValue()) );
		}
		return result.toString();
	}
	/**
	 * 
	 */
	public static String dirTree(Directory current){
		StringBuffer result = new StringBuffer();
		Map<String,Directory> map = current.getMapDirectory();
		result.append(current.getPath()+"\n");
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			result.append(dirTree(entry.getValue()));
		}
		return result.toString();
	}
	/**
	 * 
	 */
	public static String getDate(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		 return formatter.format(date);
	}
	
	
}
