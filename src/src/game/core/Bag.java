/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core;

import src.game.core.container.ItemContainer;

/**
 *
 * @author audrey
 */

public class Bag extends ItemContainer {
    private final static int DEFAULT_VOLUME_MAX = 100;
    private final static int DEFAULT_GOLD = 0;

    private int gold;
    
    public Bag(){
    	this(Bag.DEFAULT_VOLUME_MAX);
    }
    
    public Bag(int maxVolume){
        super(maxVolume);
        
        this.gold = Bag.DEFAULT_GOLD;
    }
    
    /*public boolean isAddable(Item itemToAdd){
      if (this.volume + itemToAdd.getVolume()<=this.VOLUME_MAX){
        return true;
      }  
      else{
        return false;
      }
    }*/

    /*public void addItem(Item itemToAdd) throws BagFullException{
        if(itemToAdd == null) {
            throw new GameException("null");
        }
        
        // Condition de fin de récursion
        if(this.findItem(itemToAdd) == true) {
            return;
        }
            
        if (this.isAddable(itemToAdd)){
            // La ligne suivante casse la récursion
            // lancée par itemToAdd.setContainer(this);
            this.itemInBag.add(itemToAdd);
            this.volume+=itemToAdd.getVolume();
            // Lance la récursion
            itemToAdd.setContainer(this);
        }else {
            throw new BagFullException("Failed to add to bag");
        }
    }*/
  
    
   /* public boolean removeItem(Item itemToRemove) {
        if(this.itemInBag.contains(itemToRemove)) {
            itemToRemove.setContainer(null);
            this.itemInBag.remove(itemToRemove);
            return true;
        }
        
        return false;
    }*/
    
    /*public boolean findItem(Item itemToFind){
        for (Item allItem : this.itemInBag){
            if (allItem==itemToFind){
                return true;
            }
        }
        return false;
    }*/
    
    public void addGold(int moneyToAdd){
        this.gold+=moneyToAdd;
    }
    
    public boolean removeGold(int moneyToRemove){
        if (this.gold - moneyToRemove >= 0){
            this.gold -= moneyToRemove;
            return true;
        }
        return false;    
    }
    
    public int getGold(){
        return this.gold;
    }
    
    /*public List<Item> getItems(){
        return new ArrayList<Item>(this.itemInBag);
    } 
    
    public Item getItem(String name) {
    	for (Item allItem : this.itemInBag){
    		if (allItem.getName()==name){
                return allItem;
            }
        }
    	
    	return null;
    }*/
}
