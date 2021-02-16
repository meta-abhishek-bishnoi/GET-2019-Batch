/**
 * This Class Defines The Data Type for sparse Matrix 
 * This Contains Constructor for initializing Matrix 
 * a getter method to return Matrix and so many
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

public class Matrix {
	private final int sparseMatrix[][];
	/*
	 *This is Constructor to initialize Matrix 
	 *@param int[][] A 2-D Array as input matrix
	 *Exception when row=0 || col=0 (AssertionException)
	 *Exception when noOfZeroElements<=(row*col/2)(AssertionException)
	 *Complexity O(n^2)
	 */
	public Matrix( int matrix[][] ){
		int row = matrix.length;
		if(row==0){
			throw new AssertionError("Not A Valid Sparse Matrix !!");
		}
		int col = matrix[0].length;
		if(col==0){
			throw new AssertionError("Not A Valid Sparse Matrix !!");
		}
		int sizeNonZero = getSizeNonZero(matrix);
		// getting count of non zero elements Complexity O(n^2) 
		int condition = (row*col)/2; 
		if(sizeNonZero>condition){
			throw new AssertionError("Not A Valid Sparse Matrix !!");
		}
		int tempMat[][] = getSparseMatrix(matrix,sizeNonZero); 
		// calling Function to convert into sparse matrix Complexity O(n^2)
		sparseMatrix = tempMat;
	}
	/*
	 * @param int[][] 2-D Matrix 
	 * @return int count of non zero elements
	 * Complexity O(n^2)
	 */
	private int getSizeNonZero(int[][] matrix) {
		int size=0;
		for(int row[] : matrix){
			for(int element : row){
				if(element!=0){
				    size++;
				}
			}
		}
		return size;
	}
	/*
	 * @param int[][] matrix ar a 2-D Array
	 * @return int[][] sparse Matrix
	 * Complexity O(n^2)
	 */
	private int[][] getSparseMatrix(int matrix[][], int nonZero){
		int result[][] = new int[nonZero][3];
		int index = 0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j]!=0){
					result[index][0] = i;
					result[index][1] = j;
					result[index][2] = matrix[i][j];
					index++;
				}
			}
		}
		return result;
	}
	/*
	 * @return int[][] sparese Matrix
	 */
	public int[][] getSparseMatrix(){
		return this.sparseMatrix;
	}
}