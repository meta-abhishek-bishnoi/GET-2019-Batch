/**
 * @author Abhishek Bishnoi
 * @since Aug 1, 2019
 * This class contains Methods for performing mathematics operations on a infix String using Stack
 */
package utility;

import java.util.Stack;

public class Evalution {
	/**
	 * This Function returns result in the form of int
	 * @param expression in string as infix form
	 * @return int value
	 * Assumption We assume that input will comes into proper spacing and format
	 */
	public int evalute(String expression){
		char[] tokens = expression.toCharArray();
		// Stack for Operands 
        Stack<Integer> operands = new Stack<Integer>(); 
        // Stack for Operators 
        Stack<Character> operator = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) 
        { 
             // Current token is a whitespace so skiiping them
            if (tokens[i] == ' ') 
                continue; 
            /**
             * if we got a numeric value in characters
             */
            if (tokens[i] >= '0' && tokens[i] <= '9') 
            { 
                StringBuffer digit = new StringBuffer(); 
                // if number is more then 2 digit 
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
                    digit.append(tokens[i++]); 
                operands.push(Integer.parseInt(digit.toString())); 
            } 
            else if (tokens[i] == '(' ) {
            	operator.push(tokens[i]);
            	// if we getting '(' or '{' braces then pushing values into stack 
            }else if (tokens[i] == ')') 
            { 
            	// if we getting closing braces
                while (operator.peek() != '(') 
                	operands.push(applyOperation(operator.pop(), operands.pop(), operands.pop())); 
                operator.pop(); 
            } 
            else if (tokens[i] == '+' || tokens[i] == '-' || 
                     tokens[i] == '*' || tokens[i] == '/' || tokens[i]=='<' || tokens[i]=='>') 
            { 
                // While top of 'operator' has same or greater precedence to current 
                // token, which is an operator. Apply operator on top of 'operator' 
                // to top two elements in values stack 
                while (!operator.empty() && hasPrecedence(tokens[i], operator.peek())) 
                	operands.push(applyOperation(operator.pop(), operands.pop(), operands.pop())); 
                operator.push(tokens[i]); 
            } 
        } 
        // Entire expression has been parsed at this point, apply remaining operator to remaining values 
        while (!operator.empty()) 
        	operands.push(applyOperation(operator.pop(), operands.pop(), operands.pop())); 
        return operands.pop().intValue(); 
	}
	/**
	 * Checking Precedence of Operators
	 * @param operator1
	 * @param operator2
	 * @return values true or false
	 */
	public boolean hasPrecedence(char operator1, char operator2) 
    { 
        if (operator2 == '(' || operator2 == ')') 
            return false; 
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) 
            return false; 
        if ((operator1 == '*' || operator1 == '/' ||operator1 == '+' || operator1 == '-' ) && (operator2 == '<' || operator2 == '>')) 
            return false; 
        else
            return true; 
    } 
	/**
	 * applying operations as per operator and precedence
	 * @param operator
	 * @param secondNumber
	 * @param firstNumber
	 * @return
	 */
    public int applyOperation(char operator,int secondNumber, int firstNumber) 
    { 
        switch (operator) 
        { 
        case '+': 
            return firstNumber + secondNumber; 
        case '-': 
            return firstNumber - secondNumber; 
        	
        case '<':
        	if(secondNumber<firstNumber) // if first number is small then return 1 otherwise 0
        		return 1;
        	else
        		return 0;
        case '>':
        	if(firstNumber>secondNumber) // if first number is greater then return 1 else 0
        		return 0;
        	else
        		return 1;
        		
        case '*': 
            return firstNumber * secondNumber; 
        case '/': 
        	if (secondNumber == 0){
        		/**
        		 * throw an exception when second value is zero
        		 */
        		throw new AssertionError("Cannot divide by zero"); 
    		}
            return firstNumber / secondNumber; 
        } 
        return 0; 
    }
}
