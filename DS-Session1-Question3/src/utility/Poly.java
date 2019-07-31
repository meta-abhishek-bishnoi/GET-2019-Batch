/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 * This Class Contains A Structure to store multivariable polinomial 
 * and also contains some methods like degree() and toString()
 */
package utility;
public class Poly {
	PolyVar headPolyVar=null;
	PolyVar lastPolyVar=null;
	/**
	 * This Function Add PolyVariable to LinkedList
	 * @param polyVar : PolyVar to add
	 * @return : true or false
	 * @exception Assertion Error When poly Var is Null
	 */
	public boolean addPoly(PolyVar polyVar){
		if(polyVar==null){
			throw new AssertionError("Invalid Input Exception");
		}
		try{
			if(lastPolyVar==null){
				headPolyVar=polyVar;
				lastPolyVar=polyVar;
			}else{
				lastPolyVar.next = polyVar;
				lastPolyVar = polyVar;
			}
			return true;
		}catch(Exception exception){
			throw new AssertionError("Invalid Input Exception");
		}
		
	}
	/**
	 * 
	 * @return : Multi variant as String 
	 */
	public String toPolyString(){
		PolyVar currentVar = headPolyVar;
		StringBuffer resultStringBuffer = new StringBuffer();
		int count=0;
		while(currentVar!=null){
			String current = currentVar.toPolyString(count++);
			resultStringBuffer.append(current);
			currentVar = currentVar.next;
		}
		return resultStringBuffer.toString();
	}
	/**
	 * 
	 * @return Degree of multi variant 
	 */
	public int degree(){
		int degree=Integer.MIN_VALUE;
		PolyVar currentVar = headPolyVar;
		while(currentVar!=null){
			int current = currentVar.getDegree();
			if(current>degree){
				degree = current;
			}
			currentVar = currentVar.next;
		}
		return degree;
	}
}
