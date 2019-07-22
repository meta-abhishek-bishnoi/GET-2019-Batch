/*
 * This class defines structure for IntSet 
 * This is Service Class
 * Where this class is return values as per requested service 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntSet implements IntSetInterface{
	private final Set<Integer> set = new LinkedHashSet<Integer>();
	/*
	 * IntSet save as a Set value
	 * @param int[] array as a set value
	 */
	public IntSet(int array[]){
		for( int value : array ){
			set.add( value );
		}
	}
	/*
	 * @return Set<Integer> getter method
	 */
	public Set<Integer> getIntSet(){
		return this.set;
	}
	/*
	 * @return Set<Integer> return set of range 1-1000
	 */
	public IntSet getUniversalSet(){
		int array[] = new int[1000];
		for(int i=0; i<=1000; i++){
			array[i-1] = i;
		}
		return new IntSet(array);
	}
	/*
	 * (non-Javadoc)
	 * @see meta.utility.IntSetInterface#isMember(int)
	 * @param int value to find isMember or not
	 * @return boolean true or false
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
	 * @return int size of set
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
	 * @param IntSet an object to check subSet or Not
	 * @return boolean true or false 
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
	 * @param IntSet firstSet
	 * @param IntSet secondSet
	 * @return union Of Set
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
	/*
	 * @param Set<integer> value in Set
	 * @return int[] an array value
	 */
	public int[] getIntArray(Set<Integer> unionSet) {
		int resultArray[] = new int[unionSet.size()];
		int index = 0;
		for( int value : unionSet){
			resultArray[index] = value;
			index++;
		}

		return resultArray;
	}
	/*
	 * (non-Javadoc)
	 * @see meta.utility.IntSetInterface#getCompliment(meta.utility.IntSet)
	 * @param IntSet set object
	 * @return compliment of set
	 */
	@Override
	public IntSet getCompliment(IntSet set) {
		IntSet universal = getUniversalSet();
		Set<Integer> universalSet = universal.getIntSet();
		Set<Integer> currentSet = set.getIntSet();
		List<Integer> list = new LinkedList<Integer>();
		for(int value : universalSet){
			if(!currentSet.contains(value)){
				list.add(value);
			}
		}
		int[] array = list.stream().mapToInt(i -> i).toArray();
		return new IntSet(array);
	}
}
