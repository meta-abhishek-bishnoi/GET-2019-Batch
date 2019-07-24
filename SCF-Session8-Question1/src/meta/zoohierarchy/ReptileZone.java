package meta.zoohierarchy;

import meta.data.AnimalCategory;

public class ReptileZone extends Zone{
	
	public ReptileZone(int capacity, boolean hasPark, boolean hasCanteen){
		super(AnimalCategory.REPTILE, capacity, hasPark, hasCanteen);
	}
}