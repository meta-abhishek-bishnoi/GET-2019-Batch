/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 */
package meta.test;

import meta.utility.CircularQueue;

public class Main {
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);
		System.out.println(queue.add(-4));
		System.out.println(queue.add(4));
		System.out.println(queue.add(11));
		System.out.println(queue.add(19));
		System.out.println(queue.add(5));
		System.out.println(queue.delete());
		System.out.println(queue.add(1));

	}

}
