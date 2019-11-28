package src.game.exception;
import src.game.core.Personnage;

public class DeadCharacterException extends GameException {
	private static final long serialVersionUID = 1L;

	private final Personnage PERSONNAGE;
	
	public DeadCharacterException(Personnage p, String msg) {
		super(msg + " : The character \"" + p.getName() + "\" is dead !");
		this.PERSONNAGE = p;
	}
	
	public Personnage getPersonnage() {
		return this.PERSONNAGE;
	}

}
