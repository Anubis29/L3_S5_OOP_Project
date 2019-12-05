package src.game.core.item.weapon;

import src.game.core.item.Item;

public class Weapon extends Item {
    private final int DAMAGES;
    
    public Weapon(String name, String desc, int volume, int damages){
        super(name, desc, volume);
        this.DAMAGES = damages;
    }
    
    public int getDamages() {
        return this.DAMAGES;
    }

    @Override
    public String getDescription() {
        return "The " + this.getDamages() + " is a weapon. It can inflict " + this.DAMAGES + " points of damages.";
    }
}
