package src.game.ui.game;

import java.util.Scanner;

import src.game.core.Command;
import src.game.core.Game;

public class Game_UI_Console extends Game_UI {

	private Scanner mScanner;
	//private Logger 	mLog;
	
	public Game_UI_Console(Game game) {
		super(game);
		mScanner = new Scanner(System.in);
		//mLog = Logger.getLogger(Game_UI_Console.class.getName());
	}
	
	@Override
	public void readUserAction() {
		System.out.print("PLAYER ACTION : ");
		Command cmd;
		String cmdStr = null;
		
		try {
			String inputStrArray[] = mScanner.nextLine().toUpperCase().split(" ");
			cmdStr = inputStrArray[0];
			
			cmd = Command.valueOf(cmdStr);
			
			if(!cmd.canProcess(inputStrArray.length-1)) {
				throw new IllegalArgumentException();
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
		}catch(IllegalArgumentException e) {
			System.out.println("Error : \"" + cmdStr + "\" is not a valid command. Type \"HELP\" to get the command list");
		}
		// TODO Auto-generated method stub
		
	}
	
	public void displayHelp(String arg0) throws IllegalArgumentException {
		if(arg0 != null) {
			arg0 = arg0.toUpperCase();
			Command cmdHelp = Command.valueOf(arg0);
			System.out.println(cmdHelp.help());
		}else {
			System.out.println("Available commands are : ");
			for(Command cmd : Command.values()) {
				System.out.println(" - " + cmd);
			}
		}
		
		System.out.println();
	}

}
