package meta.test;

import meta.hierarchy.CollectionAnimals;
import meta.hierarchy.Lion;

public class Main {
 public static void main(String[] args) {
	String animal = "lion";
	Lion lion = new Lion(animal,2.5,150,CollectionAnimals.getAnimalFod(animal),CollectionAnimals.getAnimalClassName(animal),CollectionAnimals.getSound(animal));
	System.out.println(lion.getName()+" is "+lion.getAge()+" years old can "+lion.getSound() );
 }
}
