package src.game.core.quest;

import java.util.List;

import src.game.core.Command;
import src.game.core.item.Item;

public class MainQuest extends Quest{
	
	private final Item FINAL_ITEM;
	private boolean itemUsed;
	
	public MainQuest(Item finalItem) {
		this.FINAL_ITEM = finalItem;
		this.itemUsed = false;
	}
	
	
	protected void onUserAction(Command cmd, List<Object> args) {}

}
