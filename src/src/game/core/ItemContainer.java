package src.game.core;

import java.util.List;

public interface ItemContainer {
    
    public abstract Item getItem(String name);
    public abstract List<Item> getItems();

	public abstract void addItem(Item item);
	public abstract boolean findItem(Item item);
	public abstract boolean removeItem(Item item);
}
