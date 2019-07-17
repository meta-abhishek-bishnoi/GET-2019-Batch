package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import meta.utility.ArrOperations;
import meta.utility.SplitArray;

import org.junit.BeforeClass;
import org.junit.Test;

public class SplitArrayTest {

	private static ArrOperations operations;
	private static Properties properties;
	@BeforeClass
	public static void start() throws IOException{
		operations = new ArrOperations();
		properties  = operations.getMessages();
	}
	@Test
	public void testSplitArray1() {
		int array[] = {1,1,1,2,1};
		int expected = 3;
		try {
			int actual = operations.splitArray(array);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}
	
	@Test
	public void testSplitArray2() {
		int array[] = {};
		int expected = -1;
		try {
			int actual = operations.splitArray(array);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e);
			fail(properties.getProperty("EXCEPTION")+e);
		}
	}

}
