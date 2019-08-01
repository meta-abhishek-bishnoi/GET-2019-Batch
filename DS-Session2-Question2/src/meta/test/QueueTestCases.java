/**
 * @author Abhishek Bishnoi
 * @since Aug 1, 2019
 * This Class Contains Test Cases of Circular Queue
 */

package meta.test;

import static org.junit.Assert.*;
import meta.utility.CircularQueue;

import org.junit.AfterClass;
import org.junit.Test;

public class QueueTestCases {

	@Test
	public void addingElement_HappyFlow() {
		CircularQueue queue = new CircularQueue(5);
		assertTrue(queue.add(1));
		assertTrue(queue.add(4));
		assertTrue(queue.add(7));
	}
	
	@Test(expected = AssertionError.class)
	public void addingElement_Exception_QueueIsFull(){
		CircularQueue queue = new CircularQueue(2);
		assertTrue(queue.add(1));
		assertTrue(queue.add(4));
		assertTrue(queue.add(7));
	}

	@Test
	public void deletingElement_HappyFlow(){
		CircularQueue queue = new CircularQueue(2);
		queue.add(1);
		queue.add(4);
		assertTrue(queue.delete());
		assertTrue(queue.delete());
	}
	
	@Test(expected = AssertionError.class)
	public void deletingElement_Exception_QueueIsEmplty(){
		CircularQueue queue = new CircularQueue(2);
		queue.add(1);
		queue.add(4);
		assertTrue(queue.delete());
		assertTrue(queue.delete());
		assertTrue(queue.delete());
	}
}
