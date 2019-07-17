/*
 * This is parameter test class 
 * This Class contains Testing Functions for Mirror Image
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 17-July-2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import meta.utility.ArrOperations;
import meta.utility.MirrorSection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MirrorSectionTest {

	private static ArrOperations operations;
	/*
	 * This function runs before test function of the classes
	 */
	@BeforeClass
	public static void start() throws IOException{
		operations = new ArrOperations();
	}
	/*
	 * Testing function with @Parameters 
	 * So these test cases will executes one by one(By Iteration)
	 * so here we don't require to write too much test cases
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] {1, 2, 1, 4} },
				{ 3, new int[] {1, 2, 3, 8, 7, 3, 2, 1} },
				{ 7, new int[] {1, 4, 5, 7, 5, 4, 1}},
				{ 11, new int[] {1, 4, 3, 4, 6, 5, 11, 5, 6, 4, 3, 4, 6, 9} },
				{ 3, new int[] {1, 4, 5, 6, 5, 6, 4} },
				{ 1, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0} },
				{ 5, new int[] {5,5,5,5,5}}
				});
	   }
	private int expected ;
	private int inputArray[];
	
	/*
	 * Constructor Value for each testCase
	 */
	public MirrorSectionTest(int expected, int[] inputArray){
		this.expected = expected;
		this.inputArray = inputArray;
	}
	
	/*
	 * Runs For Each test Case  
	 */
	@Test
	public void test() throws Exception {
		int actual = operations.getLargestMirrorSection(inputArray);
		assertEquals(expected,actual);
	}
	
	/*
	 * Fails Test Cases
	 */
	/*
	@Test
	public void test4() throws IOException {
		int inputArray[] = {};
		int expectedResult = 0;
		int actualResult=0;
		try {
			actualResult = operations.getLargestMirrorSection(inputArray);
			assertEquals(expectedResult, actualResult);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	*/
}
