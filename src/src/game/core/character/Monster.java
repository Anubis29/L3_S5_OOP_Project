package src.game.core.character;

import java.util.Random;

import src.game.core.item.weapon.Weapon;
import src.game.core.place.Place;

public abstract class Monster extends GCharacter implements Combative {
    private final int SUCCESS_RATE;
    
    
    Monster(String name, String description, Place placeOfStart, int successRate){
        super(name, description ,placeOfStart);
        this.SUCCESS_RATE = successRate;
    }
    
    public void attack(Combative target, Weapon weapon){
        if (this.findItem(weapon)){
            Random rand = new Random(); 
            if ((rand.nextInt(this.SUCCESS_RATE) + 1)==1){
                target.getAttacked(weapon);
            }
        }
    }

    @Override
    public void getAttacked(Weapon weapon) {
        this.removeLP(weapon.getDamages());
    }
    
    
}
