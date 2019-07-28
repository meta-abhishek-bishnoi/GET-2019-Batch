/**
 * This class is for any specified Animal Type : 
 * means this is for Cocks where it contains some fix values or facts about that animal 
 * @author Abhishek Bishnoi
 */
package meta.birds;

import meta.animalhierarchy.Bird;
import meta.data.AnimalType;
import meta.data.Sound;

public class Cock extends Bird {
	private static int id=1;
	private static String name = "cock";
	private static String scientificName = "Chicken ";
	private static boolean canFly = false;
	private static int legs = 2;
	/**
	 * Constructor of Cock Object
	 * @param weight input from user
	 * @param age input from user
	 */
	public Cock() {
		/**
		 * Calling COnstructor of Bird Class
		 */
		super( ( name+" -"+(id++) ), scientificName, Sound.getSound(name), legs, canFly, AnimalType.COCK);
	}
}
