/**
 * @author Abhishek Bishnoi
 * This class contains test cases for graph implementation problem
 */
package test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utility.Edge;
import utility.Service;

public class TestCase {
	Service graph;
	List<Integer> listOfReachable;
	List<Edge> list;

	@Before
	public void iniTialize() {
		graph = new Service(4);
	}

	public int[] listToArrayForTest(List<Edge> list) {
		int array[] = new int[list.size()];
		int i = 0;
		for (Edge edgeList : list) {
			array[i] = edgeList.getWeight();
			i++;
		}

		return array;
	}

	@Test
	public void isConnectedTest() {
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 9);
		assertEquals(true, graph.isConnected());
	}

	@Test
	public void isConnectedNegativeTest() {
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 5);
		graph.addEdge(3, 3, 6);
		graph.addEdge(2, 2, 9);
		graph.addEdge(1, 1, 4);
		assertEquals(false, graph.isConnected());
	}

	@Test
	public void reachableTest() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);
		Integer []listOfReachable = graph.reachable(0);
		assertArrayEquals(new Integer[] {0, 1, 2,3}, (listOfReachable));
	}

	@Test
	public void minimumSpanningTreeTest() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		list = graph.minimumSpanningTree();
		assertArrayEquals(new int[] {1,2,3}, this.listToArrayForTest(list));
	}

	@Test
	public void shortestPathTest() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);
		int shortestPathWeight = graph.shortestPath(0, 2);
		assertEquals(5, shortestPathWeight);
	}
}
