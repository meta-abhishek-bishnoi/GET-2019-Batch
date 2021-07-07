/**
 * This Class contains Testcases of CompundMolicular Mass
 * As Per Assumption This Test Cases is For Single Symbolic Atoms till Atom Number 19
 * @author Abhishek Bishnoi
 * @since Aug 4, 2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import meta.utility.CompoundMolicularMass;

@RunWith(Parameterized.class)
public class CompoundMolicularMassTest {
	CompoundMolicularMass mass;
	@Before
	public void start(){
		mass = new CompoundMolicularMass();
	}
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{46, "C(OH)2"},
			{80, "S2O"},
			{34,"H2O2"},
			{98,"H2(SO4)"},
			{28,"N2"},
			{44,"N2O"},
			{92,"K2N"}
	});
	}
	private int expected;
	private String compound;
	public CompoundMolicularMassTest(int expected, String compound){
		this.expected = expected;
		this.compound = compound;
	}
	@Test
	public void test() {
		int actual = mass.calculateMass(compound);
		assertEquals(expected,actual);
	}

}
