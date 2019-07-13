/*
 * This is an Interface for general type conversion
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 11-July-2019
 */
package meta.helper;

public interface StaticCheckingAndCodeReviewQn1_HexCalcInterface 
{
	public String convertFromDecimal( String number, int base );
	public String convertToDecimal( String number, int base );
	public String addTwoBaseNumbers( String firstNumber, String secondNumber, int base );
	public String subtractTwoBaseNumbers( String firstNumber, String secondNumber, int base );
	public String multiplyTwoBaseNumbers( String firstNumber, String secondNumber, int base );
	public String divideTwoBaseNumbers( String firstNumber, String secondNumber, int base );
	public boolean isEqual( String firstNumber, String secondNumber );
	public boolean isGreaterThen( String firstNumber, String secondNumber );
	public boolean isLessThen( String firstName, String secondName );
}
