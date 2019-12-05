package src.game.ui.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.game.core.*;
import src.game.core.character.Talkative;
import src.game.exception.GameException;

public class GameUI_Console extends GameUI {

	private Scanner scanner;
	
	public GameUI_Console(Game game) {
		super(game);
		this.scanner = new Scanner(System.in);
	}

	@Override
    public Command readUserCommand(List<String> l) {
        
            String inputLine= this.scanner.nextLine().toUpperCase();
            
            ArrayList<String> parsedStrings = new ArrayList<>(); 
            String bufferString = new String();
            
            
            boolean quoteToken = false;
            
            for(int i=0; i < inputLine.length(); i++) {
                
                boolean pushWordToken = false;
                boolean skipChar = false;
                
                if(i == inputLine.length()-1) {
                    pushWordToken = true;
                }
                
                char value = inputLine.charAt(i);
                
                if(value == '"') {
                    skipChar = true;
                    if(quoteToken) {
                        quoteToken = false;
                        pushWordToken = true;
                    }else {
                        quoteToken = true;
                    }
                }
                
                if(value == ' ' && !quoteToken) {
                    skipChar = true;
                    pushWordToken = true;
                }
                
                if(!skipChar) {
                    bufferString += value;
                }
                
                if(pushWordToken) {
                    if(!bufferString.isEmpty()) {
                        parsedStrings.add(bufferString);
                        bufferString = new String();
                    }
                }
            }
            
            if(quoteToken) {
                throw new GameException("Invalid input, a quote is missing!");
            }else if(parsedStrings.isEmpty()) {
                throw new GameException("No input!");
            }
            
            Command cmd = Command.getFromString(parsedStrings.get(0));     
           
            for(int i = 1; i < parsedStrings.size(); i++) {
                l.add(parsedStrings.get(i));
            }
            
            return cmd;
    }

	@Override
	public void display(String msg) {
		System.out.print(msg);
	}
	
	@Override
	public void look(Lookeable l) {
		this.display(l.getDescription());
	}
	
	
	private static final int TALK_DELAY = 0;
	
	@Override
	public void displaySentence(Talkative t) {
	    String sentence = t.getSentence();
	    
	    System.out.print("[" + t.getName() + "] : \""); 
	    for(int i=0; i < sentence.length(); i++) {
	        try {
                TimeUnit.MILLISECONDS.sleep(GameUI_Console.TALK_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

	        System.out.print(sentence.charAt(i));
	    }
	            
	    System.out.println("\"");
	}
	
	

}
