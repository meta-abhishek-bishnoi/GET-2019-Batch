/**
 * @author Abhishek Bishnoi
 * @since Jul 29, 2019
 * This is Structure Of Node where it contains value and reference of next node
 */
package utility;

public class Node {
	int value;
	Node next;
	public Node(int value){
		this.value = value;
		this.next = null;
	}
	public int getValue() {
		return value;
	}
}
