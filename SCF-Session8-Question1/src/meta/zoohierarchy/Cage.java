/**
 * This Class contains List Of Animals, capacity value and Animal Type
 * @author Abhishek Bishnoi
 */
package meta.zoohierarchy;

import java.util.ArrayList;
import java.util.List;

import meta.animalhierarchy.Animal;
import meta.data.AnimalType;


public class Cage {

	private AnimalType animalType; 
	//specifies the type of animal 
	private int capacity;
	List<Animal> listOfAnimals = new ArrayList<>();
	/**
	 * Constructor For Cage
	 * @param animalType
	 * @param capacity
	 */
	public Cage(AnimalType animalType, int capacity){
		this.animalType = animalType;
		this.capacity = capacity;
	}
	/**
	 * getter method
	 * @return Animal Type
	 */
	public AnimalType getAnimalType() {
		return animalType;
	}
	/**
	 * getter method for capacity 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * getter method of List<Animal> 
	 * @return A list of animal class
	 */
	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}
	/**
	 * 
	 */
	public int remainigCapacity(){
		return capacity - listOfAnimals.size();
	}
	/**
	 * 
	 * @param animal
	 */
	public void addAnimal(Animal animal){
		listOfAnimals.add(animal);
	}
	/**
	 * 
	 * @return return boolean value if animal is removed or not
	 */
	public boolean removeAnimal(){
		boolean removed = false;
		if(listOfAnimals.size() > 0){
			listOfAnimals.remove(0);
			removed = true;
		}
		return removed;
	}
}
