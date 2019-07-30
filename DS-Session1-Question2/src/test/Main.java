package test;

import utility.LinkedList;
import utility.Node;

public class Main {
	public static void main(String[] args) {
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
		//list.add(loopNode);
		System.out.println("contains loop :"+list.isLoop());
		
	}
}
