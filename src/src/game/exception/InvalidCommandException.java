package src.game.exception;


public class InvalidCommandException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidCommandException(String msg) {
		super(msg);
	}
}
