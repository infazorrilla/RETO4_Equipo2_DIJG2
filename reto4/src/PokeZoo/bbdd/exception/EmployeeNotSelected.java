package PokeZoo.bbdd.exception;

/**
 * Exception that occurs when a row isn't selected on tableEmployee
 */
public class EmployeeNotSelected extends Exception {
	
	private static final long serialVersionUID = -4517915205082100250L;

	public EmployeeNotSelected(String message){
		super(message);
	}
	
	public EmployeeNotSelected(Throwable cause) {
		super(cause);
	}
}