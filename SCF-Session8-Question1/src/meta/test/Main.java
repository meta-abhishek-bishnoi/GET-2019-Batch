/**
* Only to check success of opeartions, not in specification
* @author Abhishek Bishnoi
*/
package meta.test;

import java.util.List;

import meta.Mammels.Deer;
import meta.animalhierarchy.Animal;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.utility.Zoo;
import meta.zoohierarchy.Cage;
import meta.zoohierarchy.Zone;

public class Main {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		System.out.println("Adding Zone ..");
		int capacity = 5; 
		AnimalCategory category = AnimalCategory.MAMMAL;
		boolean hasPark = true;
		boolean hasCanteen = false;
		zoo.addZone(category, capacity, hasPark, hasCanteen);
		category = AnimalCategory.BIRD;
		hasCanteen = true;
		zoo.addZone(category, capacity, hasPark, hasCanteen);
		System.out.println("Adding Cages for "+AnimalType.DEER);
		zoo.addCage(AnimalType.DEER, 5);
		zoo.addCage(AnimalType.ELEPHANT, 1);
		double weight = 55;
		double age = 2.5;
		Animal animal = new Deer(weight,age);
		zoo.addAnimal(animal);
		weight = 60;
		age = 3;
		animal = new Deer(weight, age);
		zoo.addAnimal(animal);
		List<Zone> zones = zoo.getZones();
		for(Zone zone: zones){
			if(zone.getListOfCages().size()>0){
				for(Cage cage : zone.getListOfCages()){
					if(cage.getListOfAnimals().size()>0){
						int i =1 ;
						for(Animal current : cage.getListOfAnimals()){
							System.out.println(i+". Name: "+current.getName()+", Scientific Name: "+current.getScientificName()+", Age:"+current.getAge());
							System.out.println(" Weight: "+current.getWeight()+", No Of legs: "+current.getNumberOfLegs());
						}
					}
				}
			}
		}
		
	}
}
