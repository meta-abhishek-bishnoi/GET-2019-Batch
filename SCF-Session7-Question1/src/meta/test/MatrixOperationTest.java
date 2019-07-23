package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import meta.test.TestData;
import meta.utility.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class MatrixOperationTest {

	private static Service service;
	@Before
	public void start(){
		service = new Service();
	}
	/*
	 *  Testing function with @Parameters 
	 * 	So these test cases will executes one by one(By Iteration)
	 * 	so here we don't require to write too much test cases
	 * 	in test cases they contains in order of
	 *  INPUT ARRAY, EXPECTED TRANS ARRAY, EXPECTED BOOLEAN VALUE 
	 *  
	 */
	@Parameters
	public static Collection<Object[]> data(){
		int [][] inputArr;
		int [][] transArr;
		boolean isSymmetric;
		return Arrays.asList(new Object[][]{
			{inputArr=TestData.ARRAY_ONE, transArr = TestData.TRANS_ONE, isSymmetric= TestData.SYMMETRIC_ONE},
			{inputArr=TestData.ARRAY_TWO, transArr = TestData.TRANS_TWO, isSymmetric= TestData.SYMMETRIC_TWO},
			{inputArr=TestData.ARRAY_THREE, transArr = TestData.TRANS_THREE, isSymmetric= TestData.SYMMETRIC_THREE},
			{inputArr=TestData.ARRAY_FOUR, transArr = TestData.TRANS_FOUR, isSymmetric= TestData.SYMMETRIC_FOUR},
			{inputArr=TestData.ARRAY_FIVE, transArr = TestData.TRANS_FIVE, isSymmetric= TestData.SYMMETRIC_FIVE}
		});
	}
	/*
	 *  variable initialization
	 */
	private int[][] inputArr;
	private int[][] transArr;
	private boolean isSymmetric;
	/*
	* This is constructor
	*/
	public MatrixOperationTest(int inputArr[][],int transArr[][], boolean isSymmetric){
		this.inputArr = inputArr;
		this.transArr = transArr;
		this.isSymmetric = isSymmetric;
	}
	/**
	 * Test case for transpose
	 */
	@Test
	public void testTranspose() {
		int actual[][] = service.getTranspose(inputArr);
		assertArrayEquals(transArr,actual);
	}

	/**
	 * Test cases for symmetric
	 */
	@Test
	public void testIsSymmetrical() {
		boolean actual = service.isSymmetrical(inputArr);
		assertEquals(isSymmetric,actual);
	}

}
