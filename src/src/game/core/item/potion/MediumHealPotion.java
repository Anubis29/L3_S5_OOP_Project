package src.game.core.item.potion;

public class MediumHealPotion extends HealPotion {
    private static final String NAME = "Medium Heal Potion";
    private static final int VOLUME = 2;
    private static final int HEAL = 5;
    
    public MediumHealPotion() {
        super(MediumHealPotion.NAME, MediumHealPotion.VOLUME, MediumHealPotion.HEAL);
    }
}
