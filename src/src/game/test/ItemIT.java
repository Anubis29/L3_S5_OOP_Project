package src.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.game.core.Bag;
import src.game.core.Item;
import src.game.core.Container;
import src.game.exception.ItemContainerException;

public class ItemIT {
    @Test
    public void createAndGettersTest() {
        final String DESCRIPTION = "Desc";
        final String NAME = "Name";
        final int VOLUME = 10;
        
        Item testItem = new Item(NAME, VOLUME, DESCRIPTION);
        
        assertEquals(testItem.getDescription(), DESCRIPTION);
        assertEquals(testItem.getName(), NAME);
        assertEquals(testItem.getVolume(), VOLUME);
        assertEquals(testItem.getContainer(), null);
        
    }
    
    @Test
    public void setContainerTest() {
        final String DESCRIPTION = "Desc";
        final String NAME = "Name";
        final int VOLUME = 10;
        
        Item testItem = new Item(NAME, VOLUME, DESCRIPTION);
        Bag testContainer1 = new Bag();
        Bag testContainer2 = new Bag();
        Bag testContainer3 = new Bag(5);

        changeContainer(testItem, testContainer1, testContainer2);

        testItem.setContainer(null);
        assertSame(testItem.getContainer(), null);
        assertFalse(testContainer2.find(testItem));

        changeContainer(testItem, testContainer2, testContainer3);

    }
    
    public void changeContainer(Item it, Container c1, Container c2){
        try {
            it.setContainer(c1);
        }catch(ItemContainerException e) {
            fail();
        }
        assertSame(it.getContainer(), c1);
        assertTrue(c1.find(it));
        
        try{
            it.setContainer(c2);
        }catch(ItemContainerException e) {
            assertTrue(c1.find(it));
            assertFalse(c2.find(it));
            assertSame(it.getContainer(), c1);
        }
    }
}
