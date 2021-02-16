package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import meta.utility.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class MatrixAddTest {

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
	 *  INPUT FIRST ARRAY, INPUT FIRST ARRAY, EXPECTED ARRAY 
	 *  
	 */
	@Parameters
	public static Collection<Object[]> data(){
		int [][] inputArr1;
		int [][] inputArr2;
		int [][] expectedArr;
		boolean isSymmetric;
		return Arrays.asList(new Object[][]{
			{inputArr1 = DataAdd.ARRAY_ONE_FIRST, inputArr2 = DataAdd.ARRAY_ONE_SECOND, expectedArr = DataAdd.ARRAY_ONE_RESULT},
			{inputArr1 = DataAdd.ARRAY_TWO_FIRST, inputArr2 = DataAdd.ARRAY_TWO_SECOND, expectedArr = DataAdd.ARRAY_TWO_RESULT},
			{inputArr1 = DataAdd.ARRAY_THREE_FIRST, inputArr2 = DataAdd.ARRAY_THREE_SECOND, expectedArr = DataAdd.ARRAY_THREE_RESULT},
			{inputArr1 = DataAdd.ARRAY_FOUR_FIRST, inputArr2 = DataAdd.ARRAY_FOUR_SECOND, expectedArr = DataAdd.ARRAY_FOUR_RESULT}
		});
	}
	/*
	 *  variable initialization
	 */
	private int[][] inputArr1;
	private int[][] inputArr2;
	private int[][] expectedArr;
	/*
	* This is constructor
	*/
	public MatrixAddTest(int inputArr1[][],int inputArr2[][], int[][] expectedArr){
		this.inputArr1 = inputArr1;
		this.inputArr2 = inputArr2;
		this.expectedArr = expectedArr;
	}
	@Test
	public void testAddMatrix() {
		int actual[][] = service.addMatrix(inputArr1, inputArr2);
		assertArrayEquals(expectedArr,actual);
	}

}
