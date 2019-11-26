package src.game.ui.game;

import java.util.Scanner;

import src.game.core.Command;
import src.game.core.Game;
import src.game.exception.GameException;
import src.game.exception.InvalidArgumentException;
import src.game.exception.InvalidCommandException;

public class GameUI_Console extends GameUI {

	private Scanner scanner;
	
	public GameUI_Console(Game game) {
		super(game);
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public void readUserAction() {
		
		
		while(true) {
			
			System.out.print("PLAYER ACTION : ");
			Command cmd;
			String cmdStr = null;
			
			try {
				String inputStrArray[] = this.scanner.nextLine().toUpperCase().split(" ");
				cmdStr = inputStrArray[0];
				
				cmd = getCommandFromString(cmdStr);
				
				if(!cmd.checkArgCount(inputStrArray.length-1)) {
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
					getGame().take("");
					break;
				case LOOK :
					break;
				case QUIT :
					getGame().quit();
					break;
				case USE :
					break;
				}
				
				break;
				
			}catch(GameException e) {
				System.out.println(e.getMessage());
			}	
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);
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
