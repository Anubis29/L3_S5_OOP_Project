package src.game.exception;

import src.game.core.Game;

public class InvalidCommandException extends GameException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCommandException(Game game, String command) {
		super(game, "\""+ command + "\" is not a valid command!");
	}
}
