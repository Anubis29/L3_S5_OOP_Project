package src.game.core.quest;

import java.util.List;

import src.game.core.Command;
import src.game.core.character.GCharacter;
import src.game.core.character.TalkingCharacter;
import src.game.core.exit.Exit;
import src.game.core.item.Item;
import src.game.core.item.Torch;
import src.game.ui.game.GameUI;

public class RingQuest extends Quest {

	private final TalkingCharacter RING_MAN;
	private final Item RING;
	private final GCharacter PLAYER; 
	private boolean isComplete;
	
	private static final String NO_RING_SENTENCE = "Did you find the ring ?";
	private static final String HAVE_RING_SENTENCE = "The ring ! Thank you so much! Take this torch, I don't need it anymore.";
	private static final String POST_SENTENCE = "What a nice day!";

	public RingQuest(String name, String info, GCharacter player, TalkingCharacter ringMan, Item ring, GameUI ui) {
		super(name, info, ui);
		
		this.RING_MAN = ringMan;
		this.RING = ring;
		this.PLAYER = player;
		this.isComplete = false;
	}
	
	@Override
	protected void onStart() {
		this.UI.displaySentence(RING_MAN);
		super.onStart();
	}
	
	@Override
	protected boolean onUpdate() {
		
		if(this.PLAYER.findItem(this.RING)) {
			this.RING_MAN.setSentence(RingQuest.HAVE_RING_SENTENCE);
		}else {
			this.RING_MAN.setSentence(RingQuest.NO_RING_SENTENCE);
		}
		
		return this.isComplete;
	}
	
	@Override
	protected void onComplete() {
		this.RING_MAN.setSentence(POST_SENTENCE);
		this.PLAYER.removeItem(RING);
		this.PLAYER.addItem(new Torch());
		this.UI.display(">You earned a torch!\n");
		super.onComplete();
	}
	
	
	@Override
	public void onUserAction(Command cmd, List<Object> args) {
		if(!this.isStarted()) {
			if(cmd == Command.GO) {
				Exit e = (Exit) args.get(0);
				if(e.getPlace() == this.RING_MAN.getPlace()) {
					this.start();
				}
			}
		}else if(cmd == Command.TALK && args.get(0) == this.RING_MAN && this.PLAYER.findItem(this.RING) ) {
			this.isComplete = true;
		}
	}


}
