package src.game.ui.game;

import src.game.core.Game;
import src.game.exception.InvalidUIException;
import src.game.ui.UI_Mode;
import src.game.ui.UI_Mode_Selector;

abstract public class Game_UI {
	
	private final Game mGAME;
	
	
	public Game_UI(Game game) {
		super(); // Implicit anyway
		mGAME = game;
	}
	
	public static final Game_UI create(Game game) throws InvalidUIException {
		
		UI_Mode currentMode = UI_Mode_Selector.getMode();
		
		if(currentMode == null) {
			throw new InvalidUIException("Invalid game mode : \"null\"", null);
		}
		
		switch(currentMode) 
		{
		case CONSOLE :
			return new Game_UI_Console(game);
		default : 
			throw new InvalidUIException("Game mode \"" + currentMode.toString() + "\" is not available", UI_Mode_Selector.getMode());
		}
	}
	
	public Game getGame() {
		return mGAME;
	}

	
	abstract public void readUserAction(); 
	
	//abstract public static void 
	//abstract public static void displayGameExit();
	
	/*abstract protected void showHelp();
	abstract protected void movePlayerToPlace(String place);
	abstract protected void showItem(String itemName);
	
	abstract protected void showHelp();*/

	
	//abstract public void displayItem(Item item); 
}
