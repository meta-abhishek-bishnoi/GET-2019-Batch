/*
 * This is Test class for testing function of MathsOperations 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 18-July-2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import meta.utility.Maths;
import meta.utility.LCM;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MathTest {

	/*
	 * 
	 * Testing function with @Parameters 
	 * So these test cases will executes one by one(By Iteration)
	 * so here we don't require to write too much test cases
	 * here in this array we are sending in order of:
	 * expectedHCF, expectedLCM, first value and last value
	 */
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{ 1, 15, 3, 5 },
				{ 12, 48, 12, 48 },
				{ 2, 48, 6, 16 },
				{ 1, 65, 13, 5 },
				{ 6, 84, 42, 12 },
				{ 1, 884, 17, 52},
				{ 2, 70, 10, 14},
				{ 2, 70, 14, 10},
				{ 1, 35, 5, 7},
				{ 1, 221, 13, 17}
		});
	}
	// variable declaration
	private int hcfExpected; 
	private int lcmExpected;
	private int firstValue;
	private int secondValue;
	/*
	 * this Constructor called each time when iteration values are send to test
	 */
	public MathTest( int hcfExpected, int lcmExpected, int firstValue, int secondValue ){
		this.hcfExpected = hcfExpected;
		this.lcmExpected = lcmExpected;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	/*
	 * calling hcf() with values and compare it with expected result 
	 */
	@Test
	public void hcf() {
		int hcfResult = Maths.hcf(firstValue, secondValue);
		assertEquals(hcfExpected,hcfResult);
	}
	
	/*
	 * calling lcm() with values and compare it with expected result 
	 */
	@Test
	public void lcm() throws Exception {
		int lcmResult = Maths.lcm(firstValue,secondValue);
		assertEquals(lcmExpected,lcmResult);
	}

}
