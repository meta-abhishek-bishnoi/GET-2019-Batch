/*
 * 
 */
package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Animal {
	private final String name;
	private double weight;
	private int age;
	private final String sound;
	private final int numberOfLegs;
	private final AnimalCategory category;
	private final AnimalType animalType;
	/**
	 * 
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param category
	 * @param animalType
	 */
	public Animal(String name, double weight, int age, String sound, int numberOfLegs, AnimalCategory category,
			AnimalType animalType) {
		super();
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.sound = sound;
		this.numberOfLegs = numberOfLegs;
		this.category = category;
		this.animalType = animalType;
	}
	/**
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return
	 */
	public String getSound() {
		return sound;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	/**
	 * 
	 * @return
	 */
	public AnimalCategory getCategory() {
		return category;
	}
	/**
	 * 
	 * @return
	 */
	public AnimalType getAnimalType() {
		return animalType;
	}
	
}
