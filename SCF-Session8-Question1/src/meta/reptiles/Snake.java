package meta.reptiles;

import meta.animalhierarchy.Reptile;
import meta.data.AnimalType;
import meta.data.Sound;

public class Snake extends Reptile{
	static int id=1;
	private static int legs = 0;
	private static String name = "snake";
	private static boolean containsPoision = true;
	
	public Snake(double weight, int age){
		super( ( name+" -"+(id++) ), weight, age, Sound.getSound(name), legs, containsPoision, AnimalType.SNAKE);
	}

}
