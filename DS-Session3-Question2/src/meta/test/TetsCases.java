/**
 * @author Abhishek Bishnoi
 * @since Aug 3, 2019
 * This is Test Class For Queue Opeartions
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
	
	@Test(expected = AssertionError.class)
	public void Queue_Exception_SizeNegative(){
		PQueue queue = new PQueue(-1);
	}
	
	@Test
	public void PollTest_HappyFlow(){
		PQueue queue = new PQueue(3);
		queue.insert(4);
		queue.insert(7);
		queue.insert(5);
		assertEquals(7, queue.poll());
		assertEquals(5, queue.poll());
	}
	
	@Test(expected = AssertionError.class)
	public void PollTest_Exception_QueueIsEmpty(){
		PQueue queue = new PQueue(3);
		queue.insert(4);
		queue.insert(7);
		assertEquals(7, queue.poll());
		assertEquals(5, queue.poll());
		queue.poll();
	}
	
	@Test
	public void PeekTest_HappyFlow(){
		PQueue queue = new PQueue(3);
		queue.insert(4);
		queue.insert(7);
		queue.insert(5);
		assertEquals(7, queue.peek());
		queue.poll();
		assertEquals(5, queue.poll());
	}
	
	@Test(expected = AssertionError.class)
	public void PeekTest_Exception_QueueIsEmpty(){
		PQueue queue = new PQueue(3);
		queue.insert(4);
		queue.insert(7);
		assertEquals(7, queue.poll());
		assertEquals(5, queue.poll());
		queue.peek();
	}

	@Test
	public void RemoveTest_HappyFlow(){
		PQueue queue = new PQueue(3);
		queue.insert(4);
		queue.insert(7);
		queue.insert(5);
		assertTrue(queue.remove(4));
		assertTrue(!(queue.remove(99)));
	}
	
	@Test(expected = AssertionError.class)
	public void RemoveTest_Exception_QueueIsEmpty(){
		PQueue queue = new PQueue(3);
		queue.insert(4);
		queue.insert(7);
		assertEquals(7, queue.poll());
		assertEquals(5, queue.poll());
		queue.remove(4);
	}
}
