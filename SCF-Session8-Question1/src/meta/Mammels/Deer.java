package meta.Mammels;

import meta.animalhierarchy.Mammals;
import meta.data.AnimalCategory;
import meta.data.AnimalType;
import meta.data.Sound;

public class Deer extends Mammals {

	private static int id=1;
	private static int legs = 4;
	private static String name = "deer";
	private static boolean hasFur=false;
	
	public Deer(double weight, int age) {
		super( ( name+" -"+(id++) ), weight, age, Sound.getSound(name), legs, AnimalType.DEER, hasFur );
	}
}
