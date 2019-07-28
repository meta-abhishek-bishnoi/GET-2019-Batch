/**
 * This is Factory Method Class to create Factory Methods
 * @author Abhishek Bishnoi
 */
package meta.utility;

import meta.Mammels.Deer;
import meta.Mammels.Dog;
import meta.Mammels.Elephant;
import meta.Mammels.Lion;
import meta.animalhierarchy.Animal;
import meta.birds.Cock;
import meta.birds.Peacock;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.reptiles.Snake;
import meta.reptiles.Turtle;
import meta.zoohierarchy.BirdZone;
import meta.zoohierarchy.MammalZone;
import meta.zoohierarchy.ReptileZone;
import meta.zoohierarchy.Zone;

public class FactoryMethod {
	/**
	 * This Is factory method which Returns Factory Object
	 * @param type Animal Type 
	 * @return Factory Object Of Animal
	 */
	public static Animal factoryMethod_Animal(AnimalType type){
		Animal returnObject ;
		switch(type){
		case COCK : 
			returnObject = new Cock();
			break;
		case DEER :
			returnObject = new Deer();
			break;
		case DOG :
			returnObject = new Dog();
			break;
		case ELEPHANT : 
			returnObject = new Elephant();
			break;
		case LION :
			returnObject = new Lion();
			break;
		case PEACOCK : 
			returnObject = new Peacock();
			break;
		case SNAKE :
			returnObject = new Snake();
			break;
		case TURTLE : 
			returnObject = new Turtle();
			break;
		default:
			throw new AssertionError("Enter A Valid Animal");
		}
		
		return returnObject;
	}
	/**
	 * 
	 * @param category of Animals 
	 * @return Factory Object Of Zone
	 */
	public static Zone  factoryMethod_Zone(AnimalCategory category){
		Zone zoneObject;
		switch(category){
		case BIRD:
			zoneObject = new BirdZone();
			break;
		case MAMMAL:
			zoneObject = new MammalZone();
			break;
		case REPTILE:
			zoneObject = new ReptileZone();
			break;
		default:
			throw new AssertionError("Enter A Valid Zone Category");
		}
		return zoneObject;
	}
}
