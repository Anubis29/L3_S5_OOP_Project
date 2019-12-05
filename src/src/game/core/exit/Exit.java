package src.game.core.exit;

import src.game.core.place.Place;

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
	
	public boolean canCross() {
		return true;
	}
	
	public String getName() {
		return this.NAME;
	}
	
	public Place getPlace() {
		return this.PLACE;
	}
}
