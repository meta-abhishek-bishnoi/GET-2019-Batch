package meta.test;

import java.util.Arrays;

import meta.utility.Polynomial;
import meta.utility.Service;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();
		int array[][]={
				{1,1},
				{2,0}
		};
		int array1[][]={
				{1,1},
				{1,0}
		};
		Polynomial object = new Polynomial(array);
		double result = service.evalute(object, 2);
		int degree = service.degree(object);
		System.out.println("evalution of poly is "+result);
		System.out.println("degree of function "+degree);
		int resultAdd[][] = service.addPolynomial(object, new Polynomial(array1));
		for(int row[] : resultAdd){
			System.out.println(row[0]+" x.pow("+row[1]+")");
		}
		int resultMultiply[][] = service.multiplyPolynomial(object, new Polynomial(array1));
		System.out.println("Multiply");
		for(int row[] : resultMultiply){
			System.out.println(row[0]+" x.pow("+row[1]+")");
		}
	}

}
