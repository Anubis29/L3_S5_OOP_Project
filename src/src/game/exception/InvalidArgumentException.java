package src.game.exception;

import src.game.core.Command;
import src.game.core.Game;

public class InvalidArgumentException extends GameException {
	private static final long serialVersionUID = 1L;
	
	private final Command CMD;

	public InvalidArgumentException(Game game, Command cmd, String msg) {
		super(game, "Failed to run " + cmd.toString() + " : " + msg);
		this.CMD = cmd; 
	}
	
	public Command getCommand() {
		return this.CMD;
	}
}
