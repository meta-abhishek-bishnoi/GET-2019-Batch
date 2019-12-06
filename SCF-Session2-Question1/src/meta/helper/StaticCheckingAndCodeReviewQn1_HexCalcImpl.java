/* HexCalcImplementation class is used as a service class
 * this Returns the results of requesting Function
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 11-July-2019
 */
package meta.helper;

public class StaticCheckingAndCodeReviewQn1_HexCalcImpl implements StaticCheckingAndCodeReviewQn1_HexCalcInterface{

	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#convertFromDecimal(java.lang.String, int) 
	 * @param number is a decimal value number in the string format(only Numbers From Main Method)
	 * @param base is for base conversion value (in this program it is always 16)
	 * @return A hexaDeciaml value in String format (In String Characters are in Capital)
	 * Assumption String number contains only integer value in string
	 * Assumption Return String Contains only capital characters.
	 */
	@Override
	public String convertFromDecimal( String number, int base ) {
		char hexCharArray[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
		// this array is used for creating hexadecimal String
		base = 16; // base is 16 because hex to decimal conversion
		String hexaDecimalString=""; 
		int remaining=0; 
		int decimalNumber = Integer.parseInt( number ); // convert Decimal String to integer form
		/*
		 * this while loop is calculating hex value and storing into 
		 * String hexaDecimalString as hexaDecimal Number
		 */
		if("0".equals(number))
			hexaDecimalString = ""+hexCharArray[0]+hexaDecimalString;
		while ( decimalNumber > 0 )
		{
			remaining = decimalNumber%base;
			hexaDecimalString = ""+hexCharArray[remaining]+hexaDecimalString;
			decimalNumber = decimalNumber/base;
		}
		return hexaDecimalString;
	}
	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#convertToDecimal(java.lang.String, int)
	 * @param number is a hexaDecimal value (letter are in Capital Format from  main method)
	 * @param base is for base conversion value (in this program it is always 16)
	 * @return A String which Contains Integer in form of String
	 * Assumption number String Contains only capital characters
	 * Assumption number String contains A valid HexNumber
	 * Assumption number is  positive
	 */
	@Override
	public String convertToDecimal( String number, int base ) {
		String decimalValueString="";
		int resultIntValue=0; // Store Converted Value From HexaDecimal to Decimal
		int stringLength = number.length();
		char hexCharArray[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		base = 16;
		// this array is used for getting value of Hex Number
		/*
		 * this for loop is calculating the Decimal Value from HexaDecimal String
		 * where we get each char from String and calculate corresponding it
		 * and final value is calculated into resultIntValue
		 * which converted to String and return 
		 */
		for(int i=0; i<stringLength;i++)
		{
			char currentChar = number.charAt(i);
			int currentValue = (int) (getIndexOf(currentChar,hexCharArray)*Math.pow(base,stringLength-1-i));
			// getIndexOf() function is calling for getting index of that value in array
			resultIntValue += currentValue;
		}
		decimalValueString = ""+resultIntValue;
		return decimalValueString;
	}
	/*
	 * this is supporting function of ConvertToDecimal() function for getting index of character
	 * @param currentChar is character of hex String
	 * @param hexCharArray[] is array of HexaDecimal Values
	 * @return index of that particular character
	 * Assumption currentChar is a Valid Hex char
	 */
	public int getIndexOf(char currentChar, char[] hexCharArray)
	{
		int index=-1,noVal=0;
		for(char ch: hexCharArray)
		{
			index++;
			if(ch==currentChar)
			{
				return index;
			}
		}
		/*
		 * returns 0 if no character is found in the array
		 * this means input hex value is wrong then
		 * if we return -1 then it raise an error in that program so 
		 * prevent from exception we retrun 0
		 */
		return noVal;
	}
	
	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#addTwoBaseNumbers(java.lang.String, java.lang.String, int)
	 * @param firstNumber is a HexaDecimal String Value
	 * @param secondNumber is a HexaDecimal String Value
	 * @param base is for base conversion value (in this program it is always 16)
	 * @return returns a Addition Of two hexaDeciaml Numbers in String form
	 * Assumption String's Contains only capital characters
	 * Assumption String's String contains A valid HexNumber
	 * Assumption both values are positive
	 */
	@Override
	public String addTwoBaseNumbers( String firstNumber, String secondNumber, int base ) {
		base = 16;
		String firstNumberDecimalString = convertToDecimal(firstNumber,base);
		// return A Decimal Number of First Value in String 
		String secondNumberDecimalString = convertToDecimal(secondNumber,base); 
		int firstNumberDecimalInteger = Integer.parseInt(firstNumberDecimalString);
		int secondNumberDecimalInteger = Integer.parseInt(secondNumberDecimalString);
		int additionOfNumber = firstNumberDecimalInteger+secondNumberDecimalInteger;
		String decimalStringAddition = ""+additionOfNumber;
		String resultSumInHexaDecimal = convertFromDecimal(decimalStringAddition,base);
		return resultSumInHexaDecimal;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#subtractTwoBaseNumbers(java.lang.String, java.lang.String, int)
	 * @param firstNumber is a HexaDecimal String Value
	 * @param secondNumber is a HexaDecimal String Value
	 * @param base is for base conversion value (in this program it is always 16)
	 * @return returns a Subtraction Of two hexaDeciaml Numbers in String form
	 * Assumption String's Contains only capital characters
	 * Assumption String's String contains A valid HexNumber
	 * Assumption First Number is Greater Then Second Number
	 * Assumption both values are positive
	 */
	@Override
	public String subtractTwoBaseNumbers( String firstNumber, String secondNumber, int base ) {
		String firstNumberDecimalString = convertToDecimal(firstNumber,base);
		// return A Decimal Number of First Value in String 
		String secondNumberDecimalString = convertToDecimal(secondNumber,base);
		// return A Decimal Number of First Value in String 
		int firstNumberDecimalInteger = Integer.parseInt(firstNumberDecimalString);
		// converting String to int form
		int secondNumberDecimalInteger = Integer.parseInt(secondNumberDecimalString);
		if(firstNumberDecimalInteger<secondNumberDecimalInteger)
		{
			return StaticCheckingAndCodeReviewQn1_Messages.ERROR_MESSAGE_SUBTRACTION;
			// as per requirement operation will be in positive numbers only
		}
		int subtractionOfNumber = firstNumberDecimalInteger-secondNumberDecimalInteger;
		// subtraction to Decimal Numbers
		String decimalStringSubtraction = ""+subtractionOfNumber;
		// converting result to String from int
		String resultSubtractInHexaDecimal = convertFromDecimal(decimalStringSubtraction,base);
		// return A HexaDecimal Number Of Decimal String
		return resultSubtractInHexaDecimal;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#multiplyTwoBaseNumbers(java.lang.String, java.lang.String, int)
	 * @param firstNumber is a HexaDecimal String Value
	 * @param secondNumber is a HexaDecimal String Value
	 * @param base is for base conversion value (in this program it is always 16)
	 * @return returns Multiplication Of two hexaDeciaml Numbers in String form
	 * Assumption String's Contains only capital characters
	 * Assumption String's String contains A valid HexNumber
	 * Assumption both values are positive
	 */
	@Override
	public String multiplyTwoBaseNumbers(String firstNumber, String secondNumber, int base) {
		base = 16;
		String firstNumberDecimalString = convertToDecimal(firstNumber,base);
		// return A Decimal Number of First Value in String 
		String secondNumberDecimalString = convertToDecimal(secondNumber,base);
		// return A Decimal Number of First Value in String 
		int firstNumberDecimalInteger = Integer.parseInt(firstNumberDecimalString);
		// converting String to int form
		int secondNumberDecimalInteger = Integer.parseInt(secondNumberDecimalString);
		int multiplicationOfNumber = firstNumberDecimalInteger*secondNumberDecimalInteger;
		// multipling to Decimal Numbners
		String decimalStringMultiplication = ""+multiplicationOfNumber;
		// converting result to String from int
		String resultMultInHexaDecimal = convertFromDecimal(decimalStringMultiplication,base);
		// return A HexaDecimal Number Of Decimal String
		return resultMultInHexaDecimal;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#divideTwoBaseNumbers(java.lang.String, java.lang.String, int)
	 * @param firstNumber is a HexaDecimal String Value
	 * @param secondNumber is a HexaDecimal String Value
	 * @param base is for base conversion value (in this program it is always 16)
	 * @return returns Division Of two hexaDeciaml Numbers in String form (these are integer values not frictional{double} values)
	 * Assumption String's Contains only capital characters
	 * Assumption String's String contains A valid HexNumber
	 * Assumption secondNumber is not zero
	 * Assumption both values are positive 
	 */
	@Override
	public String divideTwoBaseNumbers(String firstNumber, String secondNumber,int base) {
		base = 16;
		String firstNumberDecimalString = convertToDecimal(firstNumber,base);
		// return A Decimal Number of First Value in String 
		String secondNumberDecimalString = convertToDecimal(secondNumber,base);
		// return A Decimal Number of First Value in String 
		int firstNumberDecimalInteger = Integer.parseInt(firstNumberDecimalString);
		// converting String to int form
		int secondNumberDecimalInteger = Integer.parseInt(secondNumberDecimalString);
		int divisionResult = (int)(firstNumberDecimalInteger/secondNumberDecimalInteger);
		// division operation in  decimal values
		String divisionResultString = ""+divisionResult;
		String resultDivInHexaDecimal = convertFromDecimal(divisionResultString,base);
		// return A HexaDecimal Number Of Decimal String
		return resultDivInHexaDecimal;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#isEqual(java.lang.String, java.lang.String)
	 * @param firstNumber is a HexaDecimal String Value
	 * @param secondNumber is a HexaDecimal String Value
	 * @return boolean value after comparing
	 * Assumption String's Contains only capital characters
	 * Assumption String's String contains A valid HexNumber
	 */
	@Override
	public boolean isEqual( String firstNumber, String secondNumber ){
		boolean isEqual = true;
		if(firstNumber.length()!=secondNumber.length())
		{
			isEqual=false;
			return isEqual;
			/*
			 * if length is not equal
			 */
		}
		for(int i=0;i<firstNumber.length(); i++)
		{
			if(firstNumber.charAt(i)!=secondNumber.charAt(i))
			{
				isEqual = false;
				return isEqual;
			}
			/*
			 * check if string mismatch anywhere then return false 
			 */
		}
		return isEqual;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.HexCalc#isGreaterThen(java.lang.String, java.lang.String)
	 * @param firstNumber is a HexaDecimal String Value
	 * @param secondNumber is a HexaDecimal String Value
	 * @return boolean value if the firstNumber is greater then second or nor
	 * Assumption String's Contains only capital characters
	 * Assumption String's String contains A valid HexNumber
	 */
	@Override
	public boolean isGreaterThen(String firstNumber, String secondNumber) {
		boolean isGreater=true;
		firstNumber = removeUnwantedZeros(firstNumber);
		secondNumber = removeUnwantedZeros(secondNumber);
		if(firstNumber.length()<secondNumber.length())
		{
			isGreater = false;
			return isGreater;
			/*
			 * if the length of first number is less then second number then it is always small number
			 */
		}
		if(firstNumber.length()>secondNumber.length())
		{
			return isGreater;
			/*
			 * if length of first string is greater then second string then the number is always greater
			 */
		}
		
		for(int i=0; i<firstNumber.length(); i++)
		{
			if(firstNumber.charAt(i)<secondNumber.charAt(i))
			{
				isGreater = false;
				return isGreater;
			}
			/*
			 * in this for loop checking each character
			 * if any character of first string is less then second string 
			 * then first is smaller then second
			 */
		}
		return isGreater;
	}

	@Override
	public boolean isLessThen(String firstNumber, String secondNumber) {
		boolean isLess=true;
		firstNumber = removeUnwantedZeros(firstNumber);
		secondNumber = removeUnwantedZeros(secondNumber);
		if(firstNumber.length()<secondNumber.length())
		{
			return isLess;
			/*
			 * if the length of first number is less then second number then it is always small number
			 */
		}
		if(firstNumber.length()>secondNumber.length())
		{
			isLess = false;
			return isLess;
			/*
			 * if length of first string is greater then second string then the number is always greater
			 */
		}
		
		for(int i=0; i<firstNumber.length(); i++)
		{
			if(firstNumber.charAt(i)>secondNumber.charAt(i))
			{
				isLess = false;
				return isLess;
			}
			/*
			 * in this for loop checking each character
			 * if any character of first string is greter then second string 
			 * then first is larger then second
			 */
		}
		return isLess;
	}
	/*
	 * @param String to remove zero from starting 
	 * @return String after removing starting zero's
	 */
	public String removeUnwantedZeros(String string)
	{
		int index=0;
		for(int i=0; i<string.length(); i++){
			if(string.charAt(i)!=0){
				index = i;
				break;
			}
		}
		String trimString = string.substring(index);
		return trimString;
	}

}
