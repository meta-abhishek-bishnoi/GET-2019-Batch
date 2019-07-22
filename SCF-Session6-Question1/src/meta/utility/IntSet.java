package meta.utility;

import java.util.LinkedHashSet;
import java.util.Set;

public class IntSet implements IntSetInterface{
	private final Set<Integer> set = new LinkedHashSet<Integer>();
	/*
	 * 
	 */
	public IntSet(int array[]){
		for( int value : array ){
			set.add( value );
		}
	}
	/*
	 * 
	 */
	public Set<Integer> getIntSet(){
		return this.set;
	}
	/*
	 * (non-Javadoc)
	 * @see meta.utility.IntSetInterface#isMember(int)
	 */
	@Override
	public boolean isMember( int x ) {
		boolean result = false;
		if( set.contains(x) ){
			result = true;
			return result;
		}
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see meta.utility.IntSetInterface#size()
	 */
	@Override
	public int size() {
		int size = 0;
		/*
		 * for(int x: set){
		 * size++ ;
		 * }
		 * this for loop contains O(n) Complexity to calculate size 
		 */
		size = set.size(); 
		// Contains O(1) Complexity to calculate size
		return size;
	}
	
	/*
	 * (non-Javadoc)
	 * @see meta.utility.IntSetInterface#isSubSet()
	 */
	@Override
	public boolean isSubSet( IntSet subSet ) {
		boolean result = true;
		final Set< Integer > currentSet = subSet.getIntSet();
		//
		for(int value : currentSet ){
			if( !( set.contains(value) ) ){
				result = false;
				return false;
			}
		}
		return result;
	}
	/*
	 * (non-Javadoc)
	 * @see meta.utility.IntSetInterface#union(meta.utility.IntSet, meta.utility.IntSet)
	 */
	@Override
	public IntSet union(IntSet set1, IntSet set2) {
		final Set<Integer> currentSet1 = set1.getIntSet();
		final Set<Integer> currentSet2 = set2.getIntSet();
		final Set<Integer> unionSet = new LinkedHashSet<Integer>();
		unionSet.addAll(currentSet1);
		unionSet.addAll(currentSet2);
		int unionArray [] = getIntArray(unionSet);
		IntSet returnObject = new IntSet(unionArray);
		return returnObject;
	}
	private int[] getIntArray(Set<Integer> unionSet) {
		int resultArray[] = new int[unionSet.size()];
		int index = 0;
		for( int value : unionSet){
			resultArray[index] = value;
			index++;
		}

		return resultArray;
	}
	@Override
	public IntSet getCompliment() {
		return null;
	}
}
