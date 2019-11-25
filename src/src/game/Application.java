package src.game;

import src.game.core.Game;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		
		try {
			game.run();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
