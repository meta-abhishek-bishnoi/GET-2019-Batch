package meta.test;

import static org.junit.Assert.*;
import meta.utility.NQueens;

import org.junit.Test;

public class NQueensTest {

	@Test
	public void testGetNQueen() {
		int row =0;
		int dimention = 4;
		int data[][] = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
		};
		int expected[][] = {
				{0,1,0,0},
				{0,0,0,1},
				{1,0,0,0},
				{0,0,1,0}
		};
		NQueens object = new NQueens(data,row,dimention);
		int actual[][]= object.getNQueen();
		assertArrayEquals(expected,actual);
	}
	@Test
	public void testGetNQueen1() {
		int row =0;
		int dimention = 8;
		int data[][] = {
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}
		};
		int expected[][] = {
				{1,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0},
				{0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,1,0},
				{0,0,0,1,0,0,0,0},
				{0,1,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0}
		};
		NQueens object = new NQueens(data,row,dimention);
		int actual[][]= object.getNQueen();
		assertArrayEquals(expected,actual);
	}

}
