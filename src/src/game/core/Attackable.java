package src.game.core;

import src.game.core.item.weapon.Weapon;

public interface Attackable {
    public default void attack(Attackable target, Weapon weapon) {
        target.getAttacked(weapon);
    }
    
    public abstract void getAttacked(Weapon weapon);
}
