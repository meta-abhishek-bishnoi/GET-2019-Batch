/*
 * This is Utility class for NQueens Problems Solution
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 19-July-2019
 */
package meta.utility;

public class NQueens {
	int dimension;
	int row;
	int board[][];
	int emptyBoard[][];
	/*
	 * it is Constructor For initialize variable 
	 */
	public NQueens( int board[][], int row, int dimension){
		this.board = board;
		emptyBoard = board;
		this.row = row;
		this.dimension = dimension;
	}
	/*
	 * this return array value of placed queens in board 
	 * otherwise it returns empty board
	 */
	public int[][] getNQueen(){
		boolean result = findSolution(board,row,dimension);
		if(result == true){
			return board;
		}
		return emptyBoard;
	}
	/*
	 * this Function Returns True if A solutions is possible for that's row in board
	 * @param int[][] this contains current position of board 
	 * @param int this contains current row index of board on which operation is performing
	 * @param int this is the size of dimension
	 * @return boolean value for possible solution
	 */
	private boolean findSolution(int board[][], int row, int dimension) {
		boolean flag = false;
		if(row>=dimension){
			flag = true;
			return flag;
		}
		/*
		 * logic for backtracking in Queen's Problem
		 */
		for(int i=0; i<dimension; i++){
			boolean result = placeQueenOrNot(board, row, i, dimension);
			// checking if placing a queen is possible or not
			if(result==true){
				board[row][i]=1; // updating value as 1
				boolean isSolve = findSolution(board,row+1,dimension);
				// calling recursively for next row value
				if(isSolve==true){
					flag = true;
					return flag; // if possible then true
				}
				board[row][i]=0; // updating value to zero
			}
		}
		return flag;
	}
	/*
	 * This Function Returns if The Queen can be placed or not without interrupting any other queen
	 * @param int[][] this contains current position of board 
	 * @param int this contains current row index of board on which operation is performing
	 * @param int this contains current column index of board on which operation is performing
	 * @param int this is the size of dimension
	 * @return boolean value for possible solution
	 */
	private boolean placeQueenOrNot(int[][] board, int row, int column, int dimention) {
		boolean flag = true;
		// checking in row values
		for(int i=0; i<row; i++){
			if(board[i][column]==1){
				flag =  false;
				return flag;
			}
		}
		// checking in column values
		for(int i=0; i<column; i++){
			if(board[row][i]==1){
				flag =  false;
				return flag;
			}
		}
		// checking in top left diagonal
		for(int i=row, j=column; i>=0 && j>= 0; i--, j--){
			if(board[i][j]==1){
				flag = false;
				return flag;
			}
		}
		// checking in bottom left diagonal
		for(int i=row, j=column; j>0 && i<dimention;i++,j--){
			if(board[i][j]==1){
				flag =  false;
				return flag;
			}
		}
		// checking in top right diagonal
		for(int i=row, j=column; i>0 && j<dimention;i--,j++){
			if(board[i][j]==1){
				flag = false;
				return flag;
			}
		}
		return flag;
	}
}
