package src.game.test;
import static org.junit.Assert.*;

import org.junit.Test;

import src.game.core.Bag;
import src.game.core.Item;
import src.game.exception.BagFullException;

public class BagIT {

    @Test 
    public void createTest() {
        Bag bagTest = new Bag();
        
        assertTrue(bagTest.getItems().isEmpty());
        assertEquals(bagTest.getGold(), 0);
    }
    
    @Test (expected=BagFullException.class)
    public void capacityTest() {
        Bag bagTest = new Bag(0);
        Item it1 = new Item("", "", 1, null);
        
        bagTest.addItem(it1);
    }
    
    @Test 
    public void addTest() {
        
    }
}
