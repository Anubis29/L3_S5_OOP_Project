package src.game.core.item.potion;

import src.game.core.item.Item;
import src.game.core.item.Useable;

public abstract class Potion extends Item implements Useable{

	
    public Potion(String name, String desc, int volume) {
        super(name, desc, volume);
    }
}
