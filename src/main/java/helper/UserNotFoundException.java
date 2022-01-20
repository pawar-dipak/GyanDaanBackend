package helper;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User with Username Not exist in DB");
		// TODO Auto-generated constructor stub
	}


	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
