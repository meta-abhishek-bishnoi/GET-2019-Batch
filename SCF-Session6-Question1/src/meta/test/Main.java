package meta.test;

import java.util.LinkedHashSet;
import java.util.Set;

import meta.utility.IntSet;
public class Main
{
	public static void main(String[] args) {
		int setArray[] = {1,2,2,3,5,8,13,21,34,55,18};
		IntSet originalSet = new IntSet(setArray);
		System.out.println("Set Is :");
		for(int set : originalSet.getIntSet()){
		    System.out.print(set+" ");
		}
		System.out.println("\nSize Of Set is : "+originalSet.size());
		System.out.println("Is 5 is member of set : "+originalSet.isMember(5));
		System.out.println("Is 0 is member of set : "+originalSet.isMember(0));
		int subArray[] = {2,2,3,5,8};
		IntSet subset = new IntSet(subArray);
		System.out.println("is Subset : "+originalSet.isSubSet(subset));
		int setOneArray[] = {1,4,5,6,7,8};
		int setTwoArray[] = {5,9,11,13};
		IntSet setOne = new IntSet(setOneArray);
		IntSet setTwo = new IntSet(setTwoArray);
		IntSet unionOfSet = originalSet.union(setOne,setTwo);
		System.out.println("First Set Is ");
		for(int set : setOne.getIntSet()){
		    System.out.print(set+" ");
		}
		System.out.println();
		System.out.println("Second Set Is ");
		for(int set : setTwo.getIntSet()){
		    System.out.print(set+" ");
		}
		System.out.println();
		System.out.println("union Set Is ");
		for(int set : unionOfSet.getIntSet()){
		    System.out.print(set+" ");
		}
		System.out.println();
	}
}
