package src.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.game.core.Bag;
import src.game.core.container.ItemContainer;
import src.game.core.item.Item;
import src.game.core.item.weapon.Sword;
import src.game.exception.ItemContainerException;

public class ItemIT {
    @Test
    public void createTest() {
        Item testItem = new Sword();
        assertEquals(testItem.getContainer(), null); 
    }
    
    @Test
    public void setContainerTest() {
        
        Item testItem = new Sword();
        Bag testContainer1 = new Bag();
        Bag testContainer2 = new Bag();
        Bag testContainer3 = new Bag(5);

        changeContainer(testItem, testContainer1, testContainer2);

        testItem.setContainer(null);
        assertSame(testItem.getContainer(), null);
        assertFalse(testContainer2.findItem(testItem));

        changeContainer(testItem, testContainer2, testContainer3);

    }
    
    public void changeContainer(Item it, ItemContainer c1, ItemContainer c2){
        try {
            it.setContainer(c1);
        }catch(ItemContainerException e) {
            fail();
        }
        assertSame(it.getContainer(), c1);
        assertTrue(c1.findItem(it));
        
        try{
            it.setContainer(c2);
        }catch(ItemContainerException e) {
            assertTrue(c1.findItem(it));
            assertFalse(c2.findItem(it));
            assertSame(it.getContainer(), c1);
        }
    }
}
