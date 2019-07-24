package meta.test;

import java.util.Scanner;

import meta.Mammels.Elephant;
import meta.Mammels.Lion;
import meta.animalhierarchy.Animal;
import meta.birds.Peacock;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.reptiles.Snake;
import meta.zoohierarchy.Zoo;

public class Main {
	public static void main(String[] args){
		Zoo zoo = new Zoo(); 
		int choice;
		do{
			System.out.println("MENU!!!!");
			System.out.println("1. Add Zone to the Zoo");
			System.out.println("2. Add Cage to the Zone");
			System.out.println("3. Add Animal to cage");
			System.out.println("4. Remove animal from cage");
			System.out.println("5. Exit");
			System.out.println("Enter your choice..");
			Scanner scanner = new Scanner(System.in);
			while(!scanner.hasNextInt()){
				System.out.println("Please enter integer value");
				scanner.next();
			}
			choice = scanner.nextInt();
			switch (choice){ 
			case 1: 
				AnimalCategory zoneType = chooseZone(scanner);
				System.out.println("Please enter the capacity");
				int capacity = scanner.nextInt();
				System.out.println("Does the zone has a park? (Enter true or false)");
				boolean hasPark = scanner.nextBoolean();
				System.out.println("Does the zone has a canteen? (Enter true or false)");
				boolean hasCanteen = scanner.nextBoolean();
				zoo.addZone(zoneType, capacity, hasPark, hasCanteen);
				break;

			case 2: 
				AnimalType cageType = chooseCage(scanner);
				System.out.println("Enter the capacity of the cage");
				int capacityOfCage = scanner.nextInt();
				if(zoo.addCage(cageType, capacityOfCage))
				{
					System.out.println("Cage is successfully added");
				}
				break;

			case 3: 
				AnimalType animalType = chooseCage(scanner);
				Animal animal = addNewAnimal(scanner, animalType);
				if(zoo.addAnimal(animal))
					System.out.println("Animal added successfully");
				break;

			case 4: 
				AnimalType animalType1 = chooseCage(scanner);
				if(zoo.removeAnimal(animalType1))
					System.out.println("Remove successfully");
				break;

			case 5: 
				break;

			default:
				System.out.println("Wrong input! Try again!");
			}
		}while(choice != 5);
	}

	private static Animal addNewAnimal(Scanner sc, AnimalType animalType){
		Animal animal = null;
		double weight;
		int age;
		double wingSpan;
		switch(animalType){
		case ELEPHANT: 
			System.out.println("Enter the weight and age of elephant");
			weight = sc.nextDouble();
			age = sc.nextInt();
			animal = new Elephant(weight, age);
			break;

		case LION: 
			System.out.println("Enter the weight and age of Lion");
			weight = sc.nextDouble();
			age = sc.nextInt();
			animal = new Lion(weight, age);
			break;

		case PEACOCK:
			System.out.println("Enter the weight");
			weight = sc.nextDouble();
			age = sc.nextInt();
			wingSpan = sc.nextDouble();
			animal = new Peacock(weight, age);
			break;

		case SNAKE: 
			System.out.println("Enter the weight and age of snake");
			weight = sc.nextDouble();
			age = sc.nextInt();
			animal = new Snake(weight, age);
			break;
		}
		return animal;
	}

	private static AnimalType chooseCage(Scanner sc){
		AnimalType cageType = null;
		System.out.println("List of Cage Types");
		System.out.println("1. Lion");
		System.out.println("2. Elephant");
		System.out.println("3. Peacock");
		System.out.println("4. Snake");
		System.out.println("Choose from the cage types..");

		int cage = sc.nextInt();
		
		switch(cage){
		case 1: 
			cageType = AnimalType.LION;
			break;
		case 2: 
			cageType = AnimalType.ELEPHANT;
			break;
		case 3: 
			cageType = AnimalType.PEACOCK;
			break;
		case 4: 
			cageType = AnimalType.SNAKE;
			break;
		default:
			System.out.println("No result found!!");
			break;	
		}
		return cageType;
	}

	private static AnimalCategory chooseZone(Scanner sc){

		AnimalCategory zoneType = null;
		System.out.println("List of Zones");
		System.out.println("1. Bird");
		System.out.println("2. Mammal");
		System.out.println("3. Reptile");
		System.out.println("Choose from the zone types..");

		int zone = sc.nextInt();

		switch (zone){
		case 1:
			zoneType = AnimalCategory.BIRD;
			break;
		case 2:
			zoneType = AnimalCategory.MAMMAL;
			break;
		case 3:
			zoneType = AnimalCategory.REPTILE;
			break;
		default:
			System.out.println("No result found!!");
			break;
		}
		return zoneType;
	}
}
