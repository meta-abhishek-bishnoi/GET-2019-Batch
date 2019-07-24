package meta.reptiles;

import meta.animalhierarchy.Reptile;
import meta.data.AnimalType;
import meta.data.Sound;

public class Snake extends Reptile{
	static int id=1;
	private static int legs = 0;
	private static String name = "snake";
	private static String scientificName = "Serpentes";
	private static boolean containsPoision = true;
	/**
	 * Constructor Calling from driver function
	 * @param weight of animal
	 * @param age of animal
	 */
	public Snake(double weight, double age){
		/**
		 * calling Parent's{Reptile} constructor
		 */
		super( ( name+" -"+(id++) ), scientificName, weight, age, Sound.getSound(name), legs, containsPoision, AnimalType.SNAKE);
	}

}
