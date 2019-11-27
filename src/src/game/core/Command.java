package src.game.core;

import src.game.exception.InvalidCommandException;

/**
 * <b>Command</b> is an enumeration listing every action available to the player. 
 * The available commands are : 
 * <li>{@link #GO}</li>
 * <li>{@link #HELP}</li>
 * <li>{@link #LOOK}</li>
 * <li>{@link #TAKE}</li>
 * <li>{@link #QUIT}</li>
 * <li>{@link #USE}</li>

 * @author alexandre
 * @version 0.1
 */

public enum Command {
	
	/**
	 * Usage : <b>GO</b> &ltPLACE&gt<br>
	 * Move the player to the place named &ltplace&gt.<br>
     * This command will fail if the player is unable to move to this place.
	 */
	GO(1,1,  	"Usage : GO <PLACE>\n" +
				"Move the player to the place named <PLACE>.\n" +
			  	"This command will fail if the player is unable to move to this place."),
	
	/**
	 * Usage : <b>HELP</b> [&ltCMD&gt]<br>
	 * <li> List the available commands.<br>
     * <li> List the help of the command if [&ltCMD&gt] is specified.
	 */
	HELP(0,1,	"Usage : HELP [<CMD>]\n" +
				"List the available commands.\n" +
			 	"List the command help if [<CMD>] is specified."),
	
	/**
	 * Usage : <b>LOOK</b> [BACKPACK] [&ltITEM&gt]<br>
	 * <li> List the available exits and items in the place where the player is.<br>
	 * <li> List the available items in the player's backpack if [BACKPACK] is specified.<br>
	 * <li> Display the item designed by [&ltITEM&gt] if [&ltITEM&gt] is specified.
	 */
	LOOK(0,2, 	"Usage : LOOK [BACKPACK] [<ITEM>]\n" +
				"List the available exits and items in the place where the player is.\n" +
				"List the available items in the player's backpack if [BACKPACK] is present.\n" +
			 	"Display the item designed by [<ITEM>] if [<ITEM>] is specified."),
	
	/**
	 * Usage : <b>TAKE</b> &ltITEM&gt<br>"
	 * Put the item specified by [<ITEM>] in the player's backpack."
	 */
	TAKE(1,1, 	"Usage : TAKE <ITEM>\n" +
				"Put the item specified by [<ITEM>] in the player's BACKPACK."),
	/**
	 * Usage : <b>QUIT</b><br>
	 * Quit the game.
	 */
	QUIT(0,0, 	"Usage : QUIT\n" + 
				"Quit the game."),
	
	/**
	 * Usage : <b>USE</b> &ltITEM&gt [&ltITEM_N&gt]...<br>
	 * Use the item specified by &ltITEM&gt.
	 * If the item can be used with others item, the list of item can be specified using [&ltITEM_N&gt]..."
	 */
	USE(1, Integer.MAX_VALUE , 
				"Usage : USE <ITEM> [<ITEM_N>]...\n" +
				"Use the item specified by <ITEM>. " +
				"If the item can be used with others item, the list of item can be specified using "
				+ "[<ITEM_N>]...");
	
	
	private final int MIN_NB_ARGS;
	private final int MAX_NB_ARGS;
	private final String HELP_MSG;

	private Command(int minArg, int maxArg, String help){
		this.MIN_NB_ARGS = minArg;
		this.MAX_NB_ARGS = maxArg;
		this.HELP_MSG = help;
	}
	
	public String help() { 
		return this.HELP_MSG;
	}
	
	public boolean checkArgCount(int argCount) {
		return this.MIN_NB_ARGS <= argCount && argCount <= this.MAX_NB_ARGS;
	}
	
	public static Command getFromString(String str) throws InvalidCommandException{
		try {
			return Command.valueOf(str);
		}catch(IllegalArgumentException e) {
			throw new InvalidCommandException(str);
		}
	}
}
