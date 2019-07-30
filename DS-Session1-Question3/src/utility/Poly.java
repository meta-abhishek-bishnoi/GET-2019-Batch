/**
 * @author Abhishek Bishnoi
 * @since Jul 30, 2019
 */
package utility;
public class Poly {
	PolyVar headPolyVar=null;
	PolyVar lastPolyVar=null;
	/**
	 * @param polyVar
	 * @return
	 */
	public boolean addPoly(PolyVar polyVar){
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
	 * @return
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
