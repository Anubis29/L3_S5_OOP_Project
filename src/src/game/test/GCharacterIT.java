package src.game.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.game.core.character.GCharacter;
import src.game.core.item.Item;
import src.game.core.item.weapon.Sword;
import src.game.core.place.Cave;
import src.game.core.place.Place;
import src.game.exception.DeadCharacterException;

public class GCharacterIT {
    
    private final String C_NAME = "Player";
    private final int C_MAX_LP = 100; 
    private Place cPlace;
    
    private GCharacter testC;
    
    @Before
    public void setUp() {
        cPlace = new Cave();
        testC = new GCharacter(C_NAME, cPlace, C_MAX_LP);
        
    }
    
    @Test
    public void gettersTest() {
        assertEquals(testC.getName(), C_NAME);
        assertEquals(testC.getPlace(), cPlace);
        assertEquals(testC.getLP(), C_MAX_LP);
        assertFalse(testC.isDead());
        
        assertSame(cPlace.getCharacter(C_NAME), testC);
    }
    
    @Test
    public void deadAndLPTest() {
        final int TMP_LP = 5;
        
        testC.removeLP(TMP_LP);
        assertEquals(testC.getLP(), C_MAX_LP - TMP_LP);
        testC.addLP(TMP_LP);
        assertEquals(testC.getLP(), C_MAX_LP);
        
        // cap to max
        testC.addLP(TMP_LP);
        assertEquals(testC.getLP(), C_MAX_LP); 


        assertFalse(testC.isDead());
        testC.removeLP(Integer.MAX_VALUE);
        assertTrue(testC.isDead());
        
        try {
            testC.removeLP(0);
        }catch(DeadCharacterException e) {
            
        }
        
        try {
            testC.addLP(0);
        }catch(DeadCharacterException e) {
            
        }
    }
    
    
    @Test
    public void moveTest() {
        GCharacter testC_2 = new GCharacter(C_NAME, null);
        
        assertNull(testC_2.getPlace());
        assertFalse(cPlace.findCharacter(testC_2));
        
        // set a new place
        testC_2.setPlace(cPlace);
        assertSame(testC_2.getPlace(), cPlace);
        assertTrue(cPlace.findCharacter(testC_2));
        
       // set a null place
        testC_2.setPlace(null);
        assertNull(testC_2.getPlace());
        assertFalse(cPlace.findCharacter(testC_2));
    }
    
    @Test
    public void itemTest() {
        Item ti1 = new Sword();
        
        testC.addItem(ti1);
        testC.dropItem(ti1);
        
        // should not be in the character anymore
        assertTrue(cPlace.findItem(ti1));
    }
}
