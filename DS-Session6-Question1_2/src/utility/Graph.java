/**
 * This is Interface Of Graph 
 * which is part of first question 
 * which defines to create an interface of Graph
 * supporting following services 
 */
package utility;
import java.util.List;

public interface Graph {
	boolean isConnected();
	Integer[] reachable(int node);
	List<Edge> minimumSpanningTree();
	int shortestPath(int vertex1, int vertex2);
}
