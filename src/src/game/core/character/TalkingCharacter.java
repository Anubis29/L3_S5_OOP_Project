package src.game.core.character;

import src.game.core.place.Place;
/**
 * @author alexandre
 */
public class TalkingCharacter extends GCharacter implements Talkative {

	private String sentence;
	
	public TalkingCharacter(String name, String description, String sentence, Place place) {
		super(name, description, place);
		this.sentence = sentence;
		// TODO Auto-generated constructor stub
	}
	
    public TalkingCharacter(String name, String description, String sentence, Place place, int maxLP){
		super(name, description, place, maxLP);
		this.sentence = sentence;
    }


	@Override
	public final String getSentence() {
		return this.sentence;
	}

	@Override
	public final void setSentence(String sentence) {
		this.sentence = sentence;		
	}
	
	

}
