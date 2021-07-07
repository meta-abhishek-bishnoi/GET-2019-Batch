/**
 * This is child class Of Animal Class
 * @author Abhishek Bishnoi
 */
package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Bird extends Animal {
	private final boolean canFly; 
	// contains values if they can fly or not
	/**
	 * Constructor values comes from child object like Peacock, Cock etc. etc.
	 * @param name of animal
	 * @param weight of animal
	 * @param age of animal
	 * @param sound type of sound 
	 * @param numberOfLegs no of legs
	 * @param canFly boolean value if they can fly or not
	 * @param animalType animal type like lion, beer, deer etc etc
	 */
	public Bird(String name, String scientificName, String sound, int numberOfLegs, boolean canFly, AnimalType animalType){
		/**
		 * calling Constructor OF Animal Class
		 */
		super(name, scientificName, sound, numberOfLegs, AnimalCategory.BIRD, animalType);

		this.canFly = canFly;
	}
	/**
	 * getter method of canFly
	 * @return
	 */
	public boolean isCanFly() {
		return canFly;
	}	
	
}
