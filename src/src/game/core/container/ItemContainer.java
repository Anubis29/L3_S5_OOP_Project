package src.game.core.container;

import java.util.List;

import src.game.core.Item;
import src.game.exception.ItemContainerException;

public interface ItemContainer {
    
    public abstract Item getItem(String name);
    public abstract List<Item> getItems();

	public abstract void addItem(Item element);
	public abstract boolean findItem(Item element);
	public abstract boolean removeItem(Item element);
}
