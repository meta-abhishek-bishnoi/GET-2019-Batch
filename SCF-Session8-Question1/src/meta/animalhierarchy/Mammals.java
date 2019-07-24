/**
 * 
 */
package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Mammals extends Animal {

	private final boolean hasFur;
	/**
	 * 
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param category
	 * @param animalType
	 * @param hasFur
	 */
	public Mammals(String name, double weight, int age, String sound, int numberOfLegs, 
			AnimalType animalType, boolean hasFur) {
		/**
		 * 
		 */
		super(name, weight, age, sound, numberOfLegs, AnimalCategory.MAMMAL, animalType);
		this.hasFur = hasFur;
	}
	/**
	 * 
	 * @return
	 */
	public boolean hasFur() {
		return hasFur;
	}
}
