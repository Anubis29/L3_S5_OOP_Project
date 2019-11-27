package src.game.exception;

import src.game.core.Command;

public class InvalidArgumentException extends GameException {
	private static final long serialVersionUID = 1L;
	
	private final Command CMD;

	public InvalidArgumentException(Command cmd, String msg) {
		super("Failed to run " + cmd.toString() + " : " + msg);
		this.CMD = cmd; 
	}
	
	public Command getCommand() {
		return this.CMD;
	}
}
