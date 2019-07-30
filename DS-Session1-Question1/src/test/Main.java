package test;

import utility.LinkedList;
import utility.Node;

public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println("Adding LinkedList : "+list.add(new Node(5)));
		System.out.println("Adding LinkedList : "+list.add(new Node(7)));
		System.out.println("Adding LinkedList : "+list.add(new Node(12)));
		System.out.println("Adding LinkedList : "+list.add(new Node(17)));
		System.out.println("Adding LinkedList : "+list.add(new Node(77)));
		System.out.println("Adding LinkedList : "+list.add(new Node(79)));
		System.out.println("Adding LinkedList : "+list.add(new Node(62)));
		System.out.println("Adding LinkedList : "+list.add(new Node(57)));
		System.out.println("Linked List is : "+list.toString());
		list.rotateSubList(2, 5, 2);
		System.out.println("Rotate Linked List is : "+list.toString());
		System.out.println("Done");
		int arr[] = list.toArray();
		for(int val : arr){
			System.out.print(val+" ");
		}
	}
}
