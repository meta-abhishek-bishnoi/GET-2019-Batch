/*
 * this class contains some test cases with fail and pass
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.test;

import static org.junit.Assert.*;
import meta.utility.IntSet;

import org.junit.Test;

public class IntSetTest {

	/**
	* Test case when input set is empty
	*/
	@Test(expected = AssertionError.class)
	public void setIsEmptyTest() {
	IntSet intSet = new IntSet(new int[] {});
	assertEquals(true, intSet.isMember(5));

	}

	/**
	* A positive Test case for getComplement()
	*/
	@Test
	public void complimentTest() {
	int []input=new int[] { 1, 3, 5, 8, 12, 15, 18, 40 };
	IntSet intSet = new IntSet(input);
	int[] expectedArray = new int[1000 - input.length];
	int j = 0;
	for (int i = 0; i < 1000; i++) {
	if (!(intSet.isMember(i + 1))) {
	expectedArray[j] = i + 1;
	j++;
	}
	}
	assertArrayEquals(expectedArray, intSet.getCompliment(intSet).getIntSet());
	}

	/**
	* A positive Test case for union()
	*/
	@Test
	public void unionTest() {
	int input1[]=new int[] { 1, 3, 5, 8, 12, 15, 18, 40 };
	int input2[]=new int[] { 3, 2, 5, 4, 7, 8 };
	IntSet obj1 = new IntSet(input1);
	IntSet obj2 = new IntSet(input2);
	assertArrayEquals(new int[] { 1, 3, 5, 8, 12, 15, 18, 40, 2, 4, 7 }, obj1.union(obj1, obj2).getIntSet());

	}

}
