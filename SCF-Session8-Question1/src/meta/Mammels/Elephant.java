package meta.Mammels;

import meta.animalhierarchy.Mammals;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.data.Sound;

public class Elephant extends Mammals {

	private static int id=1;
	private static int legs = 4;
	private static String name = "elephent";
	private static boolean hasFur=false;
	
	public Elephant(double weight, int age) {
		super( ( name+" -"+(id++) ), weight, age, Sound.getSound(name), legs, AnimalType.ELEPHANT, hasFur );
	}
}
