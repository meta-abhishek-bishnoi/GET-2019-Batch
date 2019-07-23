/**
 * This class contains data set for addition
 * @author Abhishek Bishnoi
 * @version 1.0
 * @since 22-July-2019
 */
package meta.test;

public class DataAdd {
	public static int[][] ARRAY_ONE_FIRST = {
		{1,0,1},
		{0,1,0},
		{1,0,0}
	};
	public static int[][] ARRAY_ONE_SECOND = {
		{1,0,0},
		{0,0,0},
		{1,0,0}
	};
	public static int[][] ARRAY_ONE_RESULT = {
		{2,0,1},
		{0,1,0},
		{2,0,0}
	};
	//
	public static int[][] ARRAY_TWO_FIRST = {
		{1,0,1,0,0,1,0}
	};
	public static int[][] ARRAY_TWO_SECOND = {
		{1,0,0,0,0,1,0}
	};
	public static int[][] ARRAY_TWO_RESULT = {
		{2,0,1,0,0,2,0}
	};
	//
	public static int[][] ARRAY_THREE_FIRST = {
		{1,0,0},
		{0,1,0}
	};
	public static int[][] ARRAY_THREE_SECOND = {
		{0,0,1},
		{0,1,0}
	};
	public static int[][] ARRAY_THREE_RESULT = {
		{1,0,1},
		{0,2,0}
	};
	//
	public static int[][] ARRAY_FOUR_FIRST = {
		{5,0,0,4,0},
		{3,0,0,1,0},
		{0,2,2,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{1,1,1,1,1}
	};
	public static int[][] ARRAY_FOUR_SECOND = {
		{1,1,1,1,1},
		{3,0,0,1,0},
		{0,2,2,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,2,2,0,0}
	};
	public static int[][] ARRAY_FOUR_RESULT = {
		{6,1,1,5,1},
		{6,0,0,2,0},
		{0,4,4,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{1,3,3,1,1}
	};
}
