/**
 * This Class contains Methods For Adding Cage and mainitaing Cages in list
 * @author Abhishek Bishnoi
 */
package meta.zoohierarchy;

import java.util.ArrayList;
import java.util.List;

import meta.animalhierarchy.Animal;
import meta.data.AnimalCategory;
import meta.data.AnimalType;


public class Zone {

	private AnimalCategory zoneAnimalType; 
	private final int capacity;
	private List<Cage> listOfCages = new ArrayList<>();
	private boolean hasPark, hasCanteen;
	/**
	 * Constructor of Zone 
	 * @param zoneAnimalType type of animal class
	 * @param capacity capicity of cages
	 * @param hasPark has park or not
	 * @param hasCanteen has canteen or not
	 */
	public Zone(AnimalCategory zoneAnimalType, int capacity, boolean hasPark, boolean hasCanteen) {
		super();
		this.zoneAnimalType = zoneAnimalType;
		this.capacity = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}
	/**
	 * setter method for category of animals
	 * @return
	 */
	public AnimalCategory getZoneAnimalType() {
		return zoneAnimalType;
	}
	/**
	 * setter method
	 * @param zoneAnimalType
	 */
	public void setZoneAnimalType(AnimalCategory zoneAnimalType) {
		this.zoneAnimalType = zoneAnimalType;
	}
	/**
	 *  getter method
	 * @return List of Cages
	 */
	public List<Cage> getListOfCages() {
		return listOfCages;
	}
	/**
	 * setter method
	 * @param listOfCages
	 */
	public void setListOfCages(List<Cage> listOfCages) {
		this.listOfCages = listOfCages;
	}
	/**
	 * getter method
	 * @return
	 */
	public boolean isHasPark() {
		return hasPark;
	}
	/**
	 * setter method
	 * @param hasPark
	 */
	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}
	/**
	 * getter method
	 * @return
	 */
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	/**
	 * setter method
	 * @param hasCanteen
	 */
	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}
	/**
	 * getter method
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * setter method
	 * @return
	 */
	public int remainingCapicity(){
		return capacity-listOfCages.size();
	}
	/**
	 * Adding A Cage into Zone
	 * @param cage Object Of cage
	 */
	public void addCage(Cage cage){
		if(remainingCapicity() != 0){
			listOfCages.add(cage);
		}else{
			throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
		}
	}
	/**
	 * Adding animal into cages
	 * @param animal Object Of Animal
	 * @return
	 */
	public boolean addAnimal(Animal animal){
		boolean flag = false;
		for(Cage cage: listOfCages){
			if(cage.getAnimalType().equals(animal.getAnimalType()) && cage.remainigCapacity() != 0){
				flag = true;
				cage.addAnimal(animal);
				break;
			}	
		}
		if(!flag){
			throw new AssertionError("Capacity of the zone is full! Cannot add animal!");
		}
		return flag;
	}
	/**
	 * removing animal from cages list
	 * @param animal Object Of animal
	 * @return boolean value
	 */
	public boolean removeAnimal(AnimalType animal){
		boolean removed = false;
		for(Cage cage: listOfCages){
			if(cage.getAnimalType().equals(animal)){
				removed = cage.removeAnimal();
			}
		}
		return removed;
	}
}
