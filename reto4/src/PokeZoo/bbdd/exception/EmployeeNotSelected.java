package PokeZoo.bbdd.exception;

public class EmployeeNotSelected extends Exception {
	
	private static final long serialVersionUID = -4517915205082100250L;

	public EmployeeNotSelected(String message){
		super(message);
	}
	
	public EmployeeNotSelected(Throwable cause) {
		super(cause);
	}
}