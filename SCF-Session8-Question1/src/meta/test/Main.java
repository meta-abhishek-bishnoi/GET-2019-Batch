package meta.test;

import java.util.List;

import meta.Mammels.Deer;
import meta.Mammels.Elephant;
import meta.animalhierarchy.Animal;
import meta.animalhierarchy.Bird;
import meta.birds.Peacock;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.reptiles.Snake;
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
		// adding zone
		zoo.addZone(category, capacity, hasPark, hasCanteen);
		category = AnimalCategory.BIRD;
		hasCanteen = true;
		zoo.addZone(category, capacity, hasPark, hasCanteen);
		System.out.println("Adding Cages for "+AnimalType.DEER);
		// adding cages
		zoo.addCage(AnimalType.DEER, 5);
		zoo.addCage(AnimalType.ELEPHANT, 1);
		// adding deer
		double weight = 55;
		double age = 2.5;
		Animal animal = new Deer(weight,age);
		zoo.addAnimal(animal);
		// adding deer
		weight = 60;
		age = 3;
		animal = new Deer(weight, age);
		zoo.addAnimal(animal);
		// adding elephant
		weight = 260;
		age = 4.5;
		animal = new Elephant(weight, age);
		zoo.addAnimal(animal);
		printAllAnimals(zoo);
		
		
	}
	public static void printAllAnimals(Zoo zoo){
		List<Zone> zones = zoo.getZones();
		int zoneId=1;
		for(Zone zone: zones){
			System.out.println("Zone Id - "+zoneId++);
			int cageId = 1;
			if(zone.getListOfCages().size()>0){
				System.out.println("Cage Id - "+cageId++);
				for(Cage cage : zone.getListOfCages()){
					if(cage.getListOfAnimals().size()>0){
						int i =1 ;
						for(Animal current : cage.getListOfAnimals()){
							System.out.print("Animal Id -"+(i++)+". Name: "+current.getName()+", Scientific Name: "+current.getScientificName()+", Age:"+current.getAge());
							System.out.print(" Weight: "+current.getWeight()+", No Of legs: "+current.getNumberOfLegs());
							System.out.println();
						}
					}
				}
			}
		}
	}
}
