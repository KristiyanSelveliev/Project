package validator;

public class Validator {
	
	private static final String VALIDATE_EMAIL = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	private static final String VALIDATE_USERNAME = "^[0-9a-zA-Z]{1,100}";

	private static final String VALIDATE_PASSWORD = "[0-9a-zA-Z]{1,100}";
	
	
	
	public static boolean validUsername(String username) {

		if (username != null && !username.equals("")) {

		return username.matches(VALIDATE_USERNAME);

		}

		return false;
	}
	
	public static boolean validPassword(String password) {

		if (password != null && !password.equals("")) {

		return password.matches(VALIDATE_PASSWORD);

		}

		return false;

	}
	
	public static boolean validEMail(String email) {

		if (email != null && !email.equals("")) {

		return email.matches(VALIDATE_EMAIL);

		}

		return false;

		}

	}

