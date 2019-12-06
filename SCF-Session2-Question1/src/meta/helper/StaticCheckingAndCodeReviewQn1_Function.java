/*
 * These Contains Supportive Function Of Main Class to
 * But this must contains a structure for all base type values
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 12-July-2019
 */
package meta.helper;

import java.util.Scanner;

public class StaticCheckingAndCodeReviewQn1_Function 
{
	int base=16;
	// this program is for hex and decimal conversion so base is always 16
	StaticCheckingAndCodeReviewQn1_HexCalcImpl hexCal = new StaticCheckingAndCodeReviewQn1_HexCalcImpl();
	String firstNumber; // first variable for operation
	String secondNumber; // second variable for operation
	/*
	 * This is for switch choice 1 
	 * @param choice for validation 
	 * @return returns nothing(void)
	 * This prints result of Addition (HEX VALUES)
	 */
	public void functionAddTwoNumbers(int choice)
	{
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		// calling function to take input
		secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		System.out.println(firstNumber+" "+secondNumber);
		/*
		 * for validating inputs @return boolean
		 */
		if( getValidation(firstNumber,secondNumber,choice )==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.ADDITION_VALIDATION_ERROR);
			 return;
		 }
		String resultAddition = hexCal.addTwoBaseNumbers(firstNumber, secondNumber, base);
		// calling function for addition
		printResult(StaticCheckingAndCodeReviewQn1_Messages.ADDITION_RESULT_MESSAGE,resultAddition);
		// calling function to print result
	}
	/*
	 * for switch case choice 
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * This prints Subtraction Of 2 HEX values
	 */
	public void functionSubtractTwoNumbers(int operationUserChoice) {
		
		 firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		 // calling function to take input
		 secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		 if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.SUBTRACTION_VALIDATION_ERROR);
			 return;
		 }
		 String resultSubtract = hexCal.subtractTwoBaseNumbers(firstNumber, secondNumber, base);
		 // calling function for subtraction @return String 
		 printResult(StaticCheckingAndCodeReviewQn1_Messages.ADDITION_RESULT_MESSAGE,resultSubtract);
		
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * Prints Multiplication of 2 HEX Value
	 */
	public void functionMultiplyTwoNumbers(int operationUserChoice){
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.MULTIPLICATION_VALIDATION_ERROR);
			 return;
		 }
		String resultMultiply = hexCal.multiplyTwoBaseNumbers(firstNumber, secondNumber, base);
		//calling funtion to multiply 2 values 
		 printResult(StaticCheckingAndCodeReviewQn1_Messages.MULTIPLY_RESULT_MESSAGE,resultMultiply);
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * Prints Division of 2 HEX Value
	 */
	public void functionDivideTwoNumbers(int operationUserChoice)
	{
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.DIVISION_VALIDATION_ERROR);
			 return;
		 }
		String resultDivision = hexCal.divideTwoBaseNumbers(firstNumber, secondNumber, base);
		printResult(StaticCheckingAndCodeReviewQn1_Messages.DIVISION_RESULT_MESSAGE,resultDivision);
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * prints if both hex values are equal or not
	 */
	public void functionIsEqualTo(int operationUserChoice){
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.VALIDATION_ERROR);
			 return;
		 }
		boolean resultIsEqual = hexCal.isEqual(firstNumber, secondNumber);
		String isEqualString=""+resultIsEqual;
		printResult(StaticCheckingAndCodeReviewQn1_Messages.IS_EQUAL_MESSAGE,isEqualString);
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * prints 1st hex value is greater or not
	 */
	public void functionIsGreaterThen(int operationUserChoice){
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.VALIDATION_ERROR);
			 return;
		 }
		boolean resultIsGreaterThen = hexCal.isGreaterThen(firstNumber, secondNumber);
		String isGreaterString = ""+resultIsGreaterThen;
		printResult(StaticCheckingAndCodeReviewQn1_Messages.IS_GREATER_MESSAGE,isGreaterString);
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * prints 1st hex value is less or not
	 */
	public void functionIsLessThen(int operationUserChoice){
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FIRST_VALUE_MESSAGE);
		secondNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.SECOND_VALUE_MESSAGE);
		if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.VALIDATION_ERROR);
			 return;
		 }
		boolean resultIsGreaterThen = hexCal.isLessThen(firstNumber, secondNumber);
		String isGreaterString = ""+resultIsGreaterThen;
		printResult(StaticCheckingAndCodeReviewQn1_Messages.IS_LESS_MESSAGE,isGreaterString);
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * prints Decimal values of a Hex value
	 */
	public void functionConvertTODecimal(int operationUserChoice){
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.TO_DECIMAL_INPUT);
		secondNumber = "0";
		if( getValidation(firstNumber,secondNumber,operationUserChoice)==false ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.VALIDATION_ERROR);
			 return;
		 }
		String decimalValue = hexCal.convertToDecimal(firstNumber, base);
		printResult(StaticCheckingAndCodeReviewQn1_Messages.TO_DECIMAL_MESSAGE,decimalValue);
	}
	/*
	 * @param operationUserChoice for validations
	 * @return nothing (void)
	 * prints Hex value Of a Decimal Value
	 */
	public void functionConvertFromDecimal(int operationUserChoice){
		firstNumber = getInput(StaticCheckingAndCodeReviewQn1_Messages.FROM_DECIMAL_INPUT);
		if( Integer.parseInt(firstNumber)>0 ){
			 System.out.println(StaticCheckingAndCodeReviewQn1_Messages.VALIDATION_ERROR);
			 return;
		 }
		String hexaDecimalValue = hexCal.convertFromDecimal(firstNumber, base);
		printResult(StaticCheckingAndCodeReviewQn1_Messages.FROM_DECIMAL_MESSAGE,hexaDecimalValue);
	}
	/*
	 * @param firstNumber is a String value in Hexadecimal format
	 * @param secondNumber is a String value in Hexadecimal format
	 * @param choice is choice input for checking conditions
	 * @return boolean value if they are satisfying or not
	 */
	private static boolean getValidation( String firstNumber, String secondNumber, int choice ) {
		StaticCheckingAndCodeReviewQn1_HexCalcImpl hexCal = new StaticCheckingAndCodeReviewQn1_HexCalcImpl();
		int base=16;
		int firstValue = Integer.parseInt(hexCal.convertToDecimal(firstNumber, base));
		int secondValue = Integer.parseInt(hexCal.convertToDecimal(secondNumber, base));
		if(choice==1||choice==3||choice==5||choice==6||choice==7){
			if(firstValue>=0||secondValue>=0)
				return true;
		}else if(choice==2){
			if(firstValue>=0||secondValue>=0||(secondValue>firstValue))
				return true;
		}else if(choice==4){
			if(firstValue>=0||secondValue>0)
				return true;
		}else if(choice==8)
		{
			if(firstValue>=0)
				return true;
		}
		return false;
	}
	/*
	 * @param String a constant message
	 * @param String value for that message
	 * @return void
	 * for printing values
	 */
	private void printResult( String additionResultMessage,String result ) {
		System.out.println(additionResultMessage+" "+result);
	}
	/*
	 * @param message this takes a string message to print each time before taking input 
	 * @return return input String into Upper Case
	 */
	private String getInput(String message) {
		Scanner scanString = new Scanner(System.in);
		System.out.println(message);
		String inputString = scanString.next().toUpperCase().trim();
		return inputString;
	}
}
