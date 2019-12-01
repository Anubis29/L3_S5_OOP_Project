package src.game.core.item.potion;

import src.game.core.GCharacter;
import src.game.core.item.Item;
import src.game.core.item.Useable;

public abstract class Potion extends Item implements Useable<GCharacter>{

    public Potion(String name, int volume) {
        super(name, volume);
        // TODO Auto-generated constructor stub
    }
}
