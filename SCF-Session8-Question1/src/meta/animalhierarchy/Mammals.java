 /**
 * This is child class Of Animal Class
 * @author Abhishek Bishnoi
 */
package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Mammals extends Animal {

	private final boolean hasFur;
	// this variable contains if they had fur or not
	/**
	 * Constructor Values come from child class like Dog, Deer etc etc
	 * @param name of animal
	 * @param weight of animal
	 * @param age of animal
	 * @param sound 
	 * @param numberOfLegs
	 * @param category
	 * @param animalType
	 * @param hasFur
	 */
	public Mammals(String name, String scientificName, double weight, double age, String sound, int numberOfLegs, 
			AnimalType animalType, boolean hasFur) {
		/**
		 * calling Parent's{Animal} Constructor
		 */
		super(name, scientificName, weight, age, sound, numberOfLegs, AnimalCategory.MAMMAL, animalType);
		this.hasFur = hasFur;
	}
	/**
	 * 
	 * @return has Fur Or Not
	 */
	public boolean hasFur() {
		return hasFur;
	}
}
