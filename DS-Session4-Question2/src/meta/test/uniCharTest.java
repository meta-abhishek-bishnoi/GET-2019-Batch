package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import meta.utility.UniqueChar;

@RunWith(Parameterized.class)
public class uniCharTest {
	static UniqueChar unique;
	@BeforeClass
	public static void start(){
		unique = new UniqueChar();
	}
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{5,"itsAbhi"},
			{6,"Abhishek"},
			{5,"itsAbhi"},
			{4,"yatika"},
			{6,"metacube"},
			{6,"jaipur"},
			{8,"That_sMe"}
			
	});
	}
	private int expected;
	private String string;
	public uniCharTest(int expected, String string){
		this.expected = expected;
		this.string = string;
	}
	@Test
	public void TestUniqueChar() {
		int actual = unique.countUniqueCharacters(string);
		assertEquals(expected,actual);
	}

}
