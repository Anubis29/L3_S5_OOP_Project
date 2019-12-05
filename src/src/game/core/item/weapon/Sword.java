package src.game.core.item.weapon;

public class Sword extends Weapon{

    private static final String NAME = "Sword";
    private static final int VOLUME = 5;
    private static final int DAMAGES = 2;
    private static final String DESCRIPTION = "A good way to slash monsters";
    
    public Sword() {
        super(Sword.NAME, Sword.DESCRIPTION, Sword.VOLUME, Sword.DAMAGES);
    }
    
}
