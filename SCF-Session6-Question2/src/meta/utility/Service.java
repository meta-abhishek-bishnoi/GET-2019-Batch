/**
 * This is Service Class For Polynomial Class 
 * Where this class is return values as per requested service 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Service implements PolyInterface {

	/**
	 * @param poly[] polynomial function in the form of array
	 * @param int value to be calculate value
	 * @return double result in decimal format
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 * Complexity O(n)
	 */
	@Override
	public double evalute(Poly[] array, int value) {
		double result=0;
		for(Poly currentPoly: array){
			result += currentPoly.getConficient()*Math.pow(value,currentPoly.getPower());;
		}
		return result;
	}

	/**
	 * This Function Returns Degree(Largest Power) Of Polynomial Equation
	 * @param Poly[] array as a input
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 * Complexity O(n)
	 */
	@Override
	public int degree(Poly[] array) {
		int degree = Integer.MIN_VALUE;
		for(Poly currentPoly: array){
			/**
			 * updating value
			 */
			int power = currentPoly.getPower();
			if( power > degree ){
				degree = power;
			}
		}
		return degree;
	}

	/**
	 * This function return addition of two polynomial equation
	 * @param Poly[] first poly equation in array
	 * @param Poly[] second poly equation in array
	 * @return Poly[] return addition equation in array
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 * Complexity O(n^2)
	 */
	@Override
	public Poly[] addPolynomial(Poly[] polyArrayOne, Poly[] polyArrayTwo) {
		int duplicatePower = getDuplicatePower(polyArrayOne, polyArrayTwo);
		// Complexity O(n^2)
		int length = polyArrayOne.length + polyArrayTwo.length-duplicatePower;
		//
		Poly result[] = add(polyArrayOne,polyArrayTwo,length);
		// Complexity O()
		return result;
	}

	/**
	 * 
	 * @param polyArrayOne first Poly values Array
	 * @param polyArrayTwo second Poly values Array
	 * @param length length of result array
	 * @return Poly Array Of Addition
	 */
	private Poly[] add(Poly[] polyArrayOne, Poly[] polyArrayTwo, int length) {
		Poly addition[] = new Poly[length];
		int index=0;
		for(int i=0; i<polyArrayOne.length; i++){
			addition[index] = polyArrayOne[i];
			index++;
		}
		
		for(int i=0; i<polyArrayTwo.length; i++){
			boolean flag = false;
			// checking if power value is already in array
			for(int j=0; j<addition.length; j++){
				if( polyArrayTwo[i].getPower() == addition[j].getPower() ){ // if we found power value in result array
					int coficient = addition[j].getConficient() + polyArrayTwo[i].getConficient(); // updating conficient value in result set
					int power = addition[j].getPower(); // power
					addition[j] = new Poly(coficient,power); // updating new Object Of Poly Object because Poly is immutable
					flag = true;
					break;
				}
			}
			if(flag==false){// if we don't found power value in result array adding new entry
				addition[index] = polyArrayTwo[i];
				index++;
			}
		}
		return addition;
	}

	/**
	 * @param polyArrayOne Poly Array Of Eqn
	 * @param polyArrayTwo poly Array Of Eqn
	 * @return Poly[] Array of Multiplication
	 */
	@Override
	public Poly[] multiplyPolynomial(Poly[] polyArrayOne, Poly[] polyArrayTwo) {
		int lengthOne = polyArrayOne.length;
		int lengthTwo = polyArrayTwo.length;
		Map <Integer, Integer> result = new HashMap<>();
		/**
		* in map changes position of power and conficient
		* because here we add power as key and conficient as key (so update them)
		* this can confuse a lit-bit but we swap position for making calculation eaiser 
		* this for loop calculating multiplication for polinomail values
		* Complexity O(n^2)
		*/
		for(int i=0; i<lengthOne; i++){
			for(int j=0; j<lengthTwo; j++){
				int power = polyArrayOne[i].getPower()+polyArrayTwo[j].getPower();
				int conficient = polyArrayOne[i].getConficient()*polyArrayTwo[j].getConficient();
				if(result.containsKey(power)){ // if power is already exsits in map then update value wrt key
					int previous = result.get(power);
					result.put(power, previous+conficient); //update value wrt to key
				}else{
					result.put(power, conficient); // adding value
				}
			}
		}
		int resultSize = result.size();
		Poly resultMatrix[] = new Poly[resultSize];
		int index=0;
		for(Entry<Integer, Integer> map : result.entrySet()){
			int power = map.getKey(); // key is power of polynomial
			int conficient = map.getValue(); // value is conficient of polinomial
			/*
			 * as our array stores conficient at zero index 
			 * and power at index first index
			 */
			resultMatrix[index] = new Poly(conficient, power); // creating Object Of Poly
			index++;
		}
		return resultMatrix;
	}

	/**
	 * 
	 * @param polyArrayOne array of Poly Value
	 * @param polyArrayTwo array Of poly Value
	 * @return index of Duplicate Poly Values
	 * Complexity O(n^2)
	 */
	private int getDuplicatePower(Poly[] polyArrayOne, Poly[] polyArrayTwo) {
		int duplicate=0;
		for( Poly rowOne: polyArrayOne ){
			for( Poly rowTwo: polyArrayTwo ){
				if(rowOne.getPower()==rowTwo.getPower()){
					duplicate++;
					break;
				}
			}
		}
		return duplicate;
	}

	public int[][] toIntArray(Poly polyArr[]){
		int result[][] = new int[polyArr.length][2];
		int index=0;
		for(Poly poly : polyArr){
			result[index][0] = poly.getConficient();
			result[index][1] = poly.getPower();
			index++;
		}
		return result;
	}
}
