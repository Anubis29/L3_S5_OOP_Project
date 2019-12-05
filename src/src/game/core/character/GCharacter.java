/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core.character;

import java.util.List;

import src.game.core.Bag;
import src.game.core.Lookeable;
import src.game.core.item.Item;
import src.game.core.place.Place;
import src.game.exception.DeadCharacterException;

/**
 *
 * @author audrey
 */
public class GCharacter implements Lookeable {
    private final static int DEFAULT_MAX_LP = 10;

    
    private final String NAME;
    private final int LP_MAX;
    private final Bag bagOfPersonnage;
    private String description;

    private int lp;
    private Place placeOfPersonnage;
    
    public GCharacter(String nameOfPersonnage, String description, Place placeOfStart){
        this(nameOfPersonnage, description,  placeOfStart, GCharacter.DEFAULT_MAX_LP);
    }
    
    public GCharacter(String nameOfPersonnage, String description, Place placeOfStart, int maxLP){
        this.NAME=nameOfPersonnage;
        this.LP_MAX= maxLP;
        this.lp=this.LP_MAX;
        this.bagOfPersonnage=new Bag();
        this.placeOfPersonnage=null;
        this.description = description;
        
        if(placeOfStart != null) {
            this.setPlace(placeOfStart);
        }
    }
    
    public void setDescription(String description) {
    	this.description = description;
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
    
    public int getLP() {
        return this.lp;
    }
    
    public String getDescription(){
        return this.NAME + " : " + this.description;
    }
        
    public boolean dropItem(Item item) {
        boolean flag = false;
        
        if(this.bagOfPersonnage.removeItem(item)) {
            if(!this.placeOfPersonnage.addItem(item)) {
                // Si on arrive pas à ajouter l'objet dans la place, on le remet dans le sac
                this.bagOfPersonnage.addItem(item);
            }else {
                flag = true;
            }
        }
        
        return flag;
    }
    
    public boolean isDead(){
        if (this.lp==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setPlace(Place placeToGo){
        
        Place oldPlace = this.placeOfPersonnage;
        Place newPlace = placeToGo;
        
        // Permet de casser la récursion, voir TP3
        if(oldPlace != newPlace) {
          
            if(oldPlace != null) {
                this.placeOfPersonnage = null;
                oldPlace.removeCharacter(this);
            }
            
            this.placeOfPersonnage = newPlace;
            if(newPlace != null) {
                newPlace.addCharacter(this);
            }    
        } 
    }
    
    public Place getPlace(){
        return this.placeOfPersonnage;
    }

	public String getName() {
		return this.NAME;
	}
    
    
    public String getDialogue(){
        return "Bonjour cher Hero.......";
    }
    
    
    
    public boolean addItem(Item itemToAdd) {
        return this.bagOfPersonnage.addItem(itemToAdd);
    }
  
    
    public boolean removeItem(Item itemToRemove) {
        return this.bagOfPersonnage.removeItem(itemToRemove);
    }
    
    public boolean findItem(Item itemToFind){
        return this.bagOfPersonnage.findItem(itemToFind);
    }
    
    
    public List<Item> getItems(){
        return this.bagOfPersonnage.getItems();
    } 
    
    public Item getItem(String name) {
        return this.bagOfPersonnage.getItem(name);
    }
    
    public void addGolds(int golds) {
        this.bagOfPersonnage.addGold(golds);
    }
    
    public int getMaxLP() {
        return this.LP_MAX;
    }
    
    public boolean removeGolds(int golds) {
        return this.bagOfPersonnage.removeGold(golds);
    }
    
    public int getGolds() {
        return this.bagOfPersonnage.getGold();
    }
    
    @Override
    public String toString() {
        String buffer = "[" + this.getName() + "]\n";
        
        if(this.isDead()) {
            buffer += ">HP : Dead\n" ;
        }else {
            buffer += ">HP : [" + this.getLP() + "/" + this.getMaxLP() + "]\n";
        }
        
       // buffer += this.bagOfPersonnage.toString();
        
        return buffer;
    }
    
}
