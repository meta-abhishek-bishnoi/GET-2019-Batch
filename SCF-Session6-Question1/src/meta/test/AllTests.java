package meta.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IntSetIsMember_SizeTest.class, IntSetIsSubSetTest.class,
		IntSetTest.class })
public class AllTests {

}
