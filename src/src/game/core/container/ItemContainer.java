package src.game.core.container;

import java.util.ArrayList;
import java.util.List;

import src.game.core.item.Item;
import src.game.exception.GameException;

public abstract class ItemContainer {
    
    private final int MAX_VOLUME;

    private ArrayList<Item> items;
    private int volume;

    public ItemContainer(int maxVolume) {
        this.items = new ArrayList<Item>();
        this.MAX_VOLUME = maxVolume;
    }
    
    public boolean addItem(Item itemToAdd) {
        if(itemToAdd == null) {
            throw new GameException("null");
        }
        
        // Condition de fin de récursion
        if(this.findItem(itemToAdd) == true) {
            return true;
        }
            
        // La ligne suivante casse la récursion
        // lancée par itemToAdd.setContainer(this);
        if(this.canAddItem(itemToAdd)) {
            this.items.add(itemToAdd);
            this.volume+=itemToAdd.getVolume();
            // Lance la récursion
            itemToAdd.setContainer(this);
            return true;
        }
        
        return false;
    }
  
    
    public boolean removeItem(Item itemToRemove) {
        if(this.items.contains(itemToRemove)) {
            itemToRemove.setContainer(null);
            this.items.remove(itemToRemove);
            return true;
        }
        
        return false;
    }
    
    public boolean findItem(Item itemToFind){
        for (Item allItem : this.items){
            if (allItem==itemToFind){
                return true;
            }
        }
        return false;
    }
    
    public List<Item> getItems(){
        return new ArrayList<Item>(this.items);
    } 
    
    public Item getItem(String name) {
        for (Item allItem : this.items){
            if (allItem.getName().equalsIgnoreCase(name.toUpperCase())){
                return allItem;
            }
        }
        
        return null;
    }
    
    public boolean canAddItem(Item item) {
        return (this.volume + item.getVolume()) > this.MAX_VOLUME ? false : true;
    }
    
    /*public abstract Item getItem(String name);
    public abstract List<Item> getItems();

	public abstract boolean addItem(Item element);
	public abstract boolean findItem(Item element);
	public abstract boolean removeItem(Item element);*/

}
