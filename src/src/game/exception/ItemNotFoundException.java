package src.game.exception;

import src.game.core.Item;
import src.game.core.ItemContainer;

public class ItemNotFoundException extends GameException {
	private static final long serialVersionUID = 1L;

	private final Item ITEM;
	private final ItemContainer CONTAINER;
	
	public ItemNotFoundException(Item item, ItemContainer container, String msg) {
		super(msg + " : with Item [\"" + item.getName() + "\"]");
		this.ITEM = item;
		this.CONTAINER = container;
	}
	
	public Item getItem() {
		return this.ITEM;
	}
	
	public ItemContainer getItemContainer() {
		return this.CONTAINER;
	}
	
}
