package meta.zoohierarchy;

import meta.data.AnimalCategory;

public class MammalZone extends Zone{
	
	public MammalZone(int capacity, boolean hasPark, boolean hasCanteen){
		super(AnimalCategory.MAMMAL, capacity, hasPark, hasCanteen);
	}
}
