package meta.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ failTestCases.class, MatrixAddTest.class, MatrixMultTest.class,
		MatrixOperationTest.class })
public class AllTests {

}
