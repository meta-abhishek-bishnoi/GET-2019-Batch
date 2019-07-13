/*
 * This is Problem is on Hexadecimal Operations and Decimal conversion
 * But this must contains a structure for all base type values
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 11-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.StaticCheckingAndCodeReviewQn1_Messages;
import meta.helper.StaticCheckingAndCodeReviewQn1_Function;
import meta.helper.StaticCheckingAndCodeReviewQn1_HexCalcImpl;

public class StaticCheckingAndCodeReviewQn1
{
	public static void main(String[] args)
	{
		StaticCheckingAndCodeReviewQn1_Function helper = new StaticCheckingAndCodeReviewQn1_Function();
		Scanner scanNumber = new Scanner(System.in);// to take input num value
		System.out.println(StaticCheckingAndCodeReviewQn1_Messages.CHOICE_OPERRATION);
		int messageArrayLength = StaticCheckingAndCodeReviewQn1_Messages.OPTION_STRING_ARRAY.length;
		// messageArrayLength is length of Assgnment2StringMessages Array
		/*
		 * this for loop prints Message of Array from class Assgnment2StringMessages
		 */
		for(int i=0; i<messageArrayLength; i++)
		{
			if(i%2==0)
				System.out.println(); // adding new line after each 2 entry
			String message = StaticCheckingAndCodeReviewQn1_Messages.OPTION_STRING_ARRAY[i];
			System.out.print(" "+message+"\t\t");
		}
		System.out.println();
		/*
		 * this try catch block is used to prevent from I/O exception
		 */
		int operationUserChoice=0;
		try{
			operationUserChoice = scanNumber.nextInt();
			// this will take a choice input from user
		}catch(Exception exception)
		{
			System.out.println(StaticCheckingAndCodeReviewQn1_Messages.INPUT_EXCEPTION_MESSAGE);
		}
		switch(operationUserChoice)
		{
			case 1: helper.functionAddTwoNumbers( operationUserChoice );
				break;
			case 2: helper.functionSubtractTwoNumbers( operationUserChoice );
				break;
			case 3: helper.functionMultiplyTwoNumbers(operationUserChoice);
				break;
			case 4: helper.functionDivideTwoNumbers(operationUserChoice);
				break;
			case 5: helper.functionIsEqualTo( operationUserChoice);
				break;
			case 6: helper.functionIsGreaterThen(operationUserChoice);
				break;
			case 7: helper.functionIsLessThen(operationUserChoice);
				break;
			case 8: helper.functionConvertTODecimal(operationUserChoice);
				break;
			case 9: helper.functionConvertFromDecimal(operationUserChoice);
				break;
			default:
				break;
		}
	}
}
