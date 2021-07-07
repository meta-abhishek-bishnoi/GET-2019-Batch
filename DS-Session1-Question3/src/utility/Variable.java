/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 * This Class Contains Structure Of Variable
 */
package utility;

public class Variable {
	public char variable;
	public int power;
	Variable next;
	/**
	 * Constructor to add values
	 * @param variable
	 * @param power
	 */
	public Variable(char variable, int power){
		this.variable = variable;
		this.power = power;
	}
	/**
	 * @return variable in string representation form
	 */
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
	/**
	 * 
	 * @return return power of variable
	 */
	public int getPower(){
		return this.power;
	}
}
