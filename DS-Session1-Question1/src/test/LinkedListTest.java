/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 * This Class Contains Test cases
 */
package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import utility.LinkedList;
import utility.Node;

public class LinkedListTest {

	@Test
	public void addNode_HappyFlow() {
		LinkedList list = new LinkedList();
		assertTrue(list.add(new Node(5)));
		assertTrue(list.add(new Node(14)));
	}
	
	@Test(expected = AssertionError.class)
	public void addNode_Exception_NodeIsNull(){
		LinkedList list = new LinkedList();
		assertTrue(list.add(null));
	}
	
	@Test
	public void rotateSublist_HappyFlow(){
		LinkedList list = new LinkedList();
		list.add(new Node(8));
		list.add(new Node(5));
		list.add(new Node(22));
		list.add(new Node(47));
		list.add(new Node(57));
		list.add(new Node(74));
		list.add(new Node(99));
		list.add(new Node(23));
		int expected[] = {8, 57, 5, 22, 47, 74, 99, 23};
		list.rotateSubList(2, 5, 13);
		assertArrayEquals(expected, list.toArray());
	}
	
	@Test(expected = AssertionError.class)
	public void rotate_Exception_InvalidStart(){
		LinkedList list = new LinkedList();
		list.add(new Node(8));
		list.add(new Node(5));
		list.add(new Node(22));
		list.rotateSubList(0, 4, 2);
	}
	
	@Test(expected = AssertionError.class)
	public void rotate_Exception_InvalidEnd(){
		LinkedList list = new LinkedList();
		list.add(new Node(8));
		list.add(new Node(5));
		list.add(new Node(22));
		list.rotateSubList(0, Integer.MAX_VALUE, 2);
	}

	@Test(expected = AssertionError.class)
	public void rotate_Exception_WhenEnd_IsSmallThen_StartIndex(){
		LinkedList list = new LinkedList();
		list.add(new Node(8));
		list.add(new Node(5));
		list.add(new Node(22));
		list.rotateSubList(5, 2, 2);
	}
}
