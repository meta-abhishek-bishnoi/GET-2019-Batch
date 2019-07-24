package meta.Mammels;

import meta.animalhierarchy.Mammals;
import meta.data.AnimalType;
import meta.data.Sound;

public class Dog extends Mammals{
	private static int id=1;
	private static int legs = 4;
	private static String name = "dog";
	private static boolean hasFur=true;
	/**
	 * 
	 * @param weight
	 * @param age
	 */
	public Dog(double weight, int age) {
		/**
		 * 
		 */
		super( ( name+" -"+(id++) ), weight, age, Sound.getSound(name), legs, AnimalType.DOG, hasFur );
	}
}
