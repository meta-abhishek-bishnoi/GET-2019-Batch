/**
 * This is Service Class For All Opeartion In Zoo
 * @author Abhishek Bishnoi
 * @version 1.0
 * @since 24-July-2019
 */
package meta.utility;

import java.util.ArrayList;
import java.util.List;

import meta.animalhierarchy.Animal;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.zoohierarchy.BirdZone;
import meta.zoohierarchy.Cage;
import meta.zoohierarchy.MammalZone;
import meta.zoohierarchy.ReptileZone;
import meta.zoohierarchy.Zone;



public class Zoo {
	List<Zone> zones = new ArrayList<Zone>(); 

	/**
	 * This Function add a zone into zoo class
	 * @param animalcategory Animal Category
	 * @param capacity capacity of Zone
	 * @param hasPark boolean value about has park
	 * @param hasCanteen boolean value about hasCanteen
	 * @return true if added sucessfully
	 */
	public boolean addZone(AnimalCategory animalcategory, int capacity, boolean hasPark, boolean hasCanteen){
		Zone zone = null;
		switch(animalcategory){
		case BIRD:	  
			zone = new BirdZone(capacity, hasPark, hasCanteen);
			break;
		case MAMMAL:  
			zone = new MammalZone(capacity, hasPark, hasCanteen);
			break;
		case REPTILE: 
			zone = new ReptileZone(capacity, hasPark, hasCanteen);
			break;	
		default:
			return false;
		}
		zones.add(zone);
		return true;
	}
	/**
	 * This Function perform operation of adding cage into zone
	 * @param animal
	 * @param capacity
	 * @return boolean value for operation success or failure
	 * @exception Assertion Exception is zone is not available
	 */
	public boolean addCage(AnimalType animal, int capacity){
		Cage cage = new Cage(animal, capacity);
		boolean flag = false;
		for(Zone zone: zones){
			// if capecity is not overflow
			if(zone.remainingCapicity() != 0){
				// check for a specific zone type and their animals so you can't add anu object to any animal type
				if(zone.getZoneAnimalType() == AnimalCategory.BIRD && ( animal.equals(AnimalType.PEACOCK) ) ){
					zone.addCage(cage);
					flag = true;
					break;
				}else if(zone.getZoneAnimalType() == AnimalCategory.MAMMAL && ( animal.equals(AnimalType.LION)
						|| animal.equals(AnimalType.DOG) || animal.equals(AnimalType.ELEPHANT) || 
						animal.equals(AnimalType.DEER)) ){
					zone.addCage(cage);
					flag = true;
					break;
				}else if(zone.getZoneAnimalType() == AnimalCategory.REPTILE && (animal.equals(AnimalType.SNAKE)) ){
					zone.addCage(cage);
					flag = true;
					break;
				}	
			}			
		}
		//throw an exception if no zone is available
		if(!flag){
			throw new AssertionError("Add A Zone");
		}
		return flag;
	}
	/**
	 * This function Add Animals to Cages
	 * @param animal
	 * @return boolean value of success or failure 
	 * @exception Assertion Exception when we are adding different animal in different cage 
	 */
	public boolean addAnimal(Animal animal){
		boolean flag = false;
		for(Zone zone: zones){
			if(zone.getZoneAnimalType().equals(animal.getCategory()) && zone.addAnimal(animal)){
				flag = true;
				break;
			}
		}

		if(!flag){
			throw new AssertionError("All zones are full!!You need to add a zone first!!");
		}
		return flag;
	}
	/**
	 * this function perform removing opertion of Animals from Cages when they died
	 * @param animal
	 * @return boolean value about their failure or success
	 */
	public boolean removeAnimal(AnimalType animal){
		boolean flag = false;
		AnimalCategory category = null;
		// assigning Animal Category
		switch(animal){
		case ELEPHANT:
			category = AnimalCategory.MAMMAL;
			break;
		case LION:
			category = AnimalCategory.MAMMAL;
			break;
		case PEACOCK:
			category = AnimalCategory.BIRD;
			break;
		case SNAKE:
			category = AnimalCategory.REPTILE;
			break;
		case DOG: 
			category = AnimalCategory.MAMMAL;
			break;
		case DEER:
			category = AnimalCategory.MAMMAL;
			break;
		}
		// performing removing opeartion
		for(Zone zone: zones){
			if(zone.getZoneAnimalType().equals(category) && zone.removeAnimal(animal)){
				flag = true;
				break;
			}
		}
		if(!flag){
			throw new AssertionError("Animal not found!");
		}
		return flag;
	}
	/**
	 * getter method
	 * @return
	 */
	public List<Zone> getZones() {
		return zones;
	}
	
}
