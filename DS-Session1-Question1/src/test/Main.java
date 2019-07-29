package test;

import utility.LinkedList;
import utility.Node;

public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println("Adding 5 to LinkedList : "+list.add(5));
		System.out.println("Adding 7 to LinkedList : "+list.add(7));
		System.out.println("Adding 5 to LinkedList : "+list.add(12));
		System.out.println("Adding 7 to LinkedList : "+list.add(17));
		System.out.println("Adding 5 to LinkedList : "+list.add(77));
		System.out.println("Adding 7 to LinkedList : "+list.add(79));
		System.out.println("Adding 5 to LinkedList : "+list.add(62));
		System.out.println("Adding 7 to LinkedList : "+list.add(57));
		System.out.println("Linked List is : "+list.toString());
		list.rotateSubList(2, 5, 2);
		System.out.println("Rotate Linked List is : "+list.toString());
		System.out.println("Done");
	}
}
