package utility;
/*
 * Represents Vertex
 */
import java.util.LinkedList;
import java.util.List;

public class Vertex {
	private List<Neighbour> neighbours = new LinkedList<Neighbour>();

	Vertex(){}

	/**
	 * Add neighbour vertex with their edge weight
	 * @param vertex neighbour 
	 * @param edgeWeight neighbour vertex
	 */
	public void addNeighbour(int vertex, int edgeWeight) {
		Neighbour neighbour = new Neighbour(vertex, edgeWeight);
		this.neighbours.add(neighbour);
	}

	/**
	 * Gets list of neighbour of vertex
	 * @return List of neighbour
	 */
	public List<Neighbour> getNeighbourList(){
		return this.neighbours;
	}
}
