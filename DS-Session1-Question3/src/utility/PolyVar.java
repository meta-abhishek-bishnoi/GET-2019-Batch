/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 */
package utility;

public class PolyVar {
	int coeficiente;
	char sign;
	PolyVar next;
	Variable headVariable;
	Variable lastVariable;
	public PolyVar(int coeficiente, char sign){
		this.coeficiente = coeficiente;
		this.sign = sign;
	}
	/**
	 * 
	 * @param addVariable
	 * @return
	 */
	public boolean addVariable(Variable addVariable){
		try{
			if(lastVariable==null){
				headVariable=addVariable;
				lastVariable=addVariable;
			}else{
				lastVariable.next = addVariable;
				lastVariable = addVariable;
			}
			return true;
		}catch(Exception exception){
			throw new AssertionError("Invalid Input Exception");
		}
	}
	public String toPolyString(int count) {
		Variable currentVar = headVariable;
		StringBuffer resultString = new StringBuffer();
		if( count==0 && sign == '+' ){
			resultString.append(""+coeficiente);
		}else{
			resultString.append(sign+""+coeficiente);
		}
		while(currentVar!=null){
			String current = currentVar.toVarString();
			resultString.append(current);
			currentVar = currentVar.next;
		}
		return resultString.toString();
	}
	public int getDegree() {
		int degree=0;
		Variable currentVar = headVariable;
		while(currentVar!=null){
			degree += currentVar.getPower();
			currentVar = currentVar.next;
		}
		return degree;
	}
}
