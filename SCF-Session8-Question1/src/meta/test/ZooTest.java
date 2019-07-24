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
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.utility.Zoo;


public class ZooTest {

	/**
	 * In this function we are checking about the creation of zone and adding them to zoo
	 * addZone() contains Animal category, capacity, hasPark and hasCanteen
	 */
	@Test
	public void addZonePaasTest(){
		Zoo zoo = new Zoo();
		assertTrue(zoo.addZone(AnimalCategory.MAMMAL, 3, true, true));
		assertTrue(zoo.addZone(AnimalCategory.BIRD, 5, false, true));
		assertTrue(zoo.addZone(AnimalCategory.REPTILE, 5, false, false));
		assertTrue(zoo.addZone(AnimalCategory.BIRD, 7, false, true));
	}
	/**
	 * Here we are adding a cage into a zone 
	 * addZone() contains Animal category, capacity, hasPark and hasCanteen
	 * and addCage contains Animal category, and capacity
	 */
	@Test
	public void addCagePassTest(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
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
		zoo.addZone(AnimalCategory.BIRD, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
	}
	/**
	 * In This Case we are trying to add cages into a zone more then its capacity 
	 * here we are expecting for Assertion Error
	 */
	@Test(expected = AssertionError.class)
	public void addCageFailTest1(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
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
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		assertTrue(zoo.addAnimal(new Lion(25, 12)));
	}

	/**
	 * in this test case we are adding different animal that doesn't allocated for the cage
	 * here we are expecting Assertion Error
	 */
	@Test(expected = AssertionError.class)
	public void addAnimalFailTest(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.ELEPHANT, 3);
		assertTrue(zoo.addAnimal(new Lion(25, 12)));
	}

	/**
	 * This Test Cases is about removing animal from a cage 
	 */
	@Test
	public void removeAnimal(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		zoo.addAnimal(new Lion(25, 12));
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
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		zoo.addAnimal(new Lion(25, 12));
		zoo.removeAnimal(AnimalType.ELEPHANT);
	}

}
