package src.game.core;

/**
 * @author alexandre
 * @version 0.1
 * 
 * La classe <b>Exit</b> permet d'indiquer 
 * 
 * Par défaut il une Exit peut toujours être traversée
 */

public class Exit {
	private final String NAME;
	private final Place PLACE;
	
	public Exit(String name, Place place){
		this.NAME = name;
		this.PLACE = place;
	}
	
	boolean canCross() {
		return true;
	}
	
	String getName() {
		return this.NAME;
	}
	
	Place getPlace() {
		return this.PLACE;
	}
}
