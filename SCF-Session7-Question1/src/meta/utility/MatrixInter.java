package meta.utility;

public interface MatrixInter {

	public int[][] transpose(int matrix[][]);
	public boolean isSymmetrical(int matrix[][]);
	public int[][] addMatrix(int matrixOne[][], int matrixTwo[][]);
	public int[][] multiplyMatrix(int matrixOne[][], int matrixTwo[][], int row, int col);
}
