package src.game.core;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.game.core.container.ItemContainer;
import src.game.exception.BagFullException;
import src.game.exception.GameException;

public class Place implements ItemContainer, Lookeable {
	
	private final String NAME;
	private final String DESCRIPTION;
	private final ArrayList<Item> ITEMS;
	private final ArrayList<GCharacter> CHARACTERS;	
    private final Map<String,Exit> EXITS;
	

    public Place(String name, String description) {
    	this.NAME = name;
    	this.DESCRIPTION = description;
    	this.ITEMS = new ArrayList<Item>();
    	this.CHARACTERS = new ArrayList<GCharacter>();
    	this.EXITS = new HashMap<String, Exit>();
    }
    
    
    /* ********************************************
     *               GETTERS
     * ********************************************
     */
    public String getName() {
        return this.NAME;
    }
    
    public String getDescription() {
		return this.DESCRIPTION;
	}
    
    @Override
    public Item getItem(String name) {
        for(Item item : this.ITEMS) {
            if(item.getName().equals(name)){
                return item;
            }
        }
    
        return null;
    }
    
    @Override
    public List<Item> getItems() {
        return new ArrayList<Item>(this.ITEMS);
    }
    
    public List<GCharacter> getCharacters(){
        return new ArrayList<GCharacter>(this.CHARACTERS);
    }
    
    public Exit getExit(String name) {
        return this.EXITS.get(name);
    }
    
	//
    public void addItem(Item item) {
        if(item == null) {
            throw new GameException("null");
        }
        
        // Condition de fin de récursion
        if(this.findItem(item) == true) {
            return;
        }
            
        // La ligne suivante casse la récursion
        // lancée par itemToAdd.setContainer(this);
        this.ITEMS.add(item);
        // Lance la récursion
        item.setContainer(this);
	}
		

	// 
    public boolean removeItem(Item item) {
        if(this.ITEMS.contains(item)) {
            item.setContainer(null);
            this.ITEMS.remove(item);
            return true;
        }
        
        return false;
		
	}

	@Override
	public boolean findItem(Item item) {
	    for(Item litem : this.ITEMS) {
            if(litem == item){
                return true;
            }
        }
	    return false;
	}
	
	public void addCharacter(GCharacter c) {
	    if(c.getPlace() != this) {
	        c.setPlace(this);
	        this.CHARACTERS.add(c);
	    }
	}
	
	public void addExit(Exit exit) {
	    this.EXITS.put(exit.getPlace().getName(), exit);
	}
	
	public boolean removeCharacter(GCharacter c) {
	    
	    if(c.getPlace() == this) {
	        c.setPlace(null);
	        this.CHARACTERS.remove(c);
	        
	        return true;
	    }
	    
	    return false; 
	}
	
	public boolean findCharacter(GCharacter c) {
	    for(GCharacter lc : this.CHARACTERS) {
	        if(c == lc) {
	            return true;
	        }
	    }
	    return false;
	}
}

	

	