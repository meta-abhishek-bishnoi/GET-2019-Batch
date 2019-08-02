package meta.utility;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(4,3));
		players.add(new Player(3,2));
		players.add(new Player(2,1));
		Service service = new Service();
		List<Integer> list = service.getPlayerSequence(players.size(), players);
		for(int id : list){
			System.out.print(id+" ");
		}
		/**
		MaxHeap maxHeap = new MaxHeap(3);
		maxHeap.insert(new Player(4,4));
		maxHeap.insert(new Player(3,1));
		maxHeap.insert(new Player(2,4));
		Player player = maxHeap.extractMax();
		while(player.getPlayerId()!=0){
			System.out.println(player.getPlayerId()+" "+player.getBalls());
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
		**/
	}
	
}
