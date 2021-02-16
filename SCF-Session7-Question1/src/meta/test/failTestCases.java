/**
 * This class contains fail test cases
 * @author Abhishek Bishnoi
 * @version 1.0
 * @since 22-July-2019
 */
package meta.test;

import static org.junit.Assert.*;
import meta.utility.Service;

import org.junit.AfterClass;
import org.junit.Test;

public class failTestCases {

	Service service = new Service();
	// for transpose
	@Test(expected=AssertionError.class)
	public void failTestCaseTrans() {
		int array[][] = {{1}};
		int trans[][] = {{1}};
		int actual[][] = service.getTranspose(array);
		assertArrayEquals(trans,actual);
	}
	// for isSymmetric Array
	@Test(expected=AssertionError.class)
	public void failTestIsSymmetric() {
		int array[][] = {{1}};
		boolean expected = false;
		boolean actual = service.isSymmetrical(array);
		assertEquals(expected,actual);
	}

	// for addition
	@Test(expected=AssertionError.class)
	public void failTestAdditionOne() {
		int array1[][] = {{1}};
		int array2[][] = {{1}};
		int expected[][] = {{2}};
		int actual[][] = service.addMatrix(array1, array2);
		assertArrayEquals(expected,actual);
	}
	// for addition
	@Test(expected=AssertionError.class)
	public void failTestAdditionTwo() {
		int array1[][] = {
				{1,0,0},
				{0,0,0}
		};
		int array2[][] = {
				{0,0,0}
		};
		int expected[][] = {
				{1,0,0},
				{0,0,0}
		};
		int actual[][] = service.addMatrix(array1, array2);
		assertArrayEquals(expected,actual);
	}
	// for multiply
	@Test(expected=AssertionError.class)
	public void failTestMultiplyOne() {
		int array1[][] = {{1}};
		int array2[][] = {{1}};
		int expected[][] = {{1}};
		int actual[][] = service.multiplyMatrix(array1, array2);
		assertArrayEquals(expected,actual);
	}
	// for multiply
	@Test(expected=AssertionError.class)
	public void failTestMultiPlyTwo() {
		int array1[][] = {
				{1,0,0},
				{0,0,0}
		};
		int array2[][] = {
				{0,0,0}
		};
		int expected[][] = {
				{1,0,0},
				{0,0,0}
		};
		int actual[][] = service.multiplyMatrix(array1, array2);
		assertArrayEquals(expected,actual);
	}
	@Test
	public void failTestAddition() {
		int array1[][] = {
				{-2,0},
				{0,0}
		};
		int array2[][] = {
				{2,0},
				{0,0}
		};
		int expected[][] = {
				{0,0},
				{0,0}
		};
		int actual[][] = service.addMatrix(array1, array2);
		assertArrayEquals(expected,actual);
	}
}
