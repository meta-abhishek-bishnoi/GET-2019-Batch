/*
 * This class is helper class of testing classes
 * This class Contains some methods which creates Set<Integer> randomly and 
 * return them as an int[] array, here one function again crete subset from 
 * existing set and a function return a random value from set
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTestData {
	private static Random random = new Random();
	/*
	 * @param int length required set
	 * @return a Set<Integer>
	 * size()<=len
	 */
	public static int[] getSet(int len){
		return getRandArray(len); // calling random Array Function
	}

	/*
	 * @param int[] set as array[]
	 * @return int Random Element of array
	 */
	public static int getArrayRandom(int array[]){
		int number = random.nextInt(array.length);
		return array[number];
	}

	/*
	 * @param int lenght
	 * @return Array as Set Value; Size()<= length
	 * they contains an set of random values
	 */
	private static int[] getRandArray(int length) {
		Set<Integer> list = new HashSet<Integer>();
		for(int i=1; i<=length; i++){
			int ran = random.nextInt((1000-0)+1)+0;
			list.add(ran);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
	/*
	 * @param int[] a Set in array[]
	 * @param int subSet lenght
	 * @return subSet in array form 
	 * size() <= requied length
	 */
	public static int[] getSubSet(int array[], int size){
		Set<Integer> list = new HashSet<Integer>();
		for(int i=1; i<=size; i++){
			int ran = random.nextInt(array.length);
			list.add( array[ran]);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
}
