package src.game.core.item.potion;

public class SuperHealPotion extends HealPotion {
    private static final String NAME = "Super Heal Potion";
    private static final int VOLUME = 3;
    private static final int HEAL = 10;
    
    public SuperHealPotion() {
        super(SuperHealPotion.NAME, SuperHealPotion.VOLUME, SuperHealPotion.HEAL);
    }
}
