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
    
    @Test (expected=RuntimeException.class)
    public void addNullTest() {
        Bag bagTest = new Bag(1);
        bagTest.addItem(null);
    }
    
    @Test 
    public void addAndRemoveTest() {
        Bag bag1 = new Bag();
        Item it1 = new Item("Item1", "Item1", 1, null);
        bag1.addItem(it1);
        
        assertSame(bag1, it1.getContainer());
        assertSame(bag1.getItem("Item1"), it1);
        
        assertTrue(bag1.removeItem(it1));
        assertFalse(bag1.removeItem(null));

        assertEquals(bag1.getItems().size(), 0);
        assertSame(it1.getContainer(), null);
        
    }
    
    @Test
    public void addTest() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        Item it1 = new Item("Item1", "Item1", 1, null);
        
        bag1.addItem(it1);
        bag2.addItem(it1);

        assertSame(bag2, it1.getContainer());
        assertEquals(bag1.getItems().size(), 0);
        assertSame(bag2.getItem("Item1"), it1);
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
        final String ITEM_NAME = "Item";
        
        Bag bag1 = new Bag();
        Item it1 = new Item("", ITEM_NAME, 0, null);
        
        bag1.addItem(it1);
        assertSame(it1, bag1.getItem(ITEM_NAME));
        assertTrue(bag1.findItem(it1));
        
        bag1.removeItem(it1);
        assertSame(null, bag1.getItem(ITEM_NAME));
        assertFalse(bag1.findItem(it1));

    }
    
   // public voi
}
