/**
 * This Class Contains Methods to Calculate Unique Characters in a string 
 * if string is searched before then it will returns you in O(1)
 * else it will take O(n) Complexity 
 * @author Abhishek Bishnoi
 */
package meta.utility;

import java.util.HashMap;
import java.util.Map;

public class UniqueChar {
	// cache map to store cache results
	Map<String, Integer> cacheResult = new HashMap<String, Integer>();
	/**
	 * This Function Counts and return Unique characters in string 
	 * @param string To check Unique Characters
	 * @return unique character count
	 */
	public int countUniqueCharacters(String string){
		try{
			if(cacheResult.containsKey(string)){
				return cacheResult.get(string);
			}else{
				int countUnique = 0;
				for(int i = 0 ; i < string.length() ; i++){
					if(search(string.charAt(i), string) == 1){
							countUnique++;
					}
				}
				cacheResult.put(string, countUnique);
				return countUnique;
			}
		}catch(Exception e){
			throw new AssertionError("Exception In Searching");
		}
	}
	
	/**
	 * 
	 * @param c
	 * @param string
	 * @return
	 */
	private int search(char c, String string){
		int count = 0;
		for(int i = 0 ; i < string.length() ; i++){
			if(string.charAt(i) == c){
				count++;
			}
		}
		return count;
	}
}
