package meta.test;

import meta.utility.Service;

public class Main {

	public static void main(String[] args) 
	{
		Service service = new Service();
		int array[][] = {
				{1,0,1},
				{0,1,0},
				{1,0,0}
		};
		int array1[][] = {
				{1,0,0},
				{0,0,0},
				{1,0,0}
		};
		print(array);
		int transArr[][] = service.getTranspose(array);
		System.out.println("trans :");
		print(transArr);
		System.out.println("Is Symmetric :"+service.isSymmetrical(array));
		System.out.println("Addition Is :");
		int addition[][] = service.addMatrix(array, array1);
		print(addition);
		System.out.println("Multiply is :");
		int multiply[][] = service.multiplyMatrix(array, array1);
		print(multiply);
	}
	public static void print(int[][] array){
		for(int row[]: array){
			for(int ele: row){
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}

}
