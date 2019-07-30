/**
 * @author Abhishek Bishnoi
 * @since 
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
	
	@Ignore
	@Test
	public void rotateSublist_HappyFlow(){
		
	}
	
	@Test(expected = AssertionError.class)
	public void rotate_Exception_InvalidStart(){
		LinkedList list = new LinkedList();
		list.add(new Node(5));
		list.add(new Node(14));
		list.add(new Node(52));
		list.add(new Node(84));
		list.add(new Node(17));
		list.add(new Node(51));
		list.rotateSubList(0, 4, 2);
	}

}
