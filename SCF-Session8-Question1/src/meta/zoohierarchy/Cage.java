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
	 * 
	 * @param animalType
	 * @param capacity
	 */
	public Cage(AnimalType animalType, int capacity){
		this.animalType = animalType;
		this.capacity = capacity;
	}
	/**
	 * 
	 * @return
	 */
	public AnimalType getAnimalType() {
		return animalType;
	}
	/**
	 * 
	 * @param animalType
	 */
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
	/**
	 * 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * 
	 * @return
	 */
	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}
	/**
	 * 
	 * @param listOfAnimals
	 */
	public void setListOfAnimals(List<Animal> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
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
	 * @return
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
