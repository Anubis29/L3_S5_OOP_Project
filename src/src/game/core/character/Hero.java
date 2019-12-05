/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core.character;

import src.game.core.item.Armor;
import src.game.core.item.weapon.Weapon;
import src.game.core.place.Place;

/**
 *
 * @author audrey
 */
public class Hero extends GCharacter implements Combative {
    
    private final static String NAME = "Hero";
    
    private Armor armorOfHero;
    
    public Hero(Place placeOfStart){
        super(Hero.NAME ,null, placeOfStart);
        this.armorOfHero = null;
    }
    
    public void attack(Combative target, Weapon weapon){
        if (this.findItem(weapon)){
            target.getAttacked(weapon);
        }
    }
    
    @Override
    public void getAttacked(Weapon weapon){
        int damages = weapon.getDamages() - this.armorOfHero.getShield();
        this.removeLP(damages);    
    }
    
    public void switchArmor(Armor newArmor){
        this.armorOfHero=newArmor;
    }

	@Override
	public Weapon getActiveWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActiveWeapon(Weapon weapon) {
		// TODO Auto-generated method stub
		
	}
}
