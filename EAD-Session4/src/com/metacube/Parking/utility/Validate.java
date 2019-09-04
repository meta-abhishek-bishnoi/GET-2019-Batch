/**
* this class is for validating employee registration
* @author Abhishek Bishnoi
* @since Aug 29,2019
*/
package com.metacube.Parking.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.metacube.Parking.model.Employee;

public class Validate {
	/**
	* @param Employee Object
	* @return String as message if there is no error then string is empty
	*/
	public static String getValidation(Employee employee) {
		StringBuilder error = new StringBuilder();
		error.append("");
		String name = employee.getEmployeeName();
		if(!validateName(name)){
			error.append("<br>Please Enter A Proper Name");
		}
		String password = employee.getEmployeePassword();
		String confirmPassword = employee.getEmployeeConfirmPassword();
		if(!password.equals(confirmPassword)){
			error.append("<br>Password and Confirm Password Must Be Same");
		}
		if(! validatePassword (password)){
			error.append("<br>Password Must have at least 8 characters");
			error.append("<br>Password Must have One Lower and One Upper Character");
			error.append("<br>Passwrod Must Have One Digit and One Special Character");
		}
		String email = employee.getEmployeeEmail();
		if(! validateEmail(email)){
			error.append("<br>Please Enter A Valid Email Id");
		}
		String contactNumber = employee.getEmployeeContact();
		if(! validateContactNo(contactNumber)){
			error.append("<br> Contact Number Must Be A 10 digit number");
		}
		return error.toString();
	}

	private static boolean validateContactNo(String contactNumber) {
		if (contactNumber.matches("\\d{10}")){
			return true;
		}
		else{
			return false;
		}
	}

	private static boolean validatePassword(String password) {
		final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	private static boolean validateEmail(String email) {
		String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean validateName(String name) {
		String NAME_PATTERN = "\\p{Upper}(\\p{Lower}+\\s?)";
	    String patternName = "(" + NAME_PATTERN + "){1,3}";
		return name.matches(patternName);
	}

}
