package meta.utility;

public class Polynomial {
	private final int polynomial[][];
	public Polynomial(int polynomial[][]){
		int getNonZero = nonZeroCoficient(polynomial);
		int nonZeroArray[][] = new int[getNonZero][2];
		int index=0;
		for(int row[] : polynomial){
			if(row[0]!=0){
				nonZeroArray[index] = row;
				index++;
			}
		}
		this.polynomial = nonZeroArray;
	}
	private int nonZeroCoficient(int[][] polynomial) {
		int size=0;
		for(int row[] : polynomial){
			if(row[0]!=0){
				size++;
			}
		}
		return size;
	}
	public int[][] getPolynomial(){
		return this.polynomial;
	}
}
