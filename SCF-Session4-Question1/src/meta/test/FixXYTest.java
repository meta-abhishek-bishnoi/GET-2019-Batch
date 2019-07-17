/*
 * This is parameter test class 
 * This Class contains Testing Functions for FixXY Class
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 16-July-2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import meta.utility.ArrOperations;
import meta.utility.FixXY;

@RunWith(Parameterized.class)
public class FixXYTest {
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
				{ 4, 5, new int[]{ 5, 4, 9, 4, 9, 5 }, new int[] { 9, 4, 5, 4, 5, 9 } },
				{ 2, 3, new int[] { 1, 2, 1, 3, 2, 5, 6, 3 }, new int[] { 1, 2, 3, 1, 2, 3, 6, 5 }},
				{ 4, 5, new int[] { 1, 4, 1, 5, 5, 4, 1 }, new int[]{1, 4, 5, 1, 1, 4, 5 }},
				{ 0, 2, new int[] {2, 0, 1, 0, 2, 1}, new int[] {1, 0, 2, 0, 2, 1 }}, 
				{ 1, 2, new int[] {3, 1, 3, 2, 2, 2, 1, 4, 1, 5}, new int[] {3, 1, 2, 3, 4, 5, 1, 2, 1, 2 }}
				});
	   }
	private int x;
	private int y;
	private int expected[] ;
	private int inputArray[];
	
	/*
	 * Constructor Value for each testCase
	 */
	public FixXYTest( int x, int y, int[] inputArray, int[] expected ){
		this.x = x;
		this.y = y;
		this.inputArray = inputArray;
		this.expected = expected;
	}
	/*
	 * Runs For Each test Case    
	 */
	@Test
	public void testFixXy() throws Exception {
		int result[] = operations.fixXy(x, y, inputArray);
		assertArrayEquals(expected,result);
	}
}
