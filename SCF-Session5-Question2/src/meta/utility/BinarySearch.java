package meta.utility;

public class BinarySearch implements Search {
	int firstIndex=-1;
	int lastIndex=-1;
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
			lastIndex = midIndex-1;
		}
		if(array[midIndex]<value){
			firstIndex = midIndex+1;
		}
		return search( value, array );
	}
	
}
