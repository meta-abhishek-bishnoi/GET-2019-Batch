/*
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

	/*
	 * (non-Javadoc)
	 * @see meta.utility.PolyInterface#evalute(int[][], int)
	 * This Function Returns decimal value of input polynomial function for given value
	 * @param int[][] polynomial function in the form of array
	 * @param int value to be calculate value
	 * @return double result in decimal format
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 */
	@Override
	public double evalute(int array[][], int value) {
		double result=0;
		Polynomial poly = getPoly(array); // Polynomial Object (1)
		int polyArray[][] = poly.getPolynomial(); // converting polynomial array (2)
		// calculating result ; Complexity O(n)
		for(int row[] : polyArray){
			result += row[0]*Math.pow(value,row[1]);
		}
		return result;
	}


	/*
	 * (non-Javadoc)
	 * @see meta.utility.PolyInterface#degree(int[][])
	 * This Function Returns Degree(Largest Power) Of Polynomial Equation
	 * @param int[][] array as a input
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 */
	@Override
	public int degree(int array[][]) {
		Polynomial poly = getPoly(array); // Polynomial Object (1)
		int polyArray[][] = poly.getPolynomial(); //converting polynomial array (2)
		int maxDegree = Integer.MIN_VALUE;
		 // complexity O(n)
		for(int row[] : polyArray){
			if(row[1]>=maxDegree){
				maxDegree = row[1];
			}
		}
		return maxDegree;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.utility.PolyInterface#addPolynomial(int[][], int[][])
	 * This function return addition of two polynomial equation
	 * @param int[][] first poly equation in array
	 * @param int[][] second poly equation in array
	 * @return int[][] return addition equation in array
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 * Complexity O(n^2)
	 */
	@Override
	public int[][] addPolynomial(int arrayOne[][], int arrayTwo[][]) {
		Polynomial poly = getPoly(arrayOne);
		int polyArrayOne[][] = poly.getPolynomial();
		poly = getPoly(arrayTwo);
		int polyArrayTwo[][] = poly.getPolynomial();
		int duplicatePower = getDuplicatePower(polyArrayOne, polyArrayTwo);
		// Calculating Power which is occurred in both arrays
		// Complexity O(n^2)
		int length = polyArrayOne.length + polyArrayTwo.length-duplicatePower;
		// length for addition equation
		int result[][] = add(polyArrayOne,polyArrayTwo,length); // calling function for adding eqns 
		//new int[length][2];
		//Complexity O(m+n)
		return result;
	}

	/*
	 * This part contains logic to adding two poly eqn's
	 * @param int[][] first array  as poly
	 * @param in[][] second array as poly 
	 * @param int new length for result
	 * @return int[][] result of addition
	 * Complexity O(m+n)
	 */
	private int[][] add(int[][] polyArrayOne, int[][] polyArrayTwo, int length) {
		int result[][] = new int[length][2]; //declaring result array
		int index=0;
		/*
		 * adding all elements of first array Complexity O(n)
		 */
		for(int i=0; i<polyArrayOne.length; i++){
			result[index][0]= polyArrayOne[i][0];
			result[index][1]= polyArrayOne[i][1];
			index++;
		}
		 // operation on array two
		// complexity O(m)
		for(int i=0; i<polyArrayTwo.length; i++){
			boolean flag = false;
			// checking if power value is already in array
			for(int j=0; j<result.length; j++){
				if(polyArrayTwo[i][1]==result[j][1]){ // if we found power value in result array
					result[j][0] = result[j][0] + polyArrayTwo[i][0]; // updating conficient value in result set
					flag = true;
					break;
				}
			}
			if(flag==false){// if we don't found power value in result array adding new entry
				result[index][0] = polyArrayTwo[i][0];
				result[index][1] = polyArrayTwo[i][1];
				index++;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.utility.PolyInterface#multiplyPolynomial(int[][], int[][])
	 * this function contains logic of multiply 2 poly arrays
	 * @param int[][] first poly array
	 * @param int[][] second poly array
	 * @return int[][] multiply poly array
	 * Assumption input array contains 0th index conficient and 1st index power of conficient **(As Per Class Defination)
	 * Complexity O(n^2)
	 */
	@Override
	public int[][] multiplyPolynomial(int arrayOne[][], int arrayTwo[][]) {
		Polynomial poly = getPoly(arrayOne);
		int polyArrayOne[][] = poly.getPolynomial();
		poly = getPoly(arrayTwo);
		int polyArrayTwo[][] = poly.getPolynomial();
		int lengthOne = polyArrayOne.length;
		int lengthTwo = polyArrayTwo.length;
		Map <Integer, Integer> result = new HashMap<>();
		/*
		* in map changes position of power and conficient
		* because here we add power as key and conficient as key (so update them)
		* this can confuse a lit-bit but we swap position for making calculation eaiser 
		*/
		/*
		 * this for loop calculating multiplication for polinomail values
		 * Complexity O(n^2)
		 */
		for(int i=0; i<lengthOne; i++){
			for(int j=0; j<lengthTwo; j++){
				int power = polyArrayOne[i][1]+polyArrayTwo[j][1];
				int conficient = polyArrayOne[i][0]*polyArrayTwo[j][0];
				if(result.containsKey(power)){ // if power is already exsits in map then update value wrt key
					int previous = result.get(power);
					result.put(power, previous+conficient); //update value wrt to key
				}else{
					result.put(power, conficient); // adding value
				}
			}
		}
		int resultSize = result.size();
		int resultMatrix[][] = new int[resultSize][2];
		int index=0;
		for(Entry<Integer, Integer> map : result.entrySet()){
			int key = map.getKey(); // key is power of polynomial
			int value = map.getValue(); // value is conficient of polinomial
			/*
			 * as our array stores conficient at zero index 
			 * and power at index first index
			 */
			resultMatrix[index][0] = value;
			resultMatrix[index][1] = key;
			index++;
		}
		return resultMatrix;
	}
	
	/*
	 * this function calculates common power in both array
	 * @param int[][] first poly array
	 * @param int[][] second poly array
	 * @return int no-Of-Common Power
	 * Complexity O(n^2)
	 */
	private int getDuplicatePower(int polyArrayOne[][], int polyArrayTwo[][]){
		int duplicate=0;
		for(int rowOne[]: polyArrayOne){
			for(int rowTwo[]: polyArrayTwo){
				if(rowOne[1]==rowTwo[1]){
					duplicate++;
					break;
				}
			}
		}
		return duplicate;
	}
	/*
	 * @param int[][] array value
	 * @return Polynomial Object in immutable value
	 */
	private Polynomial getPoly(int array[][]) {
		
		return new Polynomial(array);
	}
}
