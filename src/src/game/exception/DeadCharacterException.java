package src.game.exception;
import src.game.core.GCharacter;

public class DeadCharacterException extends GameException {
	private static final long serialVersionUID = 1L;

	private final GCharacter PERSONNAGE;
	
	public DeadCharacterException(GCharacter p, String msg) {
		super(msg + " : The character \"" + p.getName() + "\" is dead !");
		this.PERSONNAGE = p;
	}
	
	public GCharacter getPersonnage() {
		return this.PERSONNAGE;
	}

}
