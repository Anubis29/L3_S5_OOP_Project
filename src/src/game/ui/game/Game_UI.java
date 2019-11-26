package src.game.ui.game;

import src.game.core.Game;
import src.game.exception.InvalidUIModeException;
import src.game.ui.UI_Mode;
import src.game.ui.UI_Mode_Selector;

/**
 * <b>GAME_UI</b> is the class managing the interface between the user and the game.
 * Cette classe est une classe "usine" qui permet de créer 
 * @author alexandre
 * @version 0.1
 */

abstract public class Game_UI {
	
	private final Game GAME;
	
	
	public Game_UI(Game game) {
		super(); // Implicit anyway
		this.GAME = game;
	}
	
	public static final Game_UI create(Game game) throws InvalidUIModeException {
		
		UI_Mode currentMode = UI_Mode_Selector.getMode();
		
		if(currentMode == null) {
			throw new InvalidUIModeException("Invalid game mode : \"null\"", null);
		}
		
		switch(currentMode) 
		{
		case CONSOLE :
			return new Game_UI_Console(game);
		default : 
			throw new InvalidUIModeException("Game mode \"" + currentMode.toString() + "\" is not available", UI_Mode_Selector.getMode());
		}
	}
	
	public Game getGame() {
		return this.GAME;
	}

	
	abstract public void readUserAction();
	abstract public void displayMessage(String msg);
	//abstract public void displayError();
	//abstract public static void 
	//abstract public static void displayGameExit();
	
	/*abstract protected void showHelp();
	abstract protected void movePlayerToPlace(String place);
	abstract protected void showItem(String itemName);
	
	abstract protected void showHelp();*/

	
	//abstract public void displayItem(Item item); 
}