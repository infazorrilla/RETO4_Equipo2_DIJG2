package PokeZoo.bbdd.exception;

/**
 * Exception that occurs when a database Selects doesn't return any row
 */
public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = -4517915205082100250L;

	public NotFoundException(String message){
		super(message);
	}
	
	public NotFoundException(Throwable cause) {
		super(cause);
	}
}