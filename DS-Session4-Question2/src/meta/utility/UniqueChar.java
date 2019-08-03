package meta.utility;

import java.util.HashMap;
import java.util.Map;

public class UniqueChar {
	Map<String, Integer> cacheResult = new HashMap<String, Integer>();
	/**
	 * 
	 * @param string
	 * @return
	 */
	public int countUniqueCharacters(String string){
		try{
			if(cacheResult.containsKey(string)){
				//System.out.println("Yahoo");
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
