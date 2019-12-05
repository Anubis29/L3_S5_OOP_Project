package src.game.core.character;

import src.game.core.item.weapon.Weapon;

public interface Combative {
    
	public abstract Weapon getActiveWeapon();
	public abstract void setActiveWeapon(Weapon weapon);
	
    public default void attack(Combative target) {
        target.getAttacked(this.getActiveWeapon());
    }
    
    public abstract void getAttacked(Weapon weapon);
}
