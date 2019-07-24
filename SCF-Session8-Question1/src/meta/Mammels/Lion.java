/**
 * this class is for any specified Animal Type : 
 * means this is for Lion where it contains some fix values or facts about that animal 
 * @author Abhishek Bishnoi
 */
package meta.Mammels;

import meta.animalhierarchy.Mammals;
import meta.data.AnimalType;
import meta.data.Sound;

public class Lion extends Mammals{
	private static int id=1;
	private static int legs = 4;
	private static String name = "lion";
	private static String scientificName = "Cercopithecidae";
	private static boolean hasFur=true;
	/**
	 * Constructor Calling from driver function
	 * @param weight of animal
	 * @param age of animal
	 */
	public Lion(double weight, double age) {
		/**
		 * calling Parent's{Mammals} constructor
		 */
		super( ( name+" -"+(id++) ), scientificName, weight, age, Sound.getSound(name), legs, AnimalType.LION, hasFur );
	}
}
