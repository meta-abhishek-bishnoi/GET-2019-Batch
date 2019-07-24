package meta.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sound {
	/**
	 * data collected from 
	 * https://www.myenglishpages.com/site_php_files/vocabulary-lesson-sounds-animals.php
	 */
	private static Map<String, String> sound = new LinkedHashMap<>();
	private static boolean flag = true;
	private static void initialMap(){
		sound.put("lion","roar");
		sound.put("deer", "bell");
		sound.put("elephent", "trumpet");
		sound.put("dog", "bark");
		sound.put("cock", "crow");
		sound.put("eagle", "scream");
		sound.put("snake", "buzzing ");
		//https://www.quora.com/What-sounds-do-snakes-make for snake sound
	}
	public static String getSound(String animalName){
		if(flag==true){
			initialMap();
			flag = false;
		}
		if(sound.containsKey(animalName)){
			return sound.get(animalName);
		}
		return "No Sound Found";
	}
}
