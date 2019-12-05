package src.game.core.item.weapon;

import src.game.core.item.Useable;

public class DuskBlade extends Weapon implements Useable{

    private static final String NAME = "Duskblade"; 
    private static final int VOLUME = 0;
    private static final int DAMAGES = 50;
    private static final String DESCRIPTION = "The pure power, in the hollow of your hand.";
        
    public DuskBlade() {
        super(DuskBlade.NAME, DuskBlade.DESCRIPTION, DuskBlade.VOLUME, DuskBlade.DAMAGES);
    }

    @Override
    public boolean use(Object target) {
        return true;
    }

}
