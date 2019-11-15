package src;

public class Game {
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
		this.setup();
		
		while(!mQuitRequested && !mObjectiveReached) {
			this.loop();
		}
	}
	
	private void setup() {
		
	}
	
	private void loop() {
		processCommand();
	}
	
	
	private void processCommand()
	{
		
	}
	
	/*
	 * COMMANDS
	 */
	
	private void go(String place) {
		
	}
	
	private void help() {
		
	}
	
	private void look(String item) {
		
	}
	
	private void take(String item) {
		
	}
	
	private void quit() {
		
	}
	
	
	
	
	
}
