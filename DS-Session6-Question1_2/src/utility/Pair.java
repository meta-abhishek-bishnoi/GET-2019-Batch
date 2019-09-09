/**
 * @author Abhishek Bishnoi
 * This class implements Comprator class to compare Pair class
 */
package utility;
import java.util.Comparator;

public class Pair implements Comparator<Pair>{

	private int weight;
	private int vertex;

	/**
	 * Pair constructor is used to set Pair variables
	 * @param weight
	 * @param vertex
	 */
	Pair(int weight, int vertex){
		this.weight = weight;
		this.vertex = vertex;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getVertex() {
		return  this.vertex;
	}

	/**
	 * This Override method is define to sort Values By Pair Weight.
	 * This Part is copied from stackoverflow
	 */
	public static final Comparator<Pair> sortPairByWeight = new Comparator<Pair>() {
		@Override
		public int compare(Pair pair1, Pair pair2) {
			return pair1.getWeight() - pair2.getWeight();
		}

	};

	/**
	 * This Method Doesn't differentiate two pairs
	 */
	@Override
	public int compare(Pair o1, Pair o2) {
		return 0;
	}
}
