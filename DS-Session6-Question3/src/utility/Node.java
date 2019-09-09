/*
 * Represents node in the linked list.
 */
package utility;
public class Node{
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return value == node.value && o instanceof Node;
	}
	
	@Override
	public int hashCode() {
		return value;
	}
}