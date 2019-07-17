package meta.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClumpsTest.class, FixXYTest.class, MirrorSectionTest.class,
		SplitArrayTest.class })
public class AllTests {

}
