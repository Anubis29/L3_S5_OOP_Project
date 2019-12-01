package src.game.core.item;

public class Armor extends Item {
    private static final int DEFAULT_MAX_SHIELD = 10;
    private static final int DEFAULT_VOLUME = 10;
    private static final String DEFAULT_NAME = "Armor";
    
    private final int MAX_SHIELD;
    private int currentShield;
    
    public Armor() {
        super(Armor.DEFAULT_NAME, Armor.DEFAULT_VOLUME);
        this.MAX_SHIELD = DEFAULT_MAX_SHIELD;
        this.currentShield = this.MAX_SHIELD;
    }

    @Override
    public String getDescription() {
        return "The " + this.getName() + " protect from (" + this.currentShield + "/" + this.MAX_SHIELD + ") damages.";  
    }
}
