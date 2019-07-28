/**
 * This class defines structure of Poly Conficient and Power
 * @author Abhishek Bishnoi
 */
package meta.utility;

public class Poly {

	public final int conficient;
	public final int power;
	public Poly(int conficient, int power){
		this.conficient = conficient; 
		this.power = power;
	}
	public int getConficient() {
		return conficient;
	}
	public int getPower() {
		return power;
	}
	
}
