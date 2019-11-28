package src.game.core;

import java.util.List;

import src.game.exception.ItemNotFoundException;

public interface ItemContainer {
	public abstract void addItem(Item item);
	public abstract void removeItem(Item item) throws ItemNotFoundException;
	public abstract Item getItem(String name)  throws ItemNotFoundException;
	public abstract List<Item> getItems();
	public abstract boolean findItem(Item item);
}
