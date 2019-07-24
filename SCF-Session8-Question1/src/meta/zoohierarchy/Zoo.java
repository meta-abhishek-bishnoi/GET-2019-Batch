package meta.zoohierarchy;

import java.util.ArrayList;
import java.util.List;

import meta.animalhierarchy.Animal;
import meta.data.AnimalCategory;
import meta.data.AnimalType;



public class Zoo {
	List<Zone> zones = new ArrayList<Zone>(); 

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
	public boolean addCage(AnimalType animal, int capacity){
		Cage cage = new Cage(animal, capacity);
		boolean flag = false;
		for(Zone zone: zones){
			if(zone.remainingCapicity() != 0){
				// check for a specific zone type and their animals
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
		if(!flag){
			throw new AssertionError("Add A Zone");
		}
		return flag;
	}
	
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
	
	public boolean removeAnimal(AnimalType animal){
		boolean flag = false;
		AnimalCategory category = null;
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
}
