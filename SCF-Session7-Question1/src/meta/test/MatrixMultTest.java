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
public class MatrixMultTest {

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
			{inputArr1 = DataMult.ARRAY_ONE_FIRST, inputArr2 = DataMult.ARRAY_ONE_SECOND, expectedArr = DataMult.ARRAY_ONE_RESULT},
			{inputArr1 = DataMult.ARRAY_TWO_FIRST, inputArr2 = DataMult.ARRAY_TWO_SECOND, expectedArr = DataMult.ARRAY_TWO_RESULT},
			{inputArr1 = DataMult.ARRAY_THREE_FIRST, inputArr2 = DataMult.ARRAY_THREE_SECOND, expectedArr = DataMult.ARRAY_THREE_RESULT},
			{inputArr1 = DataMult.ARRAY_FOUR_FIRST, inputArr2 = DataMult.ARRAY_FOUR_SECOND, expectedArr = DataMult.ARRAY_FOUR_RESULT}
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
	public MatrixMultTest(int inputArr1[][],int inputArr2[][], int[][] expectedArr){
		this.inputArr1 = inputArr1;
		this.inputArr2 = inputArr2;
		this.expectedArr = expectedArr;
	}
	@Test
	public void testMultMatrix() {
		int actual[][] = service.multiplyMatrix(inputArr1, inputArr2);
		assertArrayEquals(expectedArr,actual);
	}

}
