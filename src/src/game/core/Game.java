package src.game.core;

import src.game.exception.InvalidCommandException;
import src.game.exception.InvalidUIException;
import src.game.ui.game.Game_UI;

public class Game {
	private Game_UI mUI;
	
	private boolean mIsRunning;
	private boolean mQuitRequested;
	private boolean mObjectiveReached;
	
	public Game()
	{
		mIsRunning = false;
		mQuitRequested = false;
		mObjectiveReached = false;
	}
	
	public void run() {
		mIsRunning = true;

		this.setup();
		
		while(!mQuitRequested && !mObjectiveReached) {
			
			this.loop();
		}
		
		mIsRunning = false;
	}
	
	
	private void setup() {
		try {
			mUI = Game_UI.create(this);
		}catch(InvalidUIException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void loop() {
		try {
			mUI.readUserAction();
		}catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	/*
	 * COMMANDS
	 */
	
	public void go(String place) {
		
	}
	
	public void look(String item) {
		
	}
	
	public void take(String item) {
		
	}
	
	public void quit() {
		mQuitRequested = true;
	}
	
	public void use(String item) {
		
	}
	
	
	
	
	
	
}
