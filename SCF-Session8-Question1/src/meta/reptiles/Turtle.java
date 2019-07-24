package meta.reptiles;

import meta.animalhierarchy.Reptile;
import meta.data.AnimalType;
import meta.data.Sound;

public class Turtle extends Reptile{

	static int id=1;
	private static int legs = 4;
	private static String name = "turtle";
	private static String scientificName = "Testudines";
	private static boolean containsPoision = false;
	
	public Turtle(double weight, double age){
		super( ( name+" -"+(id++) ), scientificName, weight, age, Sound.getSound(name), legs, containsPoision, AnimalType.SNAKE);
	}
}
