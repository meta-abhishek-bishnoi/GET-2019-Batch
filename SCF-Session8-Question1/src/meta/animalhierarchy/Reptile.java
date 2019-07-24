 /**
 * This is child class Of Animal Class
 * @author Abhishek Bishnoi
 */
package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Reptile extends Animal {
	private final boolean containsPoision;
	// this variable contains about Poision in animal
	/**
	 * Constructor Values come from child class like Snake, Turtle etc etc
	 * @param name of animal
	 * @param weight of animal
	 * @param age of animal
	 * @param sound of animal
	 * @param numberOfLegs of animal
	 * @param containsPoision 
	 * @param animlType of animal
	 */
	public Reptile(String name, String scientificName, double weight, double age, String sound,
			int numberOfLegs, boolean containsPoision, AnimalType animlType){
		/**
		 * calling Parent's{Animal} Constructor
		 */
		super(name, scientificName, weight, age, sound, numberOfLegs, AnimalCategory.REPTILE, animlType);

		this.containsPoision = containsPoision;
	}
	/**
	 * getter function
	 * @return is Contains Poision
	 */
	public boolean isContainsPoision() {
		return containsPoision;
	}

}
