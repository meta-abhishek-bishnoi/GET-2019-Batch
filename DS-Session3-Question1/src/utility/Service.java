/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This is Service Class Which provides Functionality to add Directory, find,
 * change Directory, get List of child Directories
 */
package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Service {
	/**
	 * This method is used to create a new Directory
	 * @param dirName String as Directory Name
	 * @param parent Parent Directory
	 * @return boolean Value 
	 */
	static int id = 0;
	public static boolean createDir(String dirName, Directory parent){
		Date timeStamp = java.util.Calendar.getInstance().getTime();
		// getting current time stamp
		Map<String,Directory> map = parent.getMapDirectory();
		/**
		 * if any directory is already present with same name
		 */
		if(map.containsKey(dirName.trim())){
			dirName += "("+(++id)+")";
		}
		Directory newDir = new Directory(dirName.trim(),parent,timeStamp, parent.getPath()+"/"+dirName);
		parent.addDirectoryToMap(newDir);
		return true;
	}
	/**
	 * This Is Overloaded Method to Add Multiple Directories with multiple parameter
	 * @param directries
	 * @param parent
	 * @return boolean values
	 */
	public static boolean createDir(List<String> directries, Directory parent){
		for(String directory: directries){
			createDir(directory.trim(), parent);
		}
		return true;
	}
	
	/**
	 * This Function Returns List Of all child Directories
	 * @param String Directories List
	 */
	public static String getDirList(Directory current){
		StringBuffer result = new StringBuffer();
		int count=0;
		Directory directory = current;
		Map<String,Directory> map = directory.getMapDirectory();
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			result.append(entry.getValue().toString()+"\n");
			count++;
		}
		result.append("\tFolders ("+count+")");
		return result.toString();
	}
	/**
	 * This Function is used to change Directory location which is child of current Directory
	 * @param direName : name of Destination Directory
	 * @param current : Current Directory
	 */
	public static Directory changeDir(String dirName, Directory current) {
		Map<String,Directory> map = current.getMapDirectory();
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			if(entry.getValue().getDirName().equals(dirName.trim())){
				return entry.getValue();
			}
		}
		return null;
	}
	/**
	 * @param current Directory
	 * @return Parent Directory
	 * @exception AssertionError
	 */
	public static Directory parentDir(Directory current) {
		if(current.getParents()==null){
			new AssertionError("You Can't move From Root Directory");
		}
		return current.getParents();
	}
	/**
	 * This Class returns All Directories Which Contains the input String as string or substring
	 * @param find String which dir we gonna find
	 * @param current Directory
	 * @return return list of all directory
	 */
	public static String findDir(String find, Directory current){
		StringBuffer result = new StringBuffer();
		if(current.getDirName().contains(find.trim())){
			result.append(current.getPath()+"\n");
		}
		Map<String,Directory> map = current.getMapDirectory();
		for(Map.Entry<String, Directory> entry : map.entrySet()){
			result.append( findDir(find.trim(),entry.getValue()) );
		}
		return result.toString();
	}
	/**
	 * @param current
	 * @return string of tree structure
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
	 * @param Date as input Object
	 * @return  String in format dd/mm/yyy hh:mm:ss format
	 */
	public static String getDate(Date date){
		if(date==null){
			throw new AssertionError("Date Can't Be Null");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		 return formatter.format(date);
	}
	
	
}
