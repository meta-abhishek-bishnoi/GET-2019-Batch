package meta.utility;

public class Service 
{
	MatrixOperation operation = new MatrixOperation();
	//
	/*
	 * 
	 */
	public int[][] getTranspose(int matrix[][]){
		
		int sparseMatrix[][] = getsparseMatrix(matrix);
		int row = matrix.length; 
		int col = matrix[0].length;
		/*
		 * swaping row and column
		 */
		int temp = row;
		row = col;
		col = temp;
		int transposeMatrix[][] = operation.transpose(sparseMatrix);
		int convertMatrix[][] = convertFromsparseMatrix(transposeMatrix,row,col);
		return convertMatrix;
	}
	/*
	 * 
	 */
	public boolean isSymmetrical(int matrix[][]){
		int sparseMatrix[][] = getsparseMatrix(matrix);
		boolean isSymmetric = operation.isSymmetrical(sparseMatrix);
		return isSymmetric;
	}
	/*
	 * 
	 */
	public int[][] addMatrix(int matrix1[][], int matrix2[][]){
		if(matrix1.length!=matrix2.length && matrix1[0].length != matrix1[0].length){
			throw new AssertionError("Addition Can't Perform");
		}
		int row = matrix1.length; 
		int col = matrix1[0].length;
		int sparseMatrixOne[][] = getsparseMatrix(matrix1);
		int sparseMatrixTwo[][] = getsparseMatrix(matrix2);
		int addition[][] = operation.addMatrix(sparseMatrixOne, sparseMatrixTwo);
		int convertMatrix[][] = convertFromsparseMatrix(addition,row,col);
		return convertMatrix;
	}
	/*
	 * 
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
		int sparseMatrixTwo[][] = getsparseMatrix(matrix2);
		int resultMatrix[][] = operation.multiplyMatrix(sparseMatrixOne, sparseMatrixTwo, row1, col2);
		return resultMatrix;
	}
	/*
	 * 
	 */
	private int[][] convertFromsparseMatrix(int[][] transposeMatrix, int row, int col) {
		int result[][] = new int[row][col];
		int transRow = transposeMatrix.length;
		for(int i=0; i< transRow; i++){
			int currentRow = transposeMatrix[i][0];
			int currentCol = transposeMatrix[i][1];
			result[currentRow][currentCol]=transposeMatrix[i][2];
		}
		return result;
	}
	/*
	 * 
	 */
	private int[][] getsparseMatrix(int matrix[][]){
		Matrix object = new Matrix(matrix);
		int sparseMatrix[][] = object.getSparseMatrix();
		return sparseMatrix;
	}
}
