package meta.birds;

import meta.animalhierarchy.Bird;
import meta.data.AnimalType;
import meta.data.Sound;

public class Peacock extends Bird {
	private static int id=1;
	private static String name = "peacock";
	private static boolean canFly = true;
	private static int legs = 4;
	public Peacock(double weight, int age) {
		super( ( name+" -"+(id++) ), weight, age, Sound.getSound(name), legs, canFly, AnimalType.PEACOCK);
	}
}
