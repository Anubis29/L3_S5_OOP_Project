/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core;

/**
 *
 * @author audrey
 */
public class Personnage {
    private final String NAME;
    private final static int LP_MAX_DEFAULT=10;
    private final int LP_MAX;
    private int lp;
    private Bag bagOfPersonnage;
    private Place placeOfPersonnage;
    
    Personnage(String nameOfPersonnage, Place placeOfStart){
        this.NAME=nameOfPersonnage;
        this.LP_MAX=LP_MAX_DEFAULT;
        this.lp=this.LP_MAX;
        this.bagOfPersonnage=new Bag();
        this.placeOfPersonnage=placeOfStart;
    }
    
    public void addLP(int lpRecover){
        if (this.lp+lpRecover>this.LP_MAX){
            this.lp=this.LP_MAX;
        }
        else if (this.lp==0){
        }
        else{
            this.lp+=lpRecover;
        }
    }
    
    public void removeLP (int lpLost){
        if (this.lp-lpLost<0){
            this.lp=0;
        }
        else{
            this.lp-=lpLost;
        }
    }
    
    public void addItem(Item itemToAdd){
        this.bagOfPersonnage.addItem(itemToAdd); 
    }
    
    public String getDescription(){
        return this.NAME+" a "+this.lp+"/"+this.LP_MAX;
    }
    
    
    
    public void removeItem(Item itemToRemove){
        if (this.bagOfPersonnage.findItem(itemToRemove)){
            this.placeOfPersonnage.addItem(itemToRemove);
            this.bagOfPersonnage.removeItem(itemToRemove);   
        }
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
        this.placeOfPersonnage.removePersonnage(this);
        this.placeOfPersonnage = placeToGo;
    }
    
    public Place getPlace(){
        return this.placeOfPersonnage;
    }
    
    
    
    
}
