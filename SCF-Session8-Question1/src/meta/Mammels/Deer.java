/**
 * this class is for any specified Animal Type : 
 * means this is for Deer where it contains some fix values or facts about that animal 
 * @author Abhishek Bishnoi
 */
package meta.Mammels;

import meta.animalhierarchy.Mammals;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.data.Sound;

public class Deer extends Mammals {

	private static int id=1;
	private static int legs = 4;
	private static String name = "deer";
	private static  String scientificName = "Cervidae";
	private static boolean hasFur=false;
	/**
	 * Constructor Calling from driver function
	 * @param weight of animal
	 * @param age of animal
	 */
	public Deer() {
		/**
		 * calling Parent's{Mammals} constructor
		 */
		super( ( name+" -"+(id++) ), scientificName, Sound.getSound(name), legs, AnimalType.DEER, hasFur );
	}
}
