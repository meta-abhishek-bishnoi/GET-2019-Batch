/**
 * This class contains data set 
 * @author Abhishek Bishnoi
 * @version 1.0
 * @since 22-July-2019
 */
package meta.test;

public class TestData {

	public static int[][] ARRAY_ONE ={
			{1,0,1},
			{0,1,0},
			{1,0,0}
	};
	public static boolean SYMMETRIC_ONE = true;
	public static int[][] TRANS_ONE = {
			{1,0,1},
			{0,1,0},
			{1,0,0}
	};
	//
	public static int[][] ARRAY_TWO={
			{1,0,0},
			{0,0,0},
			{1,0,0}
	};
	public static boolean SYMMETRIC_TWO = false;
	public static int[][] TRANS_TWO = {
			{1,0,1},
			{0,0,0},
			{0,0,0}
	};
	//
	public static int[][] ARRAY_THREE={
			{1,0,0}
	};
	public static boolean SYMMETRIC_THREE = true;
	public static int[][] TRANS_THREE = {
			{1},
			{0},
			{0}
	};
	//
	public static int[][] ARRAY_FOUR = {
		{2,3,0,0,0},
		{1,0,0,0,0}
	};
	public static boolean SYMMETRIC_FOUR = false;
	public static int[][] TRANS_FOUR = {
		{2,1},
		{3,0},
		{0,0},
		{0,0},
		{0,0},
	};
	// 
	public static int[][] ARRAY_FIVE = {
		{0}
	};
	public static boolean SYMMETRIC_FIVE = true;
	public static int[][] TRANS_FIVE = {
		{0}
	};
}
