package meta.utility;

public class Matrix {
	private final int sparseMatrix[][];
	/*
	 * 
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
		int condition = (row*col)/2; 
		if(sizeNonZero>condition){
			throw new AssertionError("Not A Valid Sparse Matrix !!");
		}
		int tempMat[][] = getSparseMatrix(matrix,sizeNonZero);
		sparseMatrix = tempMat;
	}
	/*
	 * 
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
	 * 
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
	 * 
	 */
	public int[][] getSparseMatrix(){
		return this.sparseMatrix;
	}
}