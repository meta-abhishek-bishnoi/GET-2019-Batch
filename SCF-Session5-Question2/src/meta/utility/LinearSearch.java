/*
* This Class Contains Method for Linear Search
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 17-July-2019
*/
package meta.utility;

public class LinearSearch  implements Search{

	private int indexArray=0;
	/*
	 * (non-Javadoc)
	 * @see meta.utility.Search#search(int, int[])
	 * @param int value to be search
	 * @param int[] dataset where we search
	 * @return int index of that element
	 * Assumption All Values Are Positive
	 * Exception AssertionError when array size is zero
	 */
	@Override
	public int search(int value, int[] array) {
		if(array.length==0){
			throw new AssertionError("Invalid Size Of Array");
		}
		int indexValue=-1;
		if(indexArray>=array.length){
			return indexValue;
		}
		if(array[indexArray]==value){
			indexValue = indexArray;
			return indexValue;
		}
		indexArray++;
		return search( value, array );
	}

}
