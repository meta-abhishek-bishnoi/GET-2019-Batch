/**
 * @author Abhishek Bishnoi
 * This class contains test cases for sorting linked list using quick sort
 */
package test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import utility.Node;
import utility.QuickSortLinkedList;

public class TestCase {

	@Test
	public void testQuickSort_case1() {
		QuickSortLinkedList linkedList =  new QuickSortLinkedList();
		int[] expected = {3,4,7,10,20,40};
		Node node1 = new Node(40);
		Node node2 = new Node(3);
		Node node3 = new Node(10);
		Node node4 = new Node(20);
		Node node5 = new Node(7);
		Node node6 = new Node(4);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		linkedList.setStart(node1);

		Node result = linkedList.quickSort(node1, node6);
		List<Integer>actual = linkedList.getList(result);
		for(int i=0 ; i< actual.size(); i++){
			assertEquals(expected[i],actual.get(i).intValue());
		}
	}
	
}