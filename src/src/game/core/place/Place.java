package src.game.core.place;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.game.core.Lookeable;
import src.game.core.character.GCharacter;
import src.game.core.container.GCharacterContainer;
import src.game.core.container.ItemContainer;
import src.game.core.exit.Exit;
import src.game.core.item.Item;
import src.game.exception.GameException;

public class Place extends ItemContainer implements GCharacterContainer, Lookeable {
	
	private final String NAME;
    private String description;

	private final ArrayList<GCharacter> CHARACTERS;	
    private final Map<String,Exit> EXITS;
	

    public Place(String name, String description) {
        super(Integer.MAX_VALUE);
        
    	this.NAME = name;
    	this.description = description;
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
    
    
    /*public void onEnter(GCharacter character) {}
    public void onItemRemoved(Item item) {}
    public void onItemAdded(Item item) {}*/

    
    @Override
    public List<GCharacter> getCharacters(){
        return new ArrayList<GCharacter>(this.CHARACTERS);
    }
    
    public Exit getExit(String name) {
        return this.EXITS.get(name.toUpperCase());
    }
    
    public Map<String, Exit> getExits() {
        return new HashMap<>(this.EXITS);
    }
    
    @Override
    public boolean addItem(Item item) {
        if(super.addItem(item) == true) {
            //this.onItemAdded(item);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean removeItem(Item item) {
        if(super.removeItem(item) == true) {
            //this.onItemRemoved(item);
            return true;
        }
        
        return false;
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
	    this.EXITS.put(exit.getPlace().getName().toUpperCase(), exit);
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
            if(lc.getName().equalsIgnoreCase(name)) {
                return lc;
            }
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        String buffer = "[" + this.getName() + "]\n";
        buffer += ">Characters : "; 
        
        if(this.CHARACTERS.isEmpty()) {
            buffer += "[EMPTY]\n";
        }else {
            buffer += "\n";
            for(GCharacter c : this.getCharacters()) {
                buffer += "--> \"" + c.getName() + "\"\n";
            }
        }
        
        buffer += ">Items : ";
        if(this.getItems().isEmpty()) {
            buffer += "[EMPTY]\n";
        }else {
            buffer += "\n";
            for(Item item : this.getItems()) {
                buffer += "--> \"" + item.getName() + "\"\n";
            }
        }
        
        buffer += ">Exits : \n";
        
        for (Map.Entry<String, Exit> entry : this.EXITS.entrySet()) {
            String key = entry.getKey();
            Exit exit = entry.getValue();
            
            buffer += "--> \"" + exit.getName() + "\" >> \"" + key + "\"\n";
        }  
        
        return buffer;
    }


	@Override
	public String getDescription() {
		return this.NAME + " : " + this.description;
	}
	
	@Override
	public void setDescription(String desc) {
		this.description = desc;
	}
	


}

	

	