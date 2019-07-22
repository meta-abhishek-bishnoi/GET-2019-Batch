package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import meta.utility.Service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PolyTest {

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
				 {4,1,2,testArraysData.ARRAY_ONE},
				 {20,3,2,testArraysData.ARRAY_TWO},
				 {-1,3,-1,testArraysData.ARRAY_TWO},
				 {9,4,-1,testArraysData.ARRAY_THREE},
				 {1,4,1,testArraysData.ARRAY_THREE},
				 {-4,5,-1,testArraysData.ARRAY_FOUR},
				 {2,5,1,testArraysData.ARRAY_FOUR},
				 {0,1,1,testArraysData.ARRAY_FIVE},
				 {-2,1,-1,testArraysData.ARRAY_FIVE},
				 {15,2,-1,testArraysData.ARRAY_SIX},
				 {3,2,2,testArraysData.ARRAY_SIX},
				 {3,2,3,testArraysData.ARRAY_SIX}
				 });
	    }
	    
	 private double expectedValue;
	 private int value;
	 private int expectedDegree;
	 private int[][] inputArray;
	 /*
	  * Constructor Value for each testCase
	  */
	 public PolyTest(double expectedValue, int expectedDegree, int value, int inputArray[][]){
		 this.expectedValue = expectedValue;
		 this.value  = value;
		 this.expectedDegree = expectedDegree;
		 this.inputArray = inputArray;
	 }
	 /*
	  * all test cases will run all time 
	  */
	@Test
	public void testEvalute() {
		double actual = service.evalute(inputArray, value);
		assertEquals(expectedValue,actual,0);
	}
	@Test
	public void testDegree(){
		int actual = service.degree(inputArray);
		assertEquals(expectedDegree,actual);
	}

}
