/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author audrey
 */

public class Bag implements ItemContainer {
    private final static int DEFAULT_VOLUME_MAX = 100;
    private final static int DEFAULT_GOLD = 0;

    private final int VOLUME_MAX;
    private int volume;
    private int gold;
    private List<Item> itemInBag;
    
    public Bag(){
        this.VOLUME_MAX = Bag.DEFAULT_VOLUME_MAX;
        this.gold = Bag.DEFAULT_GOLD;

        this.volume=0;
        this.itemInBag= new ArrayList<>();
    }
    
    public boolean isAddable(Item itemToAdd){
      if (this.volume + itemToAdd.getVolume()<=this.VOLUME_MAX){
        return true;
      }  
      else{
        return false;
      }
    }

    public void addItem(Item itemToAdd){
        if (this.isAddable(itemToAdd)){
            this.volume+=itemToAdd.getVolume();
            this.itemInBag.add(itemToAdd);
        }
    }
    
    public void removeItem(Item itemToRemove){
        this.volume-=itemToRemove.getVolume();
        this.itemInBag.remove(itemToRemove);
    }
    
    public boolean findItem(Item itemToFind){
        for (Item allItem :this.itemInBag){
            if (allItem==itemToFind){
                return true;
            }
        }
        return false;
    }
    
    public void addGold(int moneyToAdd){
        this.gold+=moneyToAdd;
    }
    
    public void removeGold(int moneyToRemove){
        if (this.gold-moneyToRemove<=0){
            this.gold=0;
        }
        else{
            this.gold-=moneyToRemove;
        }
    }
    
    public int getMoney(){
        return this.gold;
    }
    
    public Item[] getItems(){
        return (Item[]) this.itemInBag.toArray();
    } 
    
    public Item getItem(String name){
    	for (Item allItem : this.itemInBag){
    		if (allItem.getName()==name){
                return allItem;
            }
        }
    	
    	// throw exception here
    	return null;
    }
}
