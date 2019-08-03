/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This is Service Class of For Arranging Bowling Sequence
 */
package meta.utility;

import java.util.ArrayList;
import java.util.List;

public class Service {
	/**
	 * 
	 * @param size Size Of Heap
	 * @param players List Of Players
	 * @return List of Player Bowling Sequence
	 */
	public static List<Integer> getBowlerSequence(int size, List<Player> players){
		List<Integer> playersSequence = new ArrayList<Integer>();
		MaxHeap maxHeap = new MaxHeap(size);
		if(players==null){
			throw new AssertionError("List Of Players Can't Be Null");
		}
		/**
		 * Adding Players Into Heap 
		 */
		for(Player player : players){
			if(player==null){
				throw new AssertionError("List Of Players Can't Be Null");
			}
			maxHeap.insert(player);
		}
		// getting top element of heap
		Player player = maxHeap.extractMax();
		/**
		 * getting remaining players
		 */
		while(player.getPlayerId()!=0){
			playersSequence.add(player.getPlayerId());
			Player[] remaining = maxHeap.getHeap();
			maxHeap = new MaxHeap(size);
			/**
			 * adding players again into heap
			 */
			for(Player p : remaining){
				if(p.getPlayerId()!=0 && p.getPlayerId()!=Integer.MAX_VALUE){
					maxHeap.insert(p);
				}
			}
			/**
			 * is player throw a bowl then returns true
			 */
			boolean result = player.bowling();
			// is bowler has bowling quota insert again to heap
			if(result && player.getBalls() != 0){
				maxHeap.insert(player);
			}
			player = maxHeap.extractMax();
		}
		return playersSequence;
	}
}
