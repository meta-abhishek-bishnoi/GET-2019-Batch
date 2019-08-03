/**
 * @author Abhishek Bishnoi
 * @since Aug 3, 2019
 */
package meta.test;

import static org.junit.Assert.*;

import org.junit.Test;

import meta.utility.PQueue;

public class TetsCases {

	@Test
	public void InsertTest_HappyFlow() {
		PQueue queue = new PQueue(3);
		assertTrue(queue.insert(4));
	}
	
	@Test(expected = AssertionError.class)
	public void InsertTest_Exception_WhenQueueFull() {
		PQueue queue = new PQueue(1);
		assertTrue(queue.insert(8));
		assertTrue(queue.insert(12));
	}

}
