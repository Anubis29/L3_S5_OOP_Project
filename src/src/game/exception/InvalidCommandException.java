package src.game.exception;

public class InvalidCommandException extends GameException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCommandException(String command) {
		super("\""+ command + "\" is not a valid command!");
	}
}
