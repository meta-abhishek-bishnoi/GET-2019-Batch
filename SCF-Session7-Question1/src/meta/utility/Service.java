/**
 * This Class Is Called by Driver Class 
 * inputs are in int[][] form this class convert them in saprseMatrix Object
 * and call MatrixOpeartion object to perform operations and return result also converted
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 22-July-2019
 */
package meta.utility;

public class Service 
{
	MatrixOperation operation = new MatrixOperation();
	/*
	 * This Function get matrix from calling fun
	 * it convert it into sparse matrix and call MatrixOperation with parameter
	 * then it will convert it into normal matrix and return to calling fn
	 * @param int[][] 2D array as a matrix
	 * @return int[][] 2D array as a matrix
	 * Complexity o(n^2)
	 */
	public int[][] getTranspose(int matrix[][]){
		
		int sparseMatrix[][] = getsparseMatrix(matrix);
		// calling sparse matrix fn Complexity O(n^2) 
		int row = matrix.length; 
		int col = matrix[0].length;
		/* 
		 * swaping row and column for transpose matrix
		 */
		int temp = row;
		row = col;
		col = temp;
		int transposeMatrix[][] = operation.transpose(sparseMatrix);
		// Complexity O(n)
		int convertMatrix[][] = convertFromsparseMatrix(transposeMatrix,row,col);
		// Complexity O(n)
		return convertMatrix;
	}
	/**
	 * this will return boolean value for is symmetric or not
	 * @param int[][] sparse matrix
	 * @return boolean 
	 * Complexity O(n^2)
	 */
	public boolean isSymmetrical(int matrix[][]){
		int sparseMatrix[][] = getsparseMatrix(matrix);
		// complexity O(n^2)
		boolean isSymmetric = operation.isSymmetrical(sparseMatrix);
		// Complexity O(n^2)
		return isSymmetric;
	}
	/**
	 * This function is used to convert 2-d arrays to sparse matrix 
	 * and call fn to perform addition on sparse matrix and 
	 * convert back them to normal matrix
	 * @param int[][] matrix1 as input value
	 * @param int[][] matrix2 as input value
	 * @return int[][] matrix as result value
	 * @exception Assertion Exception when both matrix are not same in dimention
	 * Complexity O(n^2)
	 */
	public int[][] addMatrix(int matrix1[][], int matrix2[][]){
		if(matrix1.length!=matrix2.length && matrix1[0].length != matrix1[0].length){
			throw new AssertionError("Addition Can't Perform");
		}
		int row = matrix1.length; 
		int col = matrix1[0].length;
		int sparseMatrixOne[][] = getsparseMatrix(matrix1);
		// Complexity O(n^2)
		int sparseMatrixTwo[][] = getsparseMatrix(matrix2);
		// Complexity O(n^2)
		int addition[][] = operation.addMatrix(sparseMatrixOne, sparseMatrixTwo);
		// Compexity O(n^2)
		int convertMatrix[][] = convertFromsparseMatrix(addition,row,col);
		// Complexity O(n)
		return convertMatrix;
	}
	/**
	 * This function is used to convert 2-d arrays to sparse matrix 
	 * and call fn to perform multiply on sparse matrix and 
	 * return normal matrix
	 * @param int[][] matrix1 as input value
	 * @param int[][] matrix2 as input value
	 * @return int[][] matrix as result value
	 * @exception Assertion Exception when column of first matrix is not equals to row of second matrix
	 * Complexity O(n^3)
	 */
	public int[][] multiplyMatrix(int matrix1[][], int matrix2[][]){
		int row1 = matrix1.length;
		int col1 = matrix1[0].length;
		int row2 = matrix2.length;
		int col2 = matrix2[0].length;
		if(col1!=row2){
			throw new AssertionError("Multiply Can't Perform");
		}
		int sparseMatrixOne[][] = getsparseMatrix(matrix1);
		// Complexity O(n^2)
		int sparseMatrixTwo[][] = getsparseMatrix(matrix2);
		// Complexity O(n^2)
		int resultMatrix[][] = operation.multiplyMatrix(sparseMatrixOne, sparseMatrixTwo, row1, col2);
		// complexity O(n^3)
		return resultMatrix;
	}
	/**
	 * @param int[][] sparse matrix
	 * @param int row value for new matrix
	 * @param int column value for new matrix
	 * @return int[][] normal matrix
	 */
	private int[][] convertFromsparseMatrix(int[][] transposeMatrix, int row, int col) {
		int result[][] = new int[row][col];
		int transRow = transposeMatrix.length;
		/*
		 * putting values on the place i,j remaining will be zero 
		 * Complexity O(n)
		 */
		for(int i=0; i< transRow; i++){
			int currentRow = transposeMatrix[i][0];
			int currentCol = transposeMatrix[i][1];
			result[currentRow][currentCol]=transposeMatrix[i][2];
		}
		return result;
	}
	/**
	 * @param int[][] normal matrix
	 * @return int[][] sparse matrix
	 * Complexity O(n^2)
	 */
	private int[][] getsparseMatrix(int matrix[][]){
		Matrix object = new Matrix(matrix);
		int sparseMatrix[][] = object.getSparseMatrix();
		// complexity O(n^2)
		return sparseMatrix;
	}
}
