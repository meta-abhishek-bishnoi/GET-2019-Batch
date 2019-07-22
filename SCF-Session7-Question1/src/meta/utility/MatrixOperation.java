package meta.utility;

import java.util.HashMap;
import java.util.Map;

public class MatrixOperation implements MatrixInter{

	/*
	 * (non-Javadoc)
	 * @see meta.utility.MatrixInter#transpose()
	 */
	@Override
	public int[][] transpose(int sparseMatrix[][]) {
		int transposeMatrix[][] = new int[sparseMatrix.length][3];
		int index=0;
		for( int row[] : sparseMatrix){
				transposeMatrix[index][0] = row[1];
				transposeMatrix[index][1] = row[0];
				transposeMatrix[index][2] = row[2];
				index++;
		}
		return transposeMatrix;
	}

	@Override
	public boolean isSymmetrical(int sparseMatrix[][]) {
		int  sparseMatrixOriginal[][] = sparseMatrix;
		int sparseMatrixTranspose[][] = transpose(sparseMatrix);
		boolean result = true;
		int length = sparseMatrix.length;
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
			if(flag==false){
				result = false;
				return result;
			}
		}
		return result;
	}

	@Override
	public int[][] addMatrix(int matrixOne[][], int matrixTwo[][]) {
		int lengthOne = matrixOne.length;
		int lengthTwo = matrixTwo.length;
		int duplicate = getDuplicate(matrixOne, matrixTwo);
		int size = lengthOne+lengthTwo-duplicate;
		int addition[][] = new int[size][3];
		int index=0;
		for(int i=0; i<lengthOne; i++){
			addition[index][0]=matrixOne[i][0];
			addition[index][1]=matrixOne[i][1];
			addition[index][2]=matrixOne[i][2];
			index++;
		}
		for(int i=0; i<lengthTwo; i++){
			boolean flag = false;
			for(int j=0; j<size; j++){
				if(matrixTwo[i][0]==addition[j][0] && 
						matrixTwo[i][1]==addition[j][1]){
					flag = true;
					addition[j][2] += matrixTwo[i][2];
				}
			}
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
	 * 
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
	/*
	 * (non-Javadoc)
	 * @see meta.utility.MatrixInter#multiplyMatrix()
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
