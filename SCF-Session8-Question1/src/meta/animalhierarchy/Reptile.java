package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Reptile extends Animal {
	private final boolean containsPoision;
	/**
	 * 
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param containsPoision
	 * @param animlType
	 */
	public Reptile(String name, double weight, int age, String sound,
			int numberOfLegs, boolean containsPoision, AnimalType animlType){

		super(name, weight, age, sound, numberOfLegs, AnimalCategory.REPTILE, animlType);

		this.containsPoision = containsPoision;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isContainsPoision() {
		return containsPoision;
	}

}
