/**
 * This test cases is for isMember & size
 * in this test case value sets and elements are changes respectively 
 * or we can say randomly but element value contains value of set
 * @author ABHISHEK BISHNOIS
 * @version 1.0
 * @since 22-July-2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;



import meta.utility.IntSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class IntSetIsMember_SizeTest {

	/*
	 * Testing function with @Parameters 
	 * So these test cases will executes one by one(By Iteration)
	 * so here we don't require to write too much test cases
	 * In this Function Values are auto generated to check test cases
	 */
	 @Parameters
	 public static Collection<Object[]> data() {
		 int data[];
		 int value;
		 int length;
		return Arrays.asList(new Object[][] {
				 {true,data = SetTestData.getSet(50), value = SetTestData.getArrayRandom(data), length = data.length},
				 {true, data = SetTestData.getSet(10), value = SetTestData.getArrayRandom(data), length = data.length},
				 {false, data = SetTestData.getSet(30), value = 99, length = data.length /* this test case can fail*/},
				 {true, data = SetTestData.getSet(215), value = SetTestData.getArrayRandom(data), length = data.length},
				 {true, data = SetTestData.getSet(500), value = SetTestData.getArrayRandom(data), length = data.length},
				 {true, data = SetTestData.getSet(100), value = SetTestData.getArrayRandom(data), length = data.length},
				 {true, data = SetTestData.getSet(199), value = SetTestData.getArrayRandom(data), length = data.length},
				 {true, data = SetTestData.getSet(1), value = SetTestData.getArrayRandom(data), length = data.length}
				 });
	    }
	    
	 private boolean result;
	 private int[] set;
	 private int value;
	 private int length;
	 /*
	  * Constructor Value for each testCase
	  */
	 public IntSetIsMember_SizeTest(boolean result, int[] set, int value, int length){
		 this.result = result;
		 this.set = set;
		 this.value = value;
		 this.length = length;
	 }
	 
	 /*
	  * test cases for isMember()
	  */
	 @Test
	 public void testIsMember(){
		 IntSet intSet = new IntSet(set);
		 boolean actual = intSet.isMember(value);
		 assertEquals(result,actual);
	 }
	 /*
	  * test cases for size()
	  */
	 @Test
	 public void testSize(){
		 IntSet intSet = new IntSet(set);
		 int actual = intSet.size();
		 assertEquals(length,actual);
	 }

}
