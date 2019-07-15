/*
 * This is driven class for getting area with different different shapes
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.Messages;
import meta.helper.ShapeAreaImplementation;

public class ShapeArea {
	public static void main(String[] args) {
		Scanner scanChar = new Scanner(System.in);
		// java.util.Scanner object
		ShapeAreaImplementation service = new ShapeAreaImplementation();
		// object to access service 
		String messages[] = Messages.CHOICE_INPUT;
		String shapes[] = Messages.SHAPES;
		// storing messages to String array
		int length = messages.length;
		char cont='y';
		String message;
		int indexOfShape;
		String shapeName;
		do{
			/*
			 * printing messages
			 */
			for(int i=0; i<length; i++ ){
				System.out.println(messages[i]+shapes[i]);
			}
			char choice = scanChar.next().charAt(0);
			switch(choice){
			case 'a':
			case 'A':
				shapeName = Messages.SHAPES[0];
				message = Messages.TRIANGLE_HEIGHT;// taking input by calling a function
				double heightTri = input(message);
				message = Messages.TRIANGLE_BASE;
				double baseTri =  input(message);
				double resultTri = service.getArea(heightTri, baseTri, shapeName); 
				// area calculation using service object functions
				message = Messages.RESULT_TRIANGLE;
				printResult("Result",resultTri);
				break;
			case 'b':
			case 'B':
				shapeName = Messages.SHAPES[1];
				message = Messages.RECT_HEIGHT;
				double heightRect = input(message);
				message = Messages.RECT_WIDTH;
				double widthRect =  input(message);
				double resultRect = service.getArea(heightRect, widthRect, shapeName);
				// area calculation using service object functions
				message = Messages.RESULT_RECTANGLE;
				printResult("Result",resultRect);
				break;
			case 'c':
			case 'C':
				shapeName = Messages.SHAPES[2];
				message = Messages.SQURE_SIDE;
				double side =  input(message);
				double resultSqure = service.getArea(side, side, shapeName);
				// area calculation using service object functions
				message = Messages.RESULT_SQURE;
				printResult("Result",resultSqure);
				break;
			case 'd':
			case 'D':
				shapeName = Messages.SHAPES[3];
				message = Messages.CIRCLE_RADIOUS;
				double radious =  input(message);
				double resultRadious= service.getArea(radious, radious, shapeName);
				// area calculation using service object functions
				message = Messages.RESULT_CIRCLE;
				printResult("Result",resultRadious);
				break;
			default:
				message = Messages.DEFAULT_MESSAGE;
				System.out.println(message);
			}
			message = Messages.CONTINUE_MESSAGE;
			System.out.println(message);
			cont = scanChar.next().charAt(0);
		}while(cont=='Y'||cont=='y');
	}

	/*
	 * @param String as a message string to print result
	 * @param double value of message to print value
	 */
	private static void printResult(String string, double result) {
		System.out.println(string+" "+result);
	}

	/*
	 * @param String as a message string to print message before taking input
	 */
	private static double input(String message) {
		Scanner scanNumbers = new Scanner(System.in);
		System.out.println(message);
		double input = scanNumbers.nextDouble();
		if(input<0){
			System.out.println(Messages.DIMENTION_ERROR);
			return input(message);
		}
		return input;
	}
	
}
