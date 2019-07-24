package meta.zoohierarchy;

import meta.data.AnimalCategory;

public class BirdZone extends Zone{
	
	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen){
		super(AnimalCategory.BIRD, capacity, hasPark, hasCanteen);
	}
}
