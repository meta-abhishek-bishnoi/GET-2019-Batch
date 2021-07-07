/*
 * This test class is for testing all fail test cases
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 17-July-2019
 */
package meta.test;

import static org.junit.Assert.*;
import meta.utility.ArrOperations;

import org.junit.BeforeClass;
import org.junit.Test;

public class FailTestCasesAllClasses {
	private static ArrOperations operations;
	@BeforeClass
	public static void start(){
		operations = new ArrOperations();
	}
	/*
	 * This is fail test case for Clumps Class
	 * when array size is zero
	 */
	@Test(expected = AssertionError.class)
	public void failTestClupms() throws Exception {
		 int expected=0;
		 int[] inputArray={};
		 int result = operations.getClumpsCount(inputArray);
		 assertEquals(expected,result);
	}
	/*
	 *  This is fail test case for FixXY Class
	 *  where array size is zero
	 */
	@Test(expected = AssertionError.class)
	public void failTestFixXYOne() throws Exception {
		 int x = 4;
		 int y = 5;
		 int inputArray[] = {};
		 int expected[] = {};
		 int result[] = operations.fixXy(x, y, inputArray);
		 assertArrayEquals(expected,result);
	}
	/*
	 *  This is fail test case for FixXY Class
	 *  where No of Y is greater then no of X 
	 */
	@Test(expected = AssertionError.class)
	public void failTestFixXYTwo() throws Exception {
		 int x = 4;
		 int y = 5;
		 int inputArray[] = {4,6,5,5,4,6,7};
		 int expected[] = {};
		 int result[] = operations.fixXy(x, y, inputArray);
		 assertArrayEquals(expected,result);
	}
	/*
	 * This is fail test case for FixXY Class
	 * When x -axis value is end of an array
	 */
	@Test(expected = AssertionError.class)
	public void failTestFixXYThree() throws Exception {
		 int x = 4;
		 int y = 5;
		 int inputArray[] = {4,6,5,5,6,4};
		 int expected[] = {};
		 int result[] = operations.fixXy(x, y, inputArray);
		 assertArrayEquals(expected,result);
	}
	/*
	 * This is fail test case for FixXY Class
	 * when x-axis value is adjacent or x-axis and y-axis are equal
	 */
	@Test(expected = AssertionError.class)
	public void failTestFixXYFour() throws Exception {
		 int x = 4;
		 int y = 4;
		 int inputArray[] = {4,4,5,6,4,4};
		 int expected[] = {};
		 int result[] = operations.fixXy(x, y, inputArray);
		 assertArrayEquals(expected,result);
	}
	/*
	 * This is fail test case for MirrorSection Class
	 * when array size is zero
	 */
	@Test(expected = AssertionError.class)
	public void failTestMirror() throws Exception {
		int expected = 0;
		int array[] = {};
		int result = operations.getLargestMirrorSection(array);
		assertEquals(expected,result);
	}
	/*
	 * This is fail test case for SplitArray Class
	 * when array size is zero
	 */
	@Test(expected = AssertionError.class)
	public void failTestSplitArray() throws Exception {
		int expected = 0;
		int array[] = {};
		int result = operations.splitArray(array);
		assertEquals(expected,result);
	}
}
