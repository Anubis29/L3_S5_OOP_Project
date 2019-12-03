package src.game.core.character;

import java.util.Random;

import src.game.core.Attackable;
import src.game.core.item.weapon.Weapon;
import src.game.core.place.Place;

public class Monster extends GCharacter implements Attackable {
    private final int SUCCESS_RATE;
    
    Monster(String name, Place placeOfStart, int successRate){
        super(name ,placeOfStart);
        this.SUCCESS_RATE = successRate;
    }
    
    public void attack(Attackable target, Weapon weapon){
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
