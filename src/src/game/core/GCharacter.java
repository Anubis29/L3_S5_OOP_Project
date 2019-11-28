/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core;

import src.game.exception.DeadCharacterException;
import src.game.exception.ItemNotFoundException;

/**
 *
 * @author audrey
 */
public class GCharacter implements Lookeable {
    private final static int DEFAULT_MAX_LP = 10;

    
    private final String NAME;
    private final int LP_MAX;
    private int lp;
    private Bag bagOfPersonnage;
    private Place placeOfPersonnage;
    
    public GCharacter(String nameOfPersonnage, Place placeOfStart){
        this.NAME=nameOfPersonnage;
        this.LP_MAX= DEFAULT_MAX_LP;
        this.lp=this.LP_MAX;
        this.bagOfPersonnage=new Bag();
        this.placeOfPersonnage=placeOfStart;
        
        this.placeOfPersonnage.addCharacter(this);
    }
    
    public void addLP(int lpRecover) throws DeadCharacterException{
    	if(this.isDead()) {
    		throw new DeadCharacterException(this, "Failed to add LP");
    	}
    	
    	this.lp += lpRecover;
        if (this.lp > this.LP_MAX){
            this.lp = this.LP_MAX;
        }
    }
    
    public void removeLP (int lpLost){
    	if(this.isDead()) {
    		throw new DeadCharacterException(this, "Failed to remove LP");
    	}
    	
        if (this.lp-lpLost<0){
            this.lp=0;
        }
        else{
            this.lp-=lpLost;
        }
    }
    
    public void addItem(Item itemToAdd){
        this.bagOfPersonnage.add(itemToAdd); 
    }
    
    public String getDescription(){
        return this.NAME+" a "+this.lp+"/"+this.LP_MAX;
    }
    
    public void removeItem(Item itemToRemove) throws ItemNotFoundException {
        this.bagOfPersonnage.remove(itemToRemove);
    }
    
    public void dropItem(Item item) throws ItemNotFoundException {
        this.bagOfPersonnage.remove(item);
        this.placeOfPersonnage.add(item);
    }
    
    
    public boolean isDead(){
        if (this.lp==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean setPlace(Place placeToGo){
        
        Place oldPlace = this.placeOfPersonnage;
        Place newPlace = placeToGo;
        
        // Permet de casser la récursion, voir TP3
        if(oldPlace != newPlace) {
          
            if(placeToGo == null) {
                this.placeOfPersonnage = null;
                oldPlace.removeCharacter(this);
            }
            
            this.placeOfPersonnage = newPlace;
            if(newPlace != null) {
                newPlace.addCharacter(this);
            }
            
            return true;
        }
        
        return false;
    }
    
    public Place getPlace(){
        return this.placeOfPersonnage;
    }

	public String getName() {
		return this.NAME;
	}
    
    
    
    
}
