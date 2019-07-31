/**
 * @author Abhishek Bishnoi
 * @since Jul 31, 2019
 * This class Contains Test Cases Of Poly Class
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.Poly;
import utility.PolyVar;
import utility.Variable;

public class polyTest {

	@Test
	public void addvariable_HappyFlow(){
		PolyVar polyVar = new PolyVar(12,'+');
		assertTrue(polyVar.addVariable(new Variable('p',3)));
	}
	@Test(expected = AssertionError.class)
	public void addVariable_Exception_nullVariable(){
		PolyVar polyVar = new PolyVar(12,'+');
		assertTrue(polyVar.addVariable(null));
	}
	@Test
	public void addPolyVar_HappyFlow(){
		Poly poly = new Poly();
		PolyVar polyVar = new PolyVar(12,'+');
		polyVar.addVariable(new Variable('p',3));
		assertTrue(poly.addPoly(polyVar));
	}
	@Test(expected = AssertionError.class)
	public void addPolyVar_Exception_nullPolyVar(){
		Poly poly = new Poly();
		PolyVar polyVar = null;
		assertTrue(poly.addPoly(polyVar));
	}
	
	@Test
	public void PolyVar_String_OneAndTwo_Test(){
		Poly poly = new Poly();
		PolyVar polyOne = DataPolyVar.getPolyVarOne();
		PolyVar polyTwo = DataPolyVar.getPolyVarTwo();
		poly.addPoly(polyOne);
		poly.addPoly(polyTwo);
		String expected = DataPolyVar.getPolyOneString()+DataPolyVar.getPolyTwoString();
		assertEquals(expected,poly.toPolyString());
	}
	@Test
	public void PolyVar_Degree_OneAndTwo_Test(){
		Poly poly = new Poly();
		PolyVar polyOne = DataPolyVar.getPolyVarOne();
		PolyVar polyTwo = DataPolyVar.getPolyVarTwo();
		poly.addPoly(polyOne);
		poly.addPoly(polyTwo);
		int[] degree = {DataPolyVar.getPolyOneDegree(), DataPolyVar.getPolyTwoDegree()};
		int expected = DataPolyVar.getDegree(degree);
		assertEquals(expected,poly.degree());
	}
	
	@Test
	public void PolyVar_String_ThreeAndFour_Test(){
		Poly poly = new Poly();
		PolyVar polyOne = DataPolyVar.getPolyVarThree();
		PolyVar polyTwo = DataPolyVar.getPolyVarFour();
		poly.addPoly(polyOne);
		poly.addPoly(polyTwo);
		String expected = DataPolyVar.getPolyThreeString()+DataPolyVar.getPolyFourString();
		assertEquals(expected,poly.toPolyString());
	}
	@Test
	public void PolyVar_Degree_ThreeAndFour_Test(){
		Poly poly = new Poly();
		PolyVar polyOne = DataPolyVar.getPolyVarThree();
		PolyVar polyTwo = DataPolyVar.getPolyVarFour();
		poly.addPoly(polyOne);
		poly.addPoly(polyTwo);
		int[] degree = {DataPolyVar.getPolyThreeDegree(), DataPolyVar.getPolyFourDegree()};
		int expected = DataPolyVar.getDegree(degree);
		assertEquals(expected,poly.degree());
	}
	
	@Test
	public void PolyVar_String_All_Test(){
		Poly poly = new Poly();
		PolyVar polyOne = DataPolyVar.getPolyVarOne();
		PolyVar polyTwo = DataPolyVar.getPolyVarTwo();
		PolyVar polyThree = DataPolyVar.getPolyVarThree();
		PolyVar polyFour = DataPolyVar.getPolyVarFour();
		poly.addPoly(polyOne);
		poly.addPoly(polyTwo);
		poly.addPoly(polyThree);
		poly.addPoly(polyFour);
		String expected = DataPolyVar.getPolyOneString()+DataPolyVar.getPolyTwoString();
		expected += DataPolyVar.getPolyThreeString()+DataPolyVar.getPolyFourString();
		assertEquals(expected,poly.toPolyString());
	}
}
