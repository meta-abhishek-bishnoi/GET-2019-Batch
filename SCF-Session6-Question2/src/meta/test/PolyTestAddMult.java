/*
* This class is to run testcases of Addition and Multiplication of poly function
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 22-July-2019
*/
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import meta.utility.Poly;
import meta.utility.Service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PolyTestAddMult {

	private static Service service;
	/*
	 * This function runs before test function of the classes
	 */
	@BeforeClass
	public static void start() throws IOException{
		service = new Service();
	}
	/*
	 * Testing function with @Parameters 
	 * So these test cases will executes one by one(By Iteration)
	 * so here we don't require to write too much test cases
	 */
	 @Parameters
	 public static Collection<Object[]> data() {
		 return Arrays.asList(new Object[][] {
				 {testArrayAns.ADDITION_ONE_ONE,testArrayAns.MULTIPLY_ONE_ONE,testArraysData.ARRAY_ONE,testArraysData.ARRAY_ONE},
				 {testArrayAns.ADDITION_TWO_TWO,testArrayAns.MULTIPLY_TWO_TWO,testArraysData.ARRAY_TWO,testArraysData.ARRAY_TWO},
				 {testArrayAns.ADDITION_ONE_TWO,testArrayAns.MULTIPLY_ONE_TWO,testArraysData.ARRAY_ONE,testArraysData.ARRAY_TWO},
				 {testArrayAns.ADDITION_THREE_FIVE,testArrayAns.MULTIPLY_THREE_FIVE,testArraysData.ARRAY_THREE,testArraysData.ARRAY_FIVE},
				 {testArrayAns.ADDITION_SIX_FIVE,testArrayAns.MULTIPLY_SIX_FIVE,testArraysData.ARRAY_SIX,testArraysData.ARRAY_FIVE}
				 });
	    }
	    
	 private Poly[] expectedAdd;
	 private Poly[] expectedMult;
	 private Poly[] arrayOne;
	 private Poly[] arrayTwo;
	 /*
	  * Constructor Value for each testCase
	  */
	 public PolyTestAddMult(Poly[] expectedAdd, Poly[] expectedMult, Poly[] arrayOne, Poly[] arrayTwo){
		 this.expectedAdd = expectedAdd;
		 this.expectedMult = expectedMult;
		 this.arrayOne = arrayOne;
		 this.arrayTwo = arrayTwo;
	 }
	 /*
	  * all test cases will run all time 
	  */
	@Test
	public void testAddition() {
		Poly actual[] = service.addPolynomial(arrayOne, arrayTwo);
		int[][] expectedArr = service.toIntArray(expectedAdd);
		int[][] actualArr = service.toIntArray(actual);
		assertArrayEquals(expectedArr,actualArr);
	}
	@Test
	public void testMultiplication(){
		Poly actual[] = service.multiplyPolynomial(arrayOne, arrayTwo);
		int[][] expectedArr = service.toIntArray(expectedMult);
		int[][] actualArr = service.toIntArray(actual);
		assertArrayEquals(expectedArr,actualArr);
	}

}
