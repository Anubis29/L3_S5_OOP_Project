package src.game.ui.game;

import java.util.Scanner;

import src.game.core.Command;
import src.game.core.Game;
import src.game.exception.GameException;
import src.game.exception.InvalidArgumentException;
import src.game.exception.InvalidCommandException;

public class Game_UI_Console extends Game_UI {

	private Scanner mScanner;
	
	public Game_UI_Console(Game game) {
		super(game);
		mScanner = new Scanner(System.in);
	}
	
	@Override
	public void readUserAction() {
		
		boolean validInput = false;
		
		while(validInput == false) {
			System.out.print("PLAYER ACTION : ");
			Command cmd;
			String cmdStr = null;
			
			try {
				String inputStrArray[] = mScanner.nextLine().toUpperCase().split(" ");
				cmdStr = inputStrArray[0];
				
				cmd = getCommandFromString(cmdStr);
				
				if(!cmd.canProcess(inputStrArray.length-1)) {
					throw new InvalidArgumentException(getGame(), cmd, "Bad argument count!");
				}
				
				String arg0 = inputStrArray.length >= 2 ? inputStrArray[1] : null;
				
				switch(cmd) 
				{
				case GO :
					break;
				case HELP :
					displayHelp(arg0);
					break;
				case TAKE :
					break;
				case LOOK :
					break;
				case QUIT :
					getGame().quit();
					System.out.println("You exited the game!");
				//	mLog.warning("QUI");
					break;
				case USE :
					break;
				}		
			}catch(GameException e) {
				System.out.println(e.getMessage());
			}		
		}
		
		// TODO Auto-generated method stub
		
	}
	
	public void displayHelp(String arg0) throws InvalidArgumentException {
		if(arg0 != null) {
			arg0 = arg0.toUpperCase();
			Command cmdHelp;
			
			try {
				cmdHelp = getCommandFromString(arg0);
			}catch(InvalidCommandException e) {
				throw new InvalidArgumentException(getGame(), Command.HELP, arg0 + " is not a valid command name.");
			}
			
			System.out.println(cmdHelp.help());
		}else {
			System.out.println("Available commands are : ");
			for(Command cmd : Command.values()) {
				System.out.println(" - " + cmd);
			}
		}
		
		System.out.println();
		
	}
	
	public Command getCommandFromString(String str) throws InvalidCommandException{
		try {
			return Command.valueOf(str);
		}catch(IllegalArgumentException e) {
			throw new InvalidCommandException(getGame(), str);
		}
	}

}
