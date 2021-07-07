/*
* This class Contains Test cases for LinearSearch
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 17-July-2019
*/
package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import meta.utility.LinearSearch;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SearchTestLinear {
	private static LinearSearch linearSearch;
	@Before
	public void start(){
		linearSearch = new LinearSearch();
	}
	/*
	 *  Testing function with @Parameters 
	 * 	So these test cases will executes one by one(By Iteration)
	 * 	so here we don't require to write too much test cases
	 * 	in test cases they contains in order of
	 *  expected result value, starting index, last index , searching element and array  
	 *  This testcase is common for binary and linear test 
	 *	so input array shoud be sorted in incresing order
	 */
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{6, 9, new int[]{ 0, 4, 5, 6, 7, 7, 9 }},
				{2, 9, new int[]{ 3, 7, 9, 14, 24, 27, 35, 44, 78 }},
				{4, 12, new int[]{4, 11, 8, 11, 12, 12}},
				{0, 1, new int []{1, 1, 1, 1, 1}},
				{10, 17, new int[]{0, 11, 27, 34, 45, 16, 74, 99, 9, 24, 17}}
		});
	}
	/*
	 *  variable initialization
	 */
	private int expected;
	private int toBeSearch;
	private int searchingArray[];
	/*
	* This is constructor
	*/
	public SearchTestLinear(int expected,int toBeSearch, int searchingArray[]){
		this.expected = expected;
		this.toBeSearch = toBeSearch;
		this.searchingArray = searchingArray;
	}
	/*
	* This is Test Function for Linear Search
	*/
	@Test
	public void testLinearSearch() {
		int actual = linearSearch.search(toBeSearch, searchingArray);
		assertEquals(expected,actual);
	}

}
