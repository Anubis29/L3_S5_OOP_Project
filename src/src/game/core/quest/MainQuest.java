package src.game.core.quest;

import java.util.List;

import src.game.core.Command;
import src.game.core.item.Item;
import src.game.ui.game.GameUI;

public class MainQuest extends Quest{
	
	private final Item FINAL_ITEM;
	private boolean itemUsed;
	
	public MainQuest(String name, Item finalItem, GameUI ui) {
		super(name, "Find \"" + finalItem.getName() + "\" and use it.", ui);
		this.FINAL_ITEM = finalItem;
		this.itemUsed = false;
	}
	
	@Override
	protected boolean onUpdate() {
		return this.itemUsed;
	}
	
	
	@Override
	protected void onComplete() {
	    this.UI.display("CONGRATULATIONS! You saved the world\n");
	    super.onComplete();
	}
	
	@Override
	public void onUserAction(Command cmd, List<Object> args) {
		if(cmd == Command.USE && args.size() >= 1) {
			this.itemUsed = (args.get(0) == this.FINAL_ITEM) ? true : false;
		}
	}

}
