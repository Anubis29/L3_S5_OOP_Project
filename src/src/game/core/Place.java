package src.game.core;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		this.ITEMS.add(item);
	}
		

	// 
    public boolean removeItem(Item item) {
		//ArrayList<Item> contents;
		//contents.remove(item);
        return true;
		
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
	
	public boolean removeCharacter(GCharacter c) {
	    
	    if(c.getPlace() == this) {
	        c.setPlace(null);
	        this.CHARACTERS.remove(c);
	        
	        return true;
	    }
	    
	    return false; 
	}
}

	

	