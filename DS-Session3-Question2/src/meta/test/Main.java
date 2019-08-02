package meta.test;

import meta.utility.PQueue;

public class Main {
	public static void main(String[] args) {
		PQueue priority = new PQueue(5);
		priority.insert(4);
		priority.insert(2);
		priority.insert(1);
		priority.insert(6);
		priority.insert(5);
		System.out.println(priority.poll());
		System.out.println(priority.poll());
		System.out.println(priority.poll());
		System.out.println("Size "+priority.size());
		System.out.println(priority.poll());
		
	}
}
