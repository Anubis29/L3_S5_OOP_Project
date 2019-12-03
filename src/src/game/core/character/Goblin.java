/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core.character;

import java.util.Random;

import src.game.core.Attackable;
import src.game.core.item.weapon.Weapon;
import src.game.core.place.Place;

/**
 *
 * @author audrey
 */
public class Goblin extends Monster implements Attackable{
    private final static int SUCCESS_RATE_DEFAULT = 4;
    
    Goblin(String nameOfPersonnage, Place placeOfStart){
        super(nameOfPersonnage, placeOfStart, Goblin.SUCCESS_RATE_DEFAULT);
    }
}
