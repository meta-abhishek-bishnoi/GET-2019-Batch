package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Bird extends Animal {
	private final boolean canFly;
	/**
	 * 
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param canFly
	 * @param flyHeight
	 * @param animalType
	 */
	public Bird(String name, double weight, int age, String sound,
			int numberOfLegs, boolean canFly, AnimalType animalType){

		super(name, weight, age, sound, numberOfLegs, AnimalCategory.BIRD, animalType);

		this.canFly = canFly;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isCanFly() {
		return canFly;
	}	
	
}
