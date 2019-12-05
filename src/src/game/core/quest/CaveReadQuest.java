package src.game.core.quest;

import java.util.List;

import src.game.core.Command;
import src.game.core.character.GCharacter;
import src.game.core.exit.Exit;
import src.game.core.item.Item;
import src.game.core.place.Cave;
import src.game.core.place.Place;
import src.game.ui.game.GameUI;

public class CaveReadQuest extends Quest{

	private final Item TARGET_ITEM;
	private final Place TARGET_POP_LOCATION;
	private final GCharacter PLAYER;
	private final Cave CAVE;
	private boolean complete;
	
	public CaveReadQuest(String name, String info, GCharacter player, Item objectiveItem, Place objectiveItemPopLocation, Cave cave, GameUI ui) {
		super(name, info, ui);
		
		this.TARGET_ITEM = objectiveItem;
		this.TARGET_POP_LOCATION = objectiveItemPopLocation;
		this.PLAYER = player;
		this.CAVE = cave;
		this.complete = false;
	}
	
	@Override
	protected boolean onUpdate() {
		return this.complete;
	}
	
	@Override
	protected void onComplete() {
		this.TARGET_POP_LOCATION.addItem(TARGET_ITEM);
		this.UI.display(">\"" + this.TARGET_ITEM.getName() + " appeared in the \"" + this.TARGET_POP_LOCATION.getName() + "\"\n");
		super.onComplete();
	}
	
	
	@Override
	public void onUserAction(Command cmd, List<Object> args) {
		if(!this.isStarted()) {
			if(cmd == Command.GO) {
				Exit e = (Exit) args.get(0);
				if(e.getPlace() == this.CAVE) {
					this.start();
				}
			}
		}else if(cmd == Command.LOOK && args.size() == 0 && this.CAVE.isLighted() && this.PLAYER.getPlace() == this.CAVE) {
			this.complete = true;
			//&& this.PLAYER.getPlace() == this.CAVE && this.CAVE.isLighted()) {
			//this.isComplete = true;
		}
	}
}
