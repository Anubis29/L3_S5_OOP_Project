package src.game.test;
import static org.junit.Assert.*;

import org.junit.Test;

import src.game.core.Bag;
import src.game.core.item.Item;
import src.game.core.item.weapon.Sword;
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
        Item it1 = new Sword();
        
        bagTest.addItem(it1);
    }
    
    @Test (expected=RuntimeException.class)
    public void addNullTest() {
        Bag bagTest = new Bag(1);
        bagTest.addItem(null);
    }
    
    @Test 
    public void addAndRemoveTest() {
        Bag bag1 = new Bag();
        Item it1 = new Sword();
        bag1.addItem(it1);
        
        assertSame(bag1, it1.getContainer());
        assertSame(bag1.getItem(it1.getName()), it1);
        
        assertTrue(bag1.removeItem(it1));
        assertFalse(bag1.removeItem(null));

        assertEquals(bag1.getItems().size(), 0);
        assertSame(it1.getContainer(), null);
        
    }
    
    @Test
    public void addTest() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        Item it1 = new Sword();
        
        bag1.addItem(it1);
        bag2.addItem(it1);

        assertSame(bag2, it1.getContainer());
        assertEquals(bag1.getItems().size(), 0);
        assertSame(bag2.getItem(it1.getName()), it1);
    }
    
    @Test
    public void goldTest() {
        Bag bag1 = new Bag();
        final int GOLD_COUNT = 10;
        final int REMOVED_GOLD = 9;
        final int REMAINING_GOLD = GOLD_COUNT - REMOVED_GOLD;
        bag1.addGold(GOLD_COUNT);
        assertEquals(bag1.getGold(), GOLD_COUNT);
        assertTrue(bag1.removeGold(REMOVED_GOLD));
        assertEquals(bag1.getGold(), REMAINING_GOLD);
        assertFalse(bag1.removeGold(GOLD_COUNT));
        assertEquals(bag1.getGold(), REMAINING_GOLD);
        assertTrue(bag1.removeGold(bag1.getGold()));
        assertEquals(bag1.getGold(), 0);
    }
    
    @Test
    public void getAndFindItemTest() {
        
        Bag bag1 = new Bag();
        Item it1 = new Sword();
        
        bag1.addItem(it1);
        assertSame(it1, bag1.getItem(it1.getName()));
        assertTrue(bag1.findItem(it1));
        
        bag1.removeItem(it1);
        assertSame(null, bag1.getItem(it1.getName()));
        assertFalse(bag1.findItem(it1));

    }
    
   // public voi
}
