/*
 * This Class contains Testing Functions for Mirror Image
 * In this Class we include some fails testcases too
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 17-July-2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import meta.utility.ArrOperations;
import meta.utility.MirrorSection;

import org.junit.BeforeClass;
import org.junit.Test;

public class MirrorSectionTest {

	private static ArrOperations operations;
	private static Properties properties;
	@BeforeClass
	public static void start() throws IOException{
		operations = new ArrOperations();
		properties  = operations.getMessages();
	}
	/*
	 * This function calls the 
	 */
	@Test
	public void test() throws IOException {
		ArrOperations operations = new ArrOperations();
		int inputArray[] = {1,2,1,4};
		int expectedResult = 3;
		int actualResult=0;
		try {
			actualResult = operations.getLargestMirrorSection(inputArray);
			assertEquals(expectedResult, actualResult);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
		
	}

	@Test
	public void test1() throws IOException {
		int inputArray[] = {1,2,3,8,9,3,2,1};
		int expectedResult = 3;
		int actualResult=0;
		try {
			actualResult = operations.getLargestMirrorSection(inputArray);
			assertEquals(expectedResult, actualResult);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
		
	}

	@Test
	public void test3() throws IOException {
		int inputArray[] = {1,4,5,3,5,4,1};
		int expectedResult = 7;
		int actualResult=0;
		try {
			actualResult = operations.getLargestMirrorSection(inputArray);
			assertEquals(expectedResult, actualResult);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	
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
}
