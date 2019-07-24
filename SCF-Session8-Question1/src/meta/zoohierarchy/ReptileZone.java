/**
 * This class Specify The Zone As Animal Category
 * @author Abhishek Bishnoi
 * @version 1.0
 * @since 24-July-2019
 */
package meta.zoohierarchy;

import meta.data.AnimalCategory;

public class ReptileZone extends Zone{
	/**
	 * Constructor Calling For Specific Zone
	 * @param capacity capacity of zone
	 * @param hasPark boolean value
	 * @param hasCanteen boolean value
	 */
	public ReptileZone(int capacity, boolean hasPark, boolean hasCanteen){
		/**
		 * Calling Constructor of Zone
		 */
		super(AnimalCategory.REPTILE, capacity, hasPark, hasCanteen);
	}
}