/**
 * this class is for any specified Animal Type : 
 * means this is for Dog where it contains some fix values or facts about that animal 
 * @author Abhishek Bishnoi
 */
package meta.Mammels;

import meta.animalhierarchy.Mammals;
import meta.data.AnimalType;
import meta.data.Sound;

public class Dog extends Mammals{
	private static int id=1;
	private static int legs = 4;
	private static String name = "dog";
	private static  String scientificName = "Canis lupus familiaris";
	private static boolean hasFur=true;
	/**
	 * Constructor Calling from driver function
	 * @param weight of animal
	 * @param age of animal
	 */
	public Dog() {
		/**
		 * calling Parent's{Mammals} constructor
		 */
		super( ( name+" -"+(id++) ), scientificName, Sound.getSound(name), legs, AnimalType.DOG, hasFur );
	}
}
