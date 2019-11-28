package src.game.exception;

import src.game.core.Item;
import src.game.core.Container;

public class ItemNotFoundException extends GameException {
	private static final long serialVersionUID = 1L;

	private final Item ITEM;
	private final Container CONTAINER;
	
	public ItemNotFoundException(Item item, Container container, String msg) {
		super(msg + " : with Item [\"" + item.getName() + "\"]");
		this.ITEM = item;
		this.CONTAINER = container;
	}
	
	public Item getItem() {
		return this.ITEM;
	}
	
	public Container getItemContainer() {
		return this.CONTAINER;
	}
	
}
