package meta.utility;

import java.util.ArrayList;
import java.util.List;

public class Service {
	public List<Integer> getPlayerSequence(int size, List<Player> players){
		List<Integer> playersSequence = new ArrayList<Integer>();
		MaxHeap maxHeap = new MaxHeap(size);
		for(Player player : players){
			maxHeap.insert(player);
		}
		
		Player player = maxHeap.extractMax();
		while(player.getPlayerId()!=0){
			playersSequence.add(player.getPlayerId());
			Player[] remaining = maxHeap.getHeap();
			maxHeap = new MaxHeap(3);
			for(Player p : remaining){
				if(p.getPlayerId()!=0 && p.getPlayerId()!=Integer.MAX_VALUE){
					maxHeap.insert(p);
				}
			}
			boolean result = player.bowling();
			if(result && player.getBalls() != 0){
				maxHeap.insert(player);
			}
			player = maxHeap.extractMax();
		}
		return playersSequence;
	}
}
