package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import meta.utility.BinarySearch;
import meta.utility.LinearSearch;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SearchTest {
	private static LinearSearch linearSearch;
	private static BinarySearch binarySearch;
	@Before
	public void start(){
		linearSearch = new LinearSearch();
		binarySearch = new BinarySearch();
	}
	/*
	 *  Testing function with @Parameters 
	 * 	So these test cases will executes one by one(By Iteration)
	 * 	so here we don't require to write too much test cases
	 * 	in test cases they contains in order of
	 *  expected result value, starting index, last index , searching element and array  
	 */
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{6, 9, new int[]{ 0, 4, 5, 6, 7, 7,9 }},
				{2, 9, new int[]{ 3, 7, 9, 14, 24, 27, 35, 44, 78 }}
		});
	}
	/*
	 * 
	 */
	private int expected;
	private int toBeSearch;
	private int searchingArray[];
	
	public SearchTest(int expected,int toBeSearch, int searchingArray[]){
		this.expected = expected;
		this.toBeSearch = toBeSearch;
		this.searchingArray = searchingArray;
	}
	@Test
	public void testLinearSearch() {
		int actual = linearSearch.search(toBeSearch, searchingArray);
		assertEquals(expected,actual);
	}
	@Test
	public void testBinarySearch() {
		int actual = binarySearch.search(toBeSearch, searchingArray);
		assertEquals(expected,actual);
	}

}
