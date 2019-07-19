/*
 * This is test case class for N-Queens Problem 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 18-July-2019
 */
package meta.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import meta.utility.NQueens;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NQueensTest {

	/*
	 * Testing function with @Parameters 
	 * So these test cases will executes one by one(By Iteration)
	 * so here we don't require to write too much test cases
	 * here in this array we are sending in order of:
	 * row, dimension, empty board and result board
	 */
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{ 0, 4, BoardData.arrayEmptyBoard1, BoardData.arrayResultBoard1 },
				{ 0, 8, BoardData.arrayEmptyBoard2, BoardData.arrayResultBoard2 },
				{ 0, 5, BoardData.arrayEmptyBoard3, BoardData.arrayResultBoard3}
		});
	}
	// 
	private int row;
	private int dimension;
	private int board[][];
	private int expected[][];
	/*
	 * 
	 */
	public NQueensTest(int row, int dimension, int board[][], int expected[][]){
		this.row = row;
		this.dimension = dimension;
		this.board = board;
		this.expected = expected;
	}
	@Test
	public void testGetNQueen() throws IOException {
		NQueens object = new NQueens(board,row,dimension);
		int actual[][]= object.getNQueen();
		assertArrayEquals(expected,actual);
	}

}
