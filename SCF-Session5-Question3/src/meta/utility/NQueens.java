package meta.utility;

public class NQueens {
	int dimention;
	int row;
	int board[][];
	int emptyBoard[][];
	public NQueens( int board[][], int row, int dimention){
		this.board = board;
		emptyBoard = board;
		this.row = row;
		this.dimention = dimention;
	}
	public int[][] getNQueen(){
		boolean result = findSolution(board,row,dimention);
		if(result == true){
			return board;
		}
		return emptyBoard;
	}
	/*
	 * 
	 */
	private boolean findSolution(int board[][], int row, int dimention) {
		boolean flag = false;
		if(row>=dimention){
			flag = true;
			return flag;
		}
		for(int i=0; i<dimention; i++){
			boolean result = placeQueenOrNot(board, row, i, dimention);
			if(result==true){
				board[row][i]=1;
				boolean isSolve = findSolution(board,row+1,dimention);
				if(isSolve==true){
					return true;
				}
				board[row][i]=0;
			}
		}
		return false;
	}
	/*
	 * 
	 */
	private boolean placeQueenOrNot(int[][] board, int row, int column, int dimention) {
		for(int i=0; i<row; i++){
			if(board[i][column]==1){
				return false;
			}
		}
		for(int i=row, j=column; i>=0 && j>= 0; i--, j--){
			if(board[i][j]==1){
				return false;
			}
		}
		for(int i=row, j=column; j>0 && i<dimention;i++,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		return true;
	}
}
