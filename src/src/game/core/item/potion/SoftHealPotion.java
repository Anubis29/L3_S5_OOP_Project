package src.game.core.item.potion;

public class SoftHealPotion extends HealPotion {
    private static final String NAME = "Soft Heal Potion";
    private static final int VOLUME = 1;
    private static final int HEAL = 2;
    
    public SoftHealPotion() {
        super(SoftHealPotion.NAME, SoftHealPotion.VOLUME, SoftHealPotion.HEAL);
    }
}
