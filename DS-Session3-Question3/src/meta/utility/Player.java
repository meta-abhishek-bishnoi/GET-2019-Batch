/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This Class Defines Class Structure 
 */
package meta.utility;

public class Player {
	final int playerId;
	int balls;
	public Player( int playerId, int balls ){
		this.playerId = playerId;
		this.balls = balls;
	}
	public int getPlayerId() {
		return playerId;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	/**
	 * @return when bowler balls
	 */
	public boolean bowling(){
		if(balls<=0){
			return false;
		}
		balls--;
		return true;
	}
}
