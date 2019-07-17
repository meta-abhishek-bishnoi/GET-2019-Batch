package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import meta.utility.ArrOperations;
import meta.utility.FixXY;

public class FixXYTest {
	private static ArrOperations operations;
	private static Properties properties;
	@BeforeClass
	public static void start() throws IOException{
		operations = new ArrOperations();
		properties  = operations.getMessages();
	}

	@Test
	public void testFixXy() {
		int x = 4;
		int y = 5;
		int inputArray[] = {5,4,9,4,9,5};
		int expectedArray[] = {9,4,5,4,5,9};
		int resultArray[]=null;
		try {
			resultArray = operations.fixXy(x, y, inputArray);
			assertArrayEquals(expectedArray,resultArray);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}

	@Test
	public void testFixXy1() {
		int x = 4;
		int y = 5;
		int inputArray[] = {1,4,1,5};
		int expectedArray[] = {1,4,5,1};
		int resultArray[]=null;
		try {
			resultArray = operations.fixXy(x, y, inputArray);
			assertArrayEquals(expectedArray,resultArray);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	
	@Test
	public void testFixXy2() {
		int x = 4;
		int y = 5;
		int inputArray[] = {1,4,1,5,5,4,1};
		int expectedArray[] = {1,4,5,1,1,4,5};
		int resultArray[]=null;
		try {
			resultArray = operations.fixXy(x, y, inputArray);
			assertArrayEquals(expectedArray,resultArray);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
}
