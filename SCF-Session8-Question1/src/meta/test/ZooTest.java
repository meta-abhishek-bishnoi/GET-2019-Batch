package meta.test;

import static org.junit.Assert.*;
import org.junit.Test;

import meta.Mammels.Lion;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.zoohierarchy.Zoo;





public class ZooTest {

	@Test
	public void addZone_HappyFlow(){
		Zoo zoo = new Zoo();
		assertTrue(zoo.addZone(AnimalCategory.MAMMAL, 2, true, true));
		assertTrue(zoo.addZone(AnimalCategory.BIRD, 2, false, true));
		assertTrue(zoo.addZone(AnimalCategory.REPTILE, 2, false, false));
		assertTrue(zoo.addZone(AnimalCategory.BIRD, 2, false, true));
	}
	@Test
	public void addCage_HappyFlow(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		assertTrue(zoo.addCage(AnimalType.LION, 3));
	}

	@Test(expected = AssertionError.class)
	public void addCage_Exception_WhenAddingDifferentCageToDifferentZone(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.BIRD, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
	}

	@Test(expected = AssertionError.class)
	public void addCage_Exception_WhenAddingAnimalMoreThanTheCapacityOfZone(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		zoo.addCage(AnimalType.LION, 3);
		zoo.addCage(AnimalType.LION, 3); 
	}

	@Test
	public void addAnimal_HappyFlow(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		assertTrue(zoo.addAnimal(new Lion(25, 12)));
	}

	@Test(expected = AssertionError.class)
	public void addAnimal_Exception_WhenAddingDifferentAnimalToDifferentCage(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.ELEPHANT, 3);
		assertTrue(zoo.addAnimal(new Lion(25, 12)));
	}

	@Test
	public void removeAnimal_HappyFlow(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		zoo.addAnimal(new Lion(25, 12));
		assertTrue(zoo.removeAnimal(AnimalType.LION));
	}

	@Test(expected = AssertionError.class)
	public void removeAnimal_Exception_WhenRemovingAnimalWhichIsNotPresent(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
		zoo.addCage(AnimalType.LION, 3);
		zoo.addAnimal(new Lion(25, 12));
		zoo.removeAnimal(AnimalType.ELEPHANT);
	}

}
