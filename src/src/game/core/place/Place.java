package src.game.core.place;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.game.core.Exit;
import src.game.core.GCharacter;
import src.game.core.Lookeable;
import src.game.core.container.GCharacterContainer;
import src.game.core.container.ItemContainer;
import src.game.core.item.Item;
import src.game.exception.BagFullException;
import src.game.exception.GameException;

public class Place implements ItemContainer, GCharacterContainer, Lookeable {
	
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
    
    @Override
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
	    return this.ITEMS.contains(item);
	}
	
	public void addCharacter(GCharacter c) {
	    if(c == null) {
            throw new GameException("null");
        }
	    
	    // Condition de fin de récursion
	    if(this.CHARACTERS.contains(c) == false) {
	        this.CHARACTERS.add(c); // Validation de la fin de récursion
	        c.setPlace(this);
	    }
	}
	
	public void addExit(Exit exit) {
	    this.EXITS.put(exit.getPlace().getName(), exit);
	}
	
	@Override
	public boolean removeCharacter(GCharacter c) {
	    
	    if(this.findCharacter(c)) {
	        c.setPlace(null);
	        this.CHARACTERS.remove(c);
	        
	        return true;
	    }
	    
	    return false; 
	}
	
	@Override
	public boolean findCharacter(GCharacter c) {
	    return this.CHARACTERS.contains(c);
	}


    @Override
    public GCharacter getCharacter(String name) {
        for(GCharacter lc : this.CHARACTERS) {
            if(lc.getName().contentEquals(name)) {
                return lc;
            }
        }
        
        return null;
    }


}

	

	