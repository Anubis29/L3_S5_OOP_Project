package src.game.core.item.potion;

import src.game.core.character.GCharacter;

/**
 * 
 * @author alexandre
 * 
 * The heal potion allows a GCharacter to recover some life points.
 * Using a heal potion on a dead GCharacter have no effect.
 *  
 */
public abstract class HealPotion extends Potion { 
    
    private int recoveredLP;
    
    
    public HealPotion(String name, int volume, int lpRecover) {
        super(name, volume);
        this.recoveredLP = lpRecover;
    }
    
    /**
     * Get the amount of LP recovered using the potion
     * @return The amount of LP recovered using the potion
     */
    public int getHeal() {
        return this.recoveredLP;
    }
    
    /**
     * Use the potion on the target. The target will instantly recover the amount of LP specified by {@link#getHeal() }.
     * @param target The target of the potion
     */
    @Override
    public void use(GCharacter target) {
        target.addLP(this.recoveredLP);
    }

    @Override 
    public String getDescription() {
        return "The " + this.getName() + " adds " + this.recoveredLP + " lp to the target.";
    }
}
