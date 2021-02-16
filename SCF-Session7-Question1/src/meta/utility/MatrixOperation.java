/**
 * This is operational class which perform operations on sparse matrix 
 * in sparse matrix format row[0],row[1] are i,j indexes(row,column of original matrix) 
 * & row[1] is values of that indexes
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

import java.util.HashMap;
import java.util.Map;

public class MatrixOperation implements MatrixInter{

	/**
	 * This Function Returns Transpose Matrix (sparse matrix)
	 * @param int[][] input matrix in sparse Format (2-D Array)
	 * @return int[][] transpose of matrix in sparse format (2-D Array)
	 * Complexity O(n)
	 */
	@Override
	public int[][] transpose(int sparseMatrix[][]) {
		int transposeMatrix[][] = new int[sparseMatrix.length][3];
		int index=0;
		/*
		 * swap row & column indexes of sparse matrix 
		 * Complexity Of loop O(n)
		 */
		for( int row[] : sparseMatrix){
				transposeMatrix[index][0] = row[1];
				transposeMatrix[index][1] = row[0];
				transposeMatrix[index][2] = row[2];
				index++;
		}
		return transposeMatrix;
	}

	/**
	 * This Function Returns boolean value as result
	 * @param int[][] input matrix in sparse Format (2-D Array)
	 * @return boolean true or false {Symmetrical Or NotSymmetrical}
	 * Complexity O(n^2)
	 */
	@Override
	public boolean isSymmetrical(int sparseMatrix[][]) {
		int  sparseMatrixOriginal[][] = sparseMatrix;
		int sparseMatrixTranspose[][] = transpose(sparseMatrix);
		boolean result = true;
		int length = sparseMatrix.length;
		/**
		 * checking 
		 * if original matrix == transpose of original matrix matrix is symmetrical
		 * Complexity O(n^2)
		 */
		for(int i=0; i<length; i++){
			boolean flag=false; 
			for(int j=0; j<length; j++){
				if(sparseMatrixOriginal[i][0]==sparseMatrixTranspose[j][0] &&
						sparseMatrixOriginal[i][1]==sparseMatrixTranspose[j][1] &&	
						sparseMatrixOriginal[i][2]==sparseMatrixTranspose[j][2] ){
					flag = true;
					break;
				}
			}
			/*
			 * if condition fails at any point return false
			 */
			if(flag==false){
				result = false;
				return result;
			}
		}
		return result;
	}

	/**
	 * This Function performs Addition On Matrix (Sparse) are return result as sparse matrix
	 * @param int[][] first sparse matrix
	 * @param int[][] second sparse matrix
	 * @return int[][] addition in sparse matrix form
	 * Complexity O(n^2)
	 */
	@Override
	public int[][] addMatrix(int matrixOne[][], int matrixTwo[][]) {
		int lengthOne = matrixOne.length;
		int lengthTwo = matrixTwo.length;
		int duplicate = getDuplicate(matrixOne, matrixTwo);
		// getting count of same row and column values in matrix; Complexity O(n^2)
		int size = lengthOne+lengthTwo-duplicate;
		// size of new sparse matrix after addition
		int addition[][] = new int[size][3];
		// defining matrix for addition
		int index=0;
		/*
		 * Adding All Elements of First Matrix or array (Sparse Array)
		 * Complexity O(n)
		 */
		for(int i=0; i<lengthOne; i++){
			addition[index][0]=matrixOne[i][0];
			addition[index][1]=matrixOne[i][1];
			addition[index][2]=matrixOne[i][2];
			index++;
		}
		/*
		 * in second sparse array first we check if value is already existing or not
		 * if value(row and col of sparse matrix) is already existing then add the values otherwise update a new entry
		 * Complexity O(n^2)
		 */
		for(int i=0; i<lengthTwo; i++){
			boolean flag = false;
			for(int j=0; j<size; j++){
				if(matrixTwo[i][0]==addition[j][0] && 
						matrixTwo[i][1]==addition[j][1]){
					flag = true;
					addition[j][2] += matrixTwo[i][2];
					// updating value
				}
			}
			/*
			 * adding new value
			 */
			if(flag==false){
				addition[index][0]=matrixTwo[i][0];
				addition[index][1]=matrixTwo[i][1];
				addition[index][2]=matrixTwo[i][2];
				index++;
			}
		}
		return addition;
	}
	/*
	 * this function return count of these values which are existing in both array
	 * here value means (row,index of sparse matrix)
	 * Complexity O(n^2)
	 */
	private int getDuplicate(int matrixOne[][], int matrixTwo[][]){
		int count=0;
		int lengthOne = matrixOne.length;
		int lengthTwo = matrixTwo.length;
		for(int i=0; i<lengthOne; i++){
			for(int j=0; j<lengthTwo; j++){
				if( matrixOne[i][0]== matrixTwo[j][0] && 
						matrixOne[i][1]== matrixTwo[j][1] ){
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * This function perform multiplication in sparse matrix
	 * @param int[][] sparse matrix 
	 * @param int[][] sparse matrix
	 * @param int row of result matrix
	 * @param int column of result matrix
	 * @return int[][] result matrix
	 * Complexity O(n^3)
	 */
	@Override
	public int[][] multiplyMatrix(int matrixOne[][], int matrixTwo[][], int row, int col) {
		Map <Integer,Map<Integer,Integer>> mapA = new HashMap<>();
		Map <Integer,Map<Integer,Integer>> mapB = new HashMap<>();
		int resultMatrix[][] = new int[row][col];
		// putting matrixOne values to MapA
		for(int i=0; i<matrixOne.length; i++){
			if(!mapA.containsKey(matrixOne[i][0])){
				mapA.put(matrixOne[i][0], new HashMap<>());
			}
			mapA.get(matrixOne[i][0]).put(matrixOne[i][1], matrixOne[i][2]);
		}
		// putting matrixTwo Values to MapB
		for(int i=0; i<matrixTwo.length; i++){
			if(!mapB.containsKey(matrixTwo[i][0])){
				mapB.put(matrixTwo[i][0], new HashMap<>());
			}
			mapB.get(matrixTwo[i][0]).put(matrixTwo[i][1], matrixTwo[i][2]);
		}
		// multiplying Values
		for(int i: mapA.keySet()){
			for(int j: mapA.get(i).keySet()){
				if(!mapB.containsKey(j)){
					continue;
				}
				for(int k: mapB.get(j).keySet()){
					resultMatrix[i][k] += mapA.get(i).get(j) * mapB.get(j).get(k);
				}
			}
		}
		return resultMatrix;
	}

}
