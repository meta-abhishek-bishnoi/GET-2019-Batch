/*
 * This is driven class for getting area with different different shapes
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.SpecificationQn3_Message;
import meta.helper.SpecificationQn3_ShapeImplementation;

public class SpecificationQn3 {
	public static void main(String[] args) {
		Scanner scanChar = new Scanner(System.in);
		// java.util.Scanner object
		SpecificationQn3_ShapeImplementation service = new SpecificationQn3_ShapeImplementation();
		// object to access service 
		String messages[] = SpecificationQn3_Message.CHOICE_INPUT;
		String shapes[] = SpecificationQn3_Message.SHAPES;
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
				shapeName = SpecificationQn3_Message.SHAPES[0];
				message = SpecificationQn3_Message.TRIANGLE_HEIGHT;// taking input by calling a function
				double heightTri = input(message);
				message = SpecificationQn3_Message.TRIANGLE_BASE;
				double baseTri =  input(message);
				double resultTri = service.getArea(heightTri, baseTri, shapeName); 
				// area calculation using service object functions
				message = SpecificationQn3_Message.RESULT_TRIANGLE;
				printResult("Result",resultTri);
				break;
			case 'b':
			case 'B':
				shapeName = SpecificationQn3_Message.SHAPES[1];
				message = SpecificationQn3_Message.RECT_HEIGHT;
				double heightRect = input(message);
				message = SpecificationQn3_Message.RECT_WIDTH;
				double widthRect =  input(message);
				double resultRect = service.getArea(heightRect, widthRect, shapeName);
				// area calculation using service object functions
				message = SpecificationQn3_Message.RESULT_RECTANGLE;
				printResult("Result",resultRect);
				break;
			case 'c':
			case 'C':
				shapeName = SpecificationQn3_Message.SHAPES[2];
				message = SpecificationQn3_Message.SQURE_SIDE;
				double side =  input(message);
				double resultSqure = service.getArea(side, side, shapeName);
				// area calculation using service object functions
				message = SpecificationQn3_Message.RESULT_SQURE;
				printResult("Result",resultSqure);
				break;
			case 'd':
			case 'D':
				shapeName = SpecificationQn3_Message.SHAPES[3];
				message = SpecificationQn3_Message.CIRCLE_RADIOUS;
				double radious =  input(message);
				double resultRadious= service.getArea(radious, radious, shapeName);
				// area calculation using service object functions
				message = SpecificationQn3_Message.RESULT_CIRCLE;
				printResult("Result",resultRadious);
				break;
			default:
				message = SpecificationQn3_Message.DEFAULT_MESSAGE;
				System.out.println(message);
			}
			message = SpecificationQn3_Message.CONTINUE_MESSAGE;
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
			System.out.println(SpecificationQn3_Message.DIMENTION_ERROR);
			return input(message);
		}
		return input;
	}
	
}
