/*
 * This Class Perform Operations on String as a Main Method
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 13-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.SpecificationQn1_Messages;
import meta.helper.SpecificationQn1_StringImple;

public class SpecificationQn1 {

	public static void main(String[] args) {
		Scanner scanString = new Scanner(System.in); 
		// java.util.scanner Class  object 
		SpecificationQn1_StringImple stringObject = new SpecificationQn1_StringImple();
		// object of service class 
		int messageLength = SpecificationQn1_Messages.ARRAY_CHOICE_MESSAGE.length;
		/*
		 * printing User Choice Messages
		 */
		for(int i=0; i<messageLength; i++)
		{
			String message = SpecificationQn1_Messages.ARRAY_CHOICE_MESSAGE[i];
			System.out.println(message);
		}
		char userChoice = scanString.next().charAt(0);
		String stringOne="";
		String stringTwo="";
		switch(userChoice){
			case 'a':
			case 'A': stringOne = getInput(SpecificationQn1_Messages.FIRST_STRING_MESSAGE);
					  // calling getInput(message) for taking user input and printing messages 
					  stringTwo = getInput(SpecificationQn1_Messages.SECOND_STRING_MESSAGE);
					  int isEqual = stringObject.isEquals(stringOne, stringTwo);
					  // comparing if two strings are equal calling function with service object
					  String message = (isEqual==1)?SpecificationQn1_Messages.STRING_ISEQUAL_TRUE:SpecificationQn1_Messages.STRING_ISEQUAL_FALSE;
					  System.out.println(message);
				break;
			case 'b':
			case 'B': stringOne = getInput(SpecificationQn1_Messages.STRING_INPUT_MESSAGE);
					  String reverseString = stringObject.reverseString(stringOne);
					  // calling function with service object to get reverse of a string
					  System.out.println(SpecificationQn1_Messages.STRING_REVERSE_MESSAGE+reverseString);
				break;
			case 'c':
			case 'C': stringOne = getInput(SpecificationQn1_Messages.STRING_INPUT_MESSAGE);
					  String zigZagString = stringObject.convertStringToZigZag(stringOne);
					  // calling fn with serviceObject to get zigzap word string
					  System.out.println(SpecificationQn1_Messages.STRING_ZIG_ZAG_MESSAGE+zigZagString);
					  break;
			case 'd':
			case 'D': stringOne = getInput(SpecificationQn1_Messages.STRING_INPUT_MESSAGE);
					  String largestWord = stringObject.largestWord(stringOne);
					  // calling fn to find largest word in a sentence
					  System.out.println(SpecificationQn1_Messages.STRING_LARGET_MESSAGE+largestWord);
					  //System.out.println("We are working on this");
					  break;
			default: System.out.println(SpecificationQn1_Messages.DEFAULT_STRING_MESSAGE);
		}
	}

	/*
	 * @param String this contains message to print before taking input
	 * @return String Input String from User removing unnecessary spaces
	 */
	private static String getInput(String firstStringMessage) {
		Scanner scanString = new Scanner(System.in);
		System.out.println(firstStringMessage);
		String inputString = scanString.nextLine();
		return inputString.trim();
	}

}
