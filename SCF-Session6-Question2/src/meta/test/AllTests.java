/*
* This class is suit class to run all test cases
* @author ABHISHEK BISHNOI
* @version 1.0
* @since 22-July-2019
*/
package meta.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PolyTest.class, PolyTestAddMult.class })
public class AllTests {

}
