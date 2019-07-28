/**
 * This Class contains all test cases for creating zone, cage and animal, adding and removing them
 * @author Abhishek Bishnoi
 * @since 24-July-2019
 * @version 1.0
 */
package meta.test;

import static org.junit.Assert.*;

import org.junit.Test;

import meta.Mammels.Lion;
import meta.animalhierarchy.Animal;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.utility.FactoryMethod;
import meta.utility.Zoo;
import meta.zoohierarchy.Zone;


public class ZooTest {

	/**
	 * In this function we are checking about the creation of zone and adding them to zoo
	 * addZone() contains Zone where Zone is created using factory method
	 * and we set values like hasCanteen, hasPark etc etc using setter method
	 */
	@Test
	public void addZonePaasTest(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(3);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		assertTrue(zoo.addZone(zone));
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.BIRD);
		zone.setCapacity(10);
		zone.setHasCanteen(false);
		zone.setHasCanteen(true);
		assertTrue(zoo.addZone(zone));
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.REPTILE);
		zone.setCapacity(17);
		zone.setHasCanteen(false);
		zone.setHasCanteen(false);
		assertTrue(zoo.addZone(zone));
	}
	/**
	 * Here we are adding a cage into a zone 
	 * addZone() contains Animal category, capacity, hasPark and hasCanteen
	 * and addCage contains Animal category, and capacity
	 */
	@Test
	public void addCagePassTest(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(5);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		assertTrue(zoo.addCage(AnimalType.LION, 2));
		assertTrue(zoo.addCage(AnimalType.DEER, 5));
	}

	/**
	 * This is fail test cases here we are adding different type animal in other clas type
	 * so this will throw Assertion Error 
	 */
	@Test(expected = AssertionError.class)
	public void addCageFailTest0(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.BIRD);
		zone.setCapacity(15);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		zoo.addCage(AnimalType.LION, 3);
	}
	/**
	 * In This Case we are trying to add cages into a zone more then its capacity 
	 * here we are expecting for Assertion Error
	 */
	@Test(expected = AssertionError.class)
	public void addCageFailTest1(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(2);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		zoo.addCage(AnimalType.LION, 1);
		zoo.addCage(AnimalType.DEER, 5);
		zoo.addCage(AnimalType.ELEPHANT, 3); 
	}

	/**
	 * In This test case we are adding an animal to a cage
	 */
	@Test
	public void addAnimalTest(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(5);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		zoo.addCage(AnimalType.LION, 3);
		Animal animal = FactoryMethod.factoryMethod_Animal(AnimalType.LION);
		animal.setAge(10);
		animal.setWeight(254);
		assertTrue(zoo.addAnimal(animal));
	}

	/**
	 * in this test case we are adding different animal that doesn't allocated for the cage
	 * here we are expecting Assertion Error
	 */
	@Test(expected = AssertionError.class)
	public void addAnimalFailTest(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(2);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		zoo.addCage(AnimalType.ELEPHANT, 3);
		Animal animal = FactoryMethod.factoryMethod_Animal(AnimalType.DEER);
		animal.setAge(10);
		animal.setWeight(79.500);
		assertTrue(zoo.addAnimal(animal));
	}

	/**
	 * This Test Cases is about removing animal from a cage 
	 */
	@Test
	public void removeAnimal(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(5);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		zoo.addCage(AnimalType.LION, 3);
		Animal animal = FactoryMethod.factoryMethod_Animal(AnimalType.LION);
		animal.setAge(10);
		animal.setWeight(254);
		zoo.addAnimal(animal);
		assertTrue(zoo.removeAnimal(AnimalType.LION));
	}

	/**
	 * this is fail test case to removing from cage 
	 * here we are removing a animal which is not present in cage
	 * Expected Assertion Error 
	 */
	@Test(expected = AssertionError.class)
	public void removeAnimalFailTest(){
		Zoo zoo = new Zoo();
		Zone zone;
		zone = FactoryMethod.factoryMethod_Zone(AnimalCategory.MAMMAL);
		zone.setCapacity(5);
		zone.setHasCanteen(true);
		zone.setHasPark(true);
		zoo.addZone(zone);
		zoo.addCage(AnimalType.LION, 3);
		Animal animal = FactoryMethod.factoryMethod_Animal(AnimalType.LION);
		animal.setAge(10);
		animal.setWeight(254);
		zoo.addAnimal(animal);
		zoo.removeAnimal(AnimalType.ELEPHANT);
	}

}
