package src.game.core.place;

import src.game.core.item.weapon.DuskBlade;

public class DragonsLair extends Place {

    private static final String NAME = "Dragon's Lair";
    
    public DragonsLair(DuskBlade blade) {
        super(DragonsLair.NAME, null);
        
        this.addItem(blade);
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }



}
