package meta.hierarchy;

import java.util.HashMap;
import java.util.Map;

public class CollectionAnimals {
	private static boolean flag = true;
	private static Map<String,String> categoryAnimals = new HashMap<>();
	private static Map<String,String> categoryFood = new HashMap<>();
	private static Map<String,String> categorySound = new HashMap<>();
	private static void initial(){
		categoryAnimals.put("lion", "mammels");
		categoryFood.put("lion","nonveg");
		categorySound.put("lion","roar");
		flag = false;
	}
	public static String getAnimalClassName(String animalName){
		if (flag==true){
			initial();
		}
		return categoryAnimals.get(animalName);
	}
	public static String getAnimalFod(String animalName){
		if (flag==true){
			initial();
		}
		return categoryFood.get(animalName);
	}
	public static String getSound(String animalName){
		if (flag==true){
			initial();
		}
		return categorySound.get(animalName);
	}
}
