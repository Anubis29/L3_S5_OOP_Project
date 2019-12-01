package src.game.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.game.core.GCharacter;
import src.game.core.item.potion.*;

public class HealPotionIT {
    private final int MAX_LP = 100;
    private final int HP_REMOVED = 60;
    
    private GCharacter c;
    private HealPotion softPot, medPot, superPot;
    
    @Before
    public void setUp() {
        c = new GCharacter("Perso", null, MAX_LP);
        softPot = new SoftHealPotion();
        medPot = new MediumHealPotion();
        superPot = new SuperHealPotion();
    }
    
    @Test
    public void testPot1() {
        c.removeLP(HP_REMOVED);
        softPot.use(c);
        assertEquals(c.getLP(), MAX_LP - HP_REMOVED + softPot.getHeal());
    }
    
    @Test
    public void testPot2() {
        c.removeLP(HP_REMOVED);
        medPot.use(c);
        assertEquals(c.getLP(), MAX_LP - HP_REMOVED + medPot.getHeal());
    }
    
    @Test
    public void testPot3() {
        c.removeLP(HP_REMOVED);
        superPot.use(c);
        assertEquals(c.getLP(), MAX_LP - HP_REMOVED + superPot.getHeal());
    }
}
