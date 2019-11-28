package src.game.core;

import java.util.List;

import src.game.exception.ItemContainerException;

public interface Container<T> {
    
    public abstract T get(String name);
    public abstract List<T> getList();

	public abstract void add(T element);
	public abstract boolean find(T element);
	public abstract boolean remove(T element);
}
