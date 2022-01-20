package helper;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with Username already exist in DB");
		// TODO Auto-generated constructor stub
	}


	public UserFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	

}