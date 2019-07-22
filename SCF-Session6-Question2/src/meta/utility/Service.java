package meta.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Service implements PolyInterface {

	@Override
	public double evalute(Polynomial poly, int value) {
		double result=0;
		int polyArray[][] = poly.getPolynomial();
		for(int row[] : polyArray){
			result += row[0]*Math.pow(value,row[1]);
		}
		return result;
	}

	@Override
	public int degree(Polynomial poly) {
		int polyArray[][] = poly.getPolynomial();
		int maxDegree = Integer.MIN_VALUE;
		for(int row[] : polyArray){
			if(row[1]>=maxDegree){
				maxDegree = row[1];
			}
		}
		return maxDegree;
	}

	@Override
	public int[][] addPolynomial(Polynomial polyOne, Polynomial polyTwo) {

		int polyArrayOne[][] = polyOne.getPolynomial();
		int polyArrayTwo[][] = polyTwo.getPolynomial();
		int duplicatePower = getDuplicatePower(polyArrayOne, polyArrayTwo);
		int length = polyArrayOne.length + polyArrayTwo.length-duplicatePower;
		int result[][] = add(polyArrayOne,polyArrayTwo,length); //new int[length][2];
		return result;
	}

	private int[][] add(int[][] polyArrayOne, int[][] polyArrayTwo, int length) {
		int result[][] = new int[length][2];
		int index=0;
		for(int i=0; i<polyArrayOne.length; i++){
			result[index][0]= polyArrayOne[i][0];
			result[index][1]= polyArrayOne[i][1];
			index++;
		}
		for(int i=0; i<polyArrayTwo.length; i++){
			boolean flag = false;
			for(int j=0; j<result.length; j++){
				if(polyArrayTwo[i][1]==result[j][1]){
					result[j][0] = result[j][0] + polyArrayTwo[i][0];
					flag = true;
					break;
				}
			}
			if(flag==false){
				result[index][0] = polyArrayTwo[i][0];
				result[index][1] = polyArrayTwo[i][1];
				index++;
			}
		}
		return result;
	}

	@Override
	public int[][] multiplyPolynomial(Polynomial polyOne, Polynomial polyTwo) {
		int polyArrayOne[][] = polyOne.getPolynomial();
		int polyArrayTwo[][] = polyTwo.getPolynomial();
		int lengthOne = polyArrayOne.length;
		int lengthTwo = polyArrayTwo.length;
		Map <Integer, Integer> result = new HashMap<>();
		// first is power and second value is conficient
		for(int i=0; i<lengthOne; i++){
			for(int j=0; j<lengthTwo; j++){
				int power = polyArrayOne[i][1]+polyArrayTwo[j][1];
				int conficient = polyArrayOne[i][0]*polyArrayTwo[j][0];
				if(result.containsKey(power)){
					int previous = result.get(power);
					result.put(power, previous+conficient);
				}else{
					result.put(power, conficient);
				}
			}
		}
		int resultSize = result.size();
		int resultMatrix[][] = new int[resultSize][2];
		int index=0;
		for(Entry<Integer, Integer> map : result.entrySet()){
			int key = map.getKey();
			int value = map.getValue();
			resultMatrix[index][0] = value;
			resultMatrix[index][1] = key;
			index++;
		}
		return resultMatrix;
	}
	private int[][]  sortInDegreeOrder( int polyArray[][] ){
		return null;
	}

	private int getDuplicatePower(int polyArrayOne[][], int polyArrayTwo[][]){
		int duplicate=0;
		for(int rowOne[]: polyArrayOne){
			for(int rowTwo[]: polyArrayTwo){
				if(rowOne[1]==rowTwo[1]){
					duplicate++;
					break;
				}
			}
		}
		return duplicate;
	}
}
