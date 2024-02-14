package git.misaeldearaujo.library.exception;

public class FullBookException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FullBookException() {
		super("caracteres ultrapassaram");
	}
	
	public FullBookException(String message) {
		super(message);
	}
}
