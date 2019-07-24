/**
 * This class is for any specified Animal Type : 
 * means this is for Peacocks where it contains some fix values or facts about that animal 
 * @author Abhishek Bishnoi
 */
package meta.birds;

import meta.animalhierarchy.Bird;
import meta.data.AnimalType;
import meta.data.Sound;

public class Peacock extends Bird {
	private static int id=1;
	private static String name = "peacock";
	private static String scientificName = "Pavo cristatus";
	private static boolean canFly = true;
	private static int legs = 2;
	/**
	 * Constructor of Cock Object
	 * @param weight input from user
	 * @param age input from user
	 */
	public Peacock(double weight, double age) {
		/**
		 * Calling COnstructor of Bird Class
		 */
		super( ( name+" -"+(id++) ), scientificName, weight, age, Sound.getSound(name), legs, canFly, AnimalType.PEACOCK);
	}
}
