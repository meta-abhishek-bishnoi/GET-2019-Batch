/*
 * 
 */
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import meta.utility.ArrOperations;
import meta.utility.Clumps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClumpsTest {
	private static ArrOperations operations;
	private static Properties properties;
	@BeforeClass
	public static void start() throws IOException{
		operations = new ArrOperations();
		properties  = operations.getMessages();
	}
	/*
	 * 
	 */
	@Test
	public void testGetClumpsCount1() {
		
		int arrayData[] = {1,1,1,1};
		int expected = 1;
		int actual = 0;
		try {
			actual = operations.getClumpsCount(arrayData);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}

	@Test
	public void testGetClumpsCount2() {
		int arrayData[] = {1,2,2,3,4,4};
		int expected = 2;
		int actual = 0;
		try {
			actual = operations.getClumpsCount(arrayData);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	
	@Test
	public void testGetClumpsCount3() {
		int arrayData[] = {1,1,2,1,1};
		int expected = 2;
		int actual = 0;
		try {
			actual = operations.getClumpsCount(arrayData);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	
	/*
	 * false test cases
	 */
	@Test
	public void testGetClumpsCount4() throws Exception {
		int arrayData[]={}; //sending null to fail test case
		int expected = 0;
		int actual = 0;
		try {
			actual = operations.getClumpsCount(arrayData);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	
}
