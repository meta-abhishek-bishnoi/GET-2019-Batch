/*
 * This is Implemented class of String services
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 13-July-2019
 */
package meta.helper;

public class SpecificationQn1_StringImple implements SpecificationQn1_StirngInterface {

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn1_StirngInterface#isEquals(java.lang.String, java.lang.String)
	 * @param stringOne first string for comparison
	 * @param StringTwo second string for comparison
	 * @return int value 1 or 0 as true false 
	 * Assumption String does not contains blank spaces after strings
	 */
	@Override
	public int isEquals(String stringOne, String stringTwo) {
		int result=1;
		/*
		 * if length of strings are not equal then return false
		 */
		if(stringOne.length()!=stringTwo.length()){
			result=0;
			return result;
		}
		int stringLength = stringOne.length();
		/*
		 * if length of strings are equal then checking each character to compare
		 */
		for(int i=0;i<stringLength;i++)
		{
			if(stringOne.charAt(i)!= stringTwo.charAt(i)){
				result=0;
				return result;
			}
		}
		return result; // returns result
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn1_StirngInterface#reverseString(java.lang.String)
	 * @param stringOne string as a input
	 * @return String result string will the reverse of string 
	 * Assumption String does not contains blank spaces after strings
	 */
	@Override
	public String reverseString(String stringOne) {
		String reverseString = "";
		int inputLength = stringOne.length(); // length of @param String
		/*
		 * loop for reversing string
		 */
		for(int i= inputLength-1;i>=0;i--){
			reverseString += stringOne.charAt(i);
		}
		return reverseString;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn1_StirngInterface#convertStringToZigZag(java.lang.String)
	 * @param stringOne string as a input
	 * @return String result string will zipZap String  
	 * Assumption String does not contains blank spaces after strings
	 */
	@Override
	public String convertStringToZigZag(String stringOne) {
		String zipZagString="";
		int inputLength = stringOne.length(); // length of @param String
		/*
		 * logic for zigzag string conversion
		 */
		for(int i=0; i<inputLength; i++)
		{
			char cureentChar = stringOne.charAt(i);
			if(cureentChar>=65&&cureentChar<=90)
			{
				cureentChar = (char)(cureentChar+(char)32);
			}else if(cureentChar>=97&&cureentChar<=122)
			{
				cureentChar = (char)(cureentChar-(char)32);
			}
			zipZagString += ""+cureentChar;
		}
		return zipZagString;
	}

	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn1_StirngInterface#largestWord(java.lang.String)
	 * @param stringOne string as a input
	 * @return String result string will return LargetWord Of the String
	 * Assumption String does not contains blank spaces after strings
	 */
	@Override
	public String largestWord(String stringOne) {
		String largestWord="";
		int maxLength=0;
		int stringLength= stringOne.length();
		int startIndex=0, endIndex=0;
		/*
		 * checking for spaces to get words and get their length
		 */
		for(int i=0; i<stringLength; i++){
			if(stringOne.charAt(i)== ' '){
				endIndex = i-1;
				/*
				 * if next word is largest then previous then will make changes to variable
				 */
				if(maxLength<endIndex-startIndex){
					maxLength = endIndex-startIndex;
					largestWord = subString(stringOne, startIndex, endIndex);
					startIndex = i+1;
				}	
			}
			/*
			 * checking for last words length 
			 */
			if(i==stringLength-1){
				endIndex = i;
				if(maxLength<endIndex-startIndex){
					largestWord = subString(stringOne, startIndex, endIndex);
				}
			}
		}
		return largestWord;
	}

	/*
	 * @param String input String for operations
	 * @startIndex this is starting index for result subString
	 * @startIndex this is last index for result subString
	 * @return a substring where it will return a substring from start index to end index
	 * Assumption String does not contains blank spaces after strings
	 */
	private String subString(String stringOne, int startIndex, int endIndex) {
		String splitString="";
		for(int i=startIndex; i<=endIndex; i++){
			splitString+=stringOne.charAt(i);
		}
		return splitString;
	}
}
