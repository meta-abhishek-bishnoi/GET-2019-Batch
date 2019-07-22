/*
 * This class defines structure for polynomial 
 * This contains immutable variable of polynomial
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

public class Polynomial {
	/*
	 * This Array Contains 2 variables in each row, these are as follows:
	 * at index 0 - coficient value
	 * at index 1 - power for that coficient
	 * let's see 3y2+3y+3 is stored as
	 * array[][] = { {3,2},{3,1},{3,0} }
	 */
	private final int polynomial[][]; //immutable variable
	/*
	 * This Constructor provides memory to int polynomial[]
	 * @param int[][] 2-D Array
	 * Complexity O(n)
	 */
	public Polynomial(int polynomial[][]){
		int getNonZero = nonZeroCoficient(polynomial);
		// getting count of non-zero-conficient Complexity O(n)
		int nonZeroArray[][] = new int[getNonZero][2];
		// declaring array to store non-zero-conficient poly
		int index=0;
		//Complexity O(n)
		for(int row[] : polynomial){
			if(row[0]!=0){ // if conficient is not zero
				nonZeroArray[index] = row;
				index++;
			}
		}
		this.polynomial = nonZeroArray;
	}
	/*
	 * @param int[][] 2-D Array it contains all values
	 * @return int count/size of non-zero-conficient
	 * Complexity O(n)
	 */
	private int nonZeroCoficient(int[][] polynomial) {
		int size=0;
		// complexity O(n)
		for(int row[] : polynomial){
			if(row[0]!=0){
				size++;
			}
		}
		return size;
	}
	/*
	 * @return polynomial array
	 * this is used to return polynomial Value
	 */
	public int[][] getPolynomial(){
		return this.polynomial;
	}
}
