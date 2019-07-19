/*
* This Class contains serach function 
* using binary search algorithm
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 17-July-2019
*/
package meta.utility;

public class BinarySearch implements Search {
	int firstIndex=-1;
	int lastIndex=-1;
	/*
	 * (non-Javadoc)
	 * @see meta.utility.Search#search(int, int[])
	 * @param int value to be search
	 * @param int[] dataset where we search
	 * @return int index of that element
	 * Assumption All Values Are Positive
	 * Assumption Array is always in sorter order
	 * Assumption Values are Not repeat into array data
	 * Exception AssertionError when array size is zero
	 */
	@Override
	public int search(int value, int[] array) {
		int indexValue=-1;
		
		int midIndex;
		if(firstIndex>lastIndex){
			return indexValue;
		}
		/*
		 * condition when function calls itself first time
		 */
		if(firstIndex==-1 && lastIndex==-1 )
		{
			firstIndex = 0;
			lastIndex = array.length-1;
		}
			
		midIndex = (firstIndex+lastIndex)/2;
		if(array[midIndex]==value){
			indexValue = midIndex;
			return indexValue;
		}
		if(array[midIndex]>value){
			lastIndex = midIndex-1; // updating last index
		}
		if(array[midIndex]<value){
			firstIndex = midIndex+1; // updating firstIndex
		}
		return search( value, array );
	}
	
}
