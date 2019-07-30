/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 */
package utility;

public class Variable {
	public char variable;
	public int power;
	Variable next;
	/**
	 * 
	 * @param variable
	 * @param power
	 */
	public Variable(char variable, int power){
		this.variable = variable;
		this.power = power;
	}
	public String toVarString() {
		String varString;
		if(power==0){
			varString = "";
		}else if(power==1){
			varString = "("+variable+")";
		}else{
			varString = "("+variable+"^"+power+")";
		}
		return varString;
	}
	public int getPower(){
		return this.power;
	}
}
