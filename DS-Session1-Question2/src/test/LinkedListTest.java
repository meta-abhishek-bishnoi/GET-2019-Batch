/**
 * @author Abhishek Bishnoi
 * @slowScale Jul 29, 2019
 * This is Test Class To check Loop in the teste Cases
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.LinkedList;
import utility.Node;

public class LinkedListTest {
	@Test
	public void addNode_HappyFlow(){
		LinkedList list = new LinkedList();
		Node node = new Node(5);
		assertTrue(list.add(node));
	}

	@Test
	public void isLoop_HappyFlowOne() {
		LinkedList list = new LinkedList();
		Node loopNode = new Node(7);
		Node node = new Node(5);
		list.add(node);
		node = new Node(1);
		list.add(node);
		list.add(loopNode);
		node = new Node(10);
		list.add(node);
		node = new Node(12);
		list.add(node);
		list.add(loopNode);
		assertTrue(list.isLoop());
	}
	@Test
	public void isLoop_HappyFlowTwo() {
		LinkedList list = new LinkedList();
		Node node = new Node(5);
		list.add(node);
		node = new Node(1);
		list.add(node);
		node = new Node(10);
		list.add(node);
		node = new Node(12);
		list.add(node);
		assertTrue(!list.isLoop()); // List doesn't contains looop
	}
	@Test(expected = AssertionError.class)
	public void isLoop_whenNodeIsNull(){
		LinkedList list = new LinkedList();
		Node node = null;
		list.add(node);
		assertTrue(list.isLoop());
	}

}
