package meta.utility;

public class LinearSearch  implements Search{

	private int indexArray=0;
	/*
	 * (non-Javadoc)
	 * @see meta.utility.Search#search(int, int[])
	 */
	@Override
	public int search(int value, int[] array) {
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
