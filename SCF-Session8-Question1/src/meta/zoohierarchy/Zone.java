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
	/*
	 * 
	 */
	public Zone(AnimalCategory zoneAnimalType, int capacity, boolean hasPark, boolean hasCanteen) {
		super();
		this.zoneAnimalType = zoneAnimalType;
		this.capacity = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}
	/**
	 * 
	 * @return
	 */
	public AnimalCategory getZoneAnimalType() {
		return zoneAnimalType;
	}
	/**
	 * 
	 * @param zoneAnimalType
	 */
	public void setZoneAnimalType(AnimalCategory zoneAnimalType) {
		this.zoneAnimalType = zoneAnimalType;
	}
	/**
	 * 
	 * @return
	 */
	public List<Cage> getListOfCages() {
		return listOfCages;
	}
	/**
	 * 
	 * @param listOfCages
	 */
	public void setListOfCages(List<Cage> listOfCages) {
		this.listOfCages = listOfCages;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isHasPark() {
		return hasPark;
	}
	/**
	 * 
	 * @param hasPark
	 */
	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	/**
	 * 
	 * @param hasCanteen
	 */
	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
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
	 * @return
	 */
	public int remainingCapicity(){
		return capacity-listOfCages.size();
	}
	/**
	 * 
	 * @param cage
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
	 * @param animal
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
	 * 
	 * @param animal
	 * @return
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
