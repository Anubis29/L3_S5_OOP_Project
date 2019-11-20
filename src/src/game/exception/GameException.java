package src.game.exception;

import src.game.core.Game;

public class GameException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Game mGame;
	
	GameException(Game game){
		this(game, null);
	}
	
	public GameException(Game game, String msg) {
		super(msg);
		mGame = game;
	}
	
	public Game getGame() {
		return mGame;
	}
}
