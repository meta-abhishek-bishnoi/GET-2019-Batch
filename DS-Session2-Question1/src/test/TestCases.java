package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import utility.Evalution;

public class TestCases {

	@Test
	public void evalute_HappyFlow() {
		Evalution eva = new Evalution();
		assertEquals(22,eva.evalute("( 10 + 2 * 6 )"));
		assertEquals(48,eva.evalute("( 8 * ( 5 + 1 ) )"));
		assertEquals(41,eva.evalute("( 8 *  5 + 1 )"));
		assertEquals(0,eva.evalute(" 8 < 5 * ( 2 + 1 )"));
		assertEquals(1,eva.evalute(" 8 > 5 * ( 2 + 1 )"));
	}
	@Test (expected = AssertionError.class)
	public void failsTest_Exception_DivideByZero(){
		Evalution eva = new Evalution();
		assertEquals(22,eva.evalute("( 10 + 2 * 6 / 0 )"));
	}

}
