package src.game.core;

public interface ItemContainer {
	public abstract void addItem(Item item);
	public abstract void removeItem(Item item);
	public abstract Item getItem(String name);
	public abstract Item[] getItems();
	public abstract boolean findItem(Item item);
}
