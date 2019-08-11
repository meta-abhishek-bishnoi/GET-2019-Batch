/**
 * This Class Contains All utility methods to provide functionality 
 * as per question's requirement this is part of question 2
 * @author Abhishek Bishnoi
 */
package utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Service implements Graph {
	private int numberOfVertices;
	private Vertex vertices[];
	private LinkedList<Edge> edgeList;

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public LinkedList<Edge> getEdgeList() {
		return edgeList;
	}

	public Service(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		vertices = new Vertex[numberOfVertices];
		edgeList = new LinkedList<Edge>();

		for(int i=0;i<numberOfVertices;i++){
			vertices[i]=new Vertex();
		}
	}

	/**
	 * Function to add edges in graph  
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination,int weight) {
		edgeList.add(new Edge(source, destination, weight));
		this.vertices[source].addNeighbour(destination, weight);
		this.vertices[destination].addNeighbour(source, weight);
	}

	/**
	 * Finds if graph is connected
	 * @param this graph
	 * @return true or false accordingly 
	 */
	@Override
	public boolean isConnected() {
		if(this.numberOfVertices<=0){
			return false;
		}

		return this.dfs(0).size() == this.getNumberOfVertices();
	}

	/**
	 * Finds the list of reachable vertex
	 * @param vertex
	 * @return reachableNode
	 */
	@Override
	public Integer[] reachable(int vertex) {
		Set<Integer> visitedVertex = this.dfs(vertex);
		Integer[] reachableNode = visitedVertex.toArray(new Integer[0]);
		Arrays.sort(reachableNode);
		return reachableNode;
	}

	/**
	 * Finds minimum Spanning tree
	 * @return Edges of minimum Spanning Tree
	 */
	@Override
	public List<Edge> minimumSpanningTree() {
		try{
			int index = 0;
			List<Edge> minimumSpanningTreeEdges = new ArrayList<Edge>();
			Collections.sort(this.edgeList, Edge.sortByWeight);
			HashMap<Integer, Integer> parentVertices = new HashMap<Integer, Integer>();

			for(int i=0;i<this.numberOfVertices;i++) {
				parentVertices.put(i, i);
			}

			for(Edge edge : this.getEdgeList()) {
				if(index>this.getNumberOfVertices()-1)
				{
					break;
				}
				else if(!isCycle(parentVertices,edge.getVertex1(),edge.getVertex2())) {
					minimumSpanningTreeEdges.add(edge);			
				}
			}

			return minimumSpanningTreeEdges;
		}catch(Exception e){
			System.out .println(e);
			return null;
		}
	}

	/**
	 * Find shortest path distance between two vertex
	 * @param source vertex
	 * @param destination vertex
	 * @return Shortest distance between source and destination
	 */
	public int shortestPath(int source, int destination) {
		int dist[] = this.dijkstra(source);
		return dist[destination];
	}

	/**
	 * traversing graph in dfs manner
	 * @param source, the source vertex of the graph 
	 * @return visitedVertex,set of visited vertex
	 */
	private Set<Integer> dfs(int source){
		try{
			Stack<Integer> dfsStack = new Stack<Integer>();
			Set<Integer> visitedVertex = new HashSet<Integer>();
			dfsStack.push(source);	
			while (!dfsStack.isEmpty()) {
				int vertex = dfsStack.pop();
				if(visitedVertex.contains(vertex)) {
					continue;
				}

				visitedVertex.add(vertex);
				for(Neighbour neighbour : this.vertices[vertex].getNeighbourList()) {
					dfsStack.push(neighbour.getNeighbourVertex());
				}
			}

			return visitedVertex;
		}catch(Exception e){
			System.out .println(e);
			return null;
		}
	}

	/**
	 * checks if Cycle exists in graph
	 * @param parentVertices,hashMap which contain key as vertex number and value as their parent
	 * @param v1,vertex one
	 * @param v2, vertex second
	 * @return "true" if this edge creating cycle else "false"
	 */
	private boolean isCycle(HashMap<Integer, Integer> parentVertices,int v1,int v2) {
		try{
			int parent1 = parent(parentVertices,v1);
			int parent2 = parent(parentVertices,v2);
			if(parent1 == parent2) {
				return true;
			}

			parentVertices.put(parent1, parent2);
			return false;
		}catch(Exception e){
			System.out .println(e);
			return false;
		}
	}

	/**
	 * Finds parent of given vertex
	 * @param parentVertices
	 * @param vertex, of which  this method is finding parent
	 * @return parent of the given vertex
	 */
	private int parent(HashMap<Integer, Integer> parentVertices,int vertex) {
		try{
			while(parentVertices.get(vertex)!=vertex) {	
				vertex = parentVertices.get(vertex);
			}

			return vertex;
		}catch(Exception e){
			System.out .println(e);
			return 0;
		}
	}

	/**
	 * Dijkstra algorithm 
	 * source geeks
	 * @param source vertex
	 * @return Distance of all vertices from source
	 */
	private int[] dijkstra(int source) {
		try{
			int dist[] = new int[this.getNumberOfVertices()];
			for(int i=0; i<this.getNumberOfVertices(); i++) {
				dist[i] = Integer.MAX_VALUE;
			}

			Set<Integer> visited = new HashSet<Integer>();
			dist[source] = 0;
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>(this.getNumberOfVertices(), Pair.sortPairByWeight);
			pq.add(new Pair(0, source));
			while(!pq.isEmpty()) {
				Pair pair = pq.peek();
				pq.remove();
				if(visited.contains(pair.getVertex())) {
					continue;
				}

				visited.add(pair.getVertex());
				for(Neighbour neighbour : this.vertices[pair.getVertex()].getNeighbourList()) {
					if(dist[neighbour.getNeighbourVertex()] > dist[pair.getVertex()] + neighbour.getEdgeWeight()) {
						dist[neighbour.getNeighbourVertex()] = dist[pair.getVertex()] + neighbour.getEdgeWeight();
						pq.add(new Pair(dist[neighbour.getNeighbourVertex()], neighbour.getNeighbourVertex()));
					}
				}
			}

			return dist;
		}catch(Exception e){
			System.out .println(e);
			return null;
		}
	}
}
