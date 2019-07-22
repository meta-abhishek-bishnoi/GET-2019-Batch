package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import meta.utility.IntSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntSetIsSubSetTest {

	 @Parameters
	 public static Collection<Object[]> data() {
		 int set[];
		 int subset[];
		return Arrays.asList(new Object[][] {
				 {set = SetTestData.getSet(50), subset = SetTestData.getSubSet(set,10), true},
				 {set = SetTestData.getSet(220), subset = SetTestData.getSubSet(set,100), true},
				 {set = SetTestData.getSet(450), subset = SetTestData.getSubSet(set,99), true},
				 {set = SetTestData.getSet(750), subset = SetTestData.getSubSet(set,750), true},
				 {set = SetTestData.getSet(50), subset = SetTestData.getSubSet(set,100), true},
				 {set = SetTestData.getSet(500), subset = SetTestData.getSubSet(set,1449), true},
				 {set = SetTestData.getSet(1), subset = SetTestData.getSubSet(set,1), true}
				 });
	    }
	    
	 private int set[];
	 private int subset[];
	 private boolean expected;
	 /*
	  * Constructor Value for each testCase
	  */
	 public IntSetIsSubSetTest(int set[], int subset[], boolean expected){
		 this.set = set;
		 this.subset = subset;
		 this.expected = expected;
	 }
	@Test
	public void test() {
		 IntSet intSet = new IntSet(set);
		 boolean actual = intSet.isSubSet(new IntSet(subset));
		 assertEquals(expected,actual);
	}

}
