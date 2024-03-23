package studentmanagement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public static boolean isValidInput(String input, boolean isValidName) {
		input = input.trim();
		if (input.isEmpty()) {
			System.err.println("Field cannot be left empty!!");
		} else if (isValidString(input)) {
			if (validateFullName(input)) {
				isValidName = true;
			} else {
				System.err.println("Please enter your full name!!");
			}
		} else {
			System.err.println("Name should only contain alphabetic character!!");
		}
		return isValidName;
	}

	public static boolean isValidString(String input) {
		// Regular expression to match string with spaces in between words
		String regex = "^[a-zA-Z ]+$"; // Allows only alphabets and spaces
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	public static boolean validateFullName(String fullName) {
		// to check the input containts the space or not
		if (!fullName.contains(" ")) {
			return false;
		}
		// to check input is more than single word or not
		String[] parts = fullName.split(" ");
		if (parts.length >= 2) {
			return true;
		}
		return true;
	}

	public static boolean integerValidation(String input) {
		if (!input.isEmpty()) {
			try {
				Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean characterValidation(String input) {
		// Check if the input is not null and not empty
		if (input != null && !input.isEmpty()) {
			// Check if the input contains only one character
			if (input.length() == 1) {
				// Check if the input is a character
				char character = input.charAt(0);
				return Character.isLetter(character); // Check if the character is a letter
			}
		}
		return false;
	}
}




















//else if (input.startsWith(" ")) {
//	System.err.println("field is blank,Please Enter Full Name!!");
//}else if (input.matches("[a-zA-Z]+")) {
//	isValidName = true;
//}
