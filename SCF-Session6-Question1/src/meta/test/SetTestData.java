package meta.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTestData {
	private static Random random = new Random();
	public static int[] getSet(int len){
		return getRandArray(len);
	}

	public static int getArrayRandom(int array[]){
		int number = random.nextInt(array.length);
		return array[number];
	}
	private static int[] getRandArray(int length) {
		Set<Integer> list = new HashSet<Integer>();
		for(int i=1; i<=length; i++){
			int ran = random.nextInt((1000-0)+1)+0;
			list.add(ran);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
	public static int[] getSubSet(int array[], int size){
		Set<Integer> list = new HashSet<Integer>();
		for(int i=1; i<=size; i++){
			int ran = random.nextInt(array.length);
			list.add( array[ran]);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
}
