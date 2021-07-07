/**
 * This Class Only works For single Symbol Components till atomic no 19 elements
 * @author Abhishek Bishnoi
 * @since Aug 4, 2019
 */
package meta.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CompoundMolicularMass {
	LoadElements load = new LoadElements();
	Map<Character,Integer> compunds = load.loadElements();
	Stack<Integer> stack = new Stack<Integer>();
	/**
	 * Calculates mass of given compound Using Stack and Map Collection
	 * @param compound is the organic compound
	 * @return mass of the compound
	 * Assumption Compunds's Symbols are Single Character Symbol till Atomic Number 19.
	 */
	public int calculateMass(String compound){
		if(compunds==null){
			System.out.println("Map Is Null");
		}
		try{
			int massOfCompound = 0;

			for(int i = 0 ; i < compound.length() ; i++){
				int mass = 0;
				int digit;
				if(compound.charAt(i) == ')'){
					int s = stack.pop();
					
					while(s != 0){
						mass += s;
						s = stack.pop();
					}

					stack.push(mass);
				}
				else if(Character.isDigit(compound.charAt(i))){
					digit = Character.getNumericValue(compound.charAt(i));
					stack.push((stack.pop())*digit);
				}else{
					stack.push(compunds.get(compound.charAt(i)));     
				}
			}

			while(!stack.empty()){
				massOfCompound += stack.pop();
			}

			return massOfCompound;
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
}
