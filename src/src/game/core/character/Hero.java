/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core.character;

import static java.sql.JDBCType.NULL;

import src.game.core.Attackable;
import src.game.core.item.Armor;
import src.game.core.item.weapon.Weapon;
import src.game.core.place.Place;

/**
 *
 * @author audrey
 */
public class Hero extends GCharacter implements Attackable {
    
    private Armor armorOfHero;
    
    Hero(String nameOfPersonnage, Place placeOfStart){
        super(nameOfPersonnage,placeOfStart);
        this.armorOfHero = null;
    }
    
    public void attack(Attackable target, Weapon weapon){
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
}
