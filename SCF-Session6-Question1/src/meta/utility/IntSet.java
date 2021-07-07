/*
 * This class defines structure for IntSet 
 * This is Service Class
 * Where this class is return values as per requested service 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntSet implements IntSetInterface{
	private final int[] setArray;
	/*
	 * IntSet save as a Set value
	 * @param int[] array as a set value
	 */
	public IntSet(int inputArray[]){
		setArray = getSetArray(inputArray);
	}
	/**
	 * 
	 * @param inputArray input Array
	 * @return return Set data type Array
	 * Complexity O(n^2)
	 */
	private int[] getSetArray(int[] inputArray) {
		List<Integer> listSet = new ArrayList<Integer>();
		for(int i=0;i<inputArray.length;i++){
            boolean isDistinct = false;
            for(int j=0;j<i;j++){
                if(inputArray[i] == inputArray[j]){
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct){
            	listSet.add(inputArray[i]);
            }
		}
		int setArray[] = listSet.stream().mapToInt(i -> i).toArray();
		return setArray;
	}
	/*
	 * @return Set<Integer> getter method
	 */
	public int[] getIntSet(){
		return setArray;
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
		for(int setValue: setArray){
			if(setValue == x){
				result=true;
				break;
			}
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
		size = setArray.length; 
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
		final int[] currentSet = subSet.getIntSet();
		//
		for(int currentSetvalue : currentSet ){
			for(int setValue : setArray){
				if( setValue != currentSetvalue ){
					result = false;
					return result;
				}
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
		final int[] currentSet1 = set1.getIntSet();
		final int[] currentSet2 = set2.getIntSet();
		final List<Integer> union = new LinkedList<Integer>();
		for(int i=0; i<currentSet1.length; i++){
			union.add(currentSet1[i]);
		}
		for(int i=0; i<currentSet2.length; i++){
			union.add(currentSet2[i]);
		}
		int unionArray [] = union.stream().mapToInt(i -> i).toArray();
		IntSet returnObject = new IntSet(unionArray);
		return returnObject;
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
		int[] universalSet = universal.getIntSet();
		int[] currentSet = set.getIntSet();
		List<Integer> list = new LinkedList<Integer>();
		for(int universalSetValue : universalSet){
			boolean isCommon=false;
			for(int currentSetValue: currentSet){
				if(currentSetValue==universalSetValue){
					isCommon = true;
					break;
				}
			}
			if(!isCommon){
				list.add(universalSetValue);
				break;
			}
		}
		int[] array = list.stream().mapToInt(i -> i).toArray();
		return new IntSet(array);
	}
}
