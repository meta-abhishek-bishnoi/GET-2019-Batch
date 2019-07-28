/**
 * This is base class for all type(class) animals
 * This class contains all common variable & respectively getter and setter method
 * @author Abhishek Bishnoi
 * @version 1.0
 * @since 23-july-2019
 */
package meta.animalhierarchy;

import meta.data.AnimalCategory;
import meta.data.AnimalType;

public class Animal {
	private final String name;
	private final String scientificName;
	private double weight;
	private double age;
	private final String sound;
	private final int numberOfLegs;
	private final AnimalCategory category;
	private final AnimalType animalType;
	/**
	 * This is constructor values comes from child class
	 * @param name name of animal 
	 * @param weight weight of animal 
	 * @param age age of animal 
	 * @param sound sound type
	 * @param numberOfLegs no of legs
	 * @param category Animal Category like mammals, reptile etc etc
	 * @param animalType animal type like lion, beer, deer etc etc
	 */
	public Animal(String name, String scientificName, String sound, int numberOfLegs, AnimalCategory category,
			AnimalType animalType) {
		super();
		this.name = name;
		this.scientificName = scientificName;
		this.sound = sound;
		this.numberOfLegs = numberOfLegs;
		this.category = category;
		this.animalType = animalType;
	}
	/**
	 * getter function
	 * @return weight of animal
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 *  setter function
	 * @param weight set weight of animal
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * getter method
	 * @return age of animal
	 */
	public double getAge() {
		return age;
	}
	/**
	 * setter method of age
	 * @param age set age
	 */
	public void setAge(double age) {
		this.age = age;
	}
	/**
	 * getter method
	 * @return name of animal
	 */
	public String getName() {
		return name;
	}
	/**
	 * getyter method
	 * @return sound pf animal
	 */
	public String getSound() {
		return sound;
	}
	/**
	 * getter method
	 * @return no of legs of animal
	 */
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	/**
	 * getter method
	 * @return category of animal
	 */
	public AnimalCategory getCategory() {
		return category;
	}
	/**
	 * getter method
	 * @return getter method of animal
	 */
	public AnimalType getAnimalType() {
		return animalType;
	}
	/**
	 * getter method 
	 * @return scientific name
	 */
	public String getScientificName() {
		return scientificName;
	}
	
}
