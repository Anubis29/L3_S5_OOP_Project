package src.game.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.game.core.Exit;
import src.game.core.GCharacter;
import src.game.core.Item;
import src.game.core.Place;
import src.game.exception.GameException;

public class PlaceIT {
    private final String NAME = "Place";
    private final String DESCRIPTION = "Desc";
    
    private Place testPlace;
            
    @Before
    public void setUp() {
        testPlace = new Place(NAME, DESCRIPTION);
    }
    
    
    @Test 
    public void gettersTest(){
        assertEquals(testPlace.getName(), NAME);
        assertEquals(testPlace.getDescription(), DESCRIPTION);
        assertTrue(testPlace.getList().isEmpty());
        assertTrue(testPlace.getCharacters().isEmpty());
    }
    
    @Test
    public void testExit() {
        final String EXIT_NAME = "Exit";
        final String EXIT_PLACE_NAME = "ExitPlace";
   
        final Place EXIT_PLACE = new Place(EXIT_PLACE_NAME, null);
        final Exit TEST_EXIT = new Exit(EXIT_NAME, EXIT_PLACE);
        
        testPlace.addExit(TEST_EXIT);
        assertSame(testPlace.getExit(EXIT_PLACE_NAME), TEST_EXIT);
        assertNull(testPlace.getExit("Not existing place"));
    }
    
    @Test 
    public void itemContainerTest() {
        // add test
        final String ITEM_NAME_1 = "Item1";
        final String ITEM_NAME_2 = "Item2";
        final int ITEM_CAPACITY = 1;
        final String ITEM_DESCRIPTION = null;
        
        final Item ITEM_TEST_1 = new Item(ITEM_NAME_1, ITEM_CAPACITY, ITEM_DESCRIPTION );
        final Item ITEM_TEST_2 = new Item(ITEM_NAME_2, ITEM_CAPACITY, ITEM_DESCRIPTION);

        // ensure can't find not existing item
        assertFalse(testPlace.find(ITEM_TEST_1));
        
        // adding items
        testPlace.add(ITEM_TEST_1);
        testPlace.add(ITEM_TEST_2);
        
        try {
            testPlace.add(null);
        }catch(GameException e) {
            
        }

        assertEquals(testPlace.getList().size(), 2);
        assertSame(ITEM_TEST_1.getContainer(), testPlace);
        assertSame(ITEM_TEST_2.getContainer(), testPlace);
        assertTrue(testPlace.find(ITEM_TEST_1));
        assertTrue(testPlace.find(ITEM_TEST_2));
        assertSame(testPlace.get(ITEM_TEST_1.getName()), ITEM_TEST_1);
        assertSame(testPlace.get(ITEM_TEST_2.getName()), ITEM_TEST_2);

        // removing item
        /*
         *  Should be one item in the place (item 2),
         *  the item place should be reset to null
         *  and we should not be able to find the item
         *  removing twice the same item should return false
         */
     
        testPlace.remove(ITEM_TEST_1);
        testPlace.remove(ITEM_TEST_1);


        assertEquals(testPlace.getList().size(), 1);
        assertNull(ITEM_TEST_1.getContainer());
        assertFalse(testPlace.find(ITEM_TEST_1));
        
        assertSame(testPlace.get(ITEM_TEST_1.getName()), null);
        assertSame(testPlace.get(ITEM_TEST_2.getName()), ITEM_TEST_2);
    }
    
    @Test 
    public void characterAddAndRemove(){
        final String NAME_ALICE = "Alice";
        final String NAME_BOB = "Bob";
        
        final GCharacter Alice = new GCharacter(NAME_ALICE, (Place) null);
        final GCharacter Bob = new GCharacter(NAME_BOB, (Place) null);

        
        // ensure can't find not existing item
        /*assertFalse(testPlace.findCharacter(Alice));
        
        // adding items
        testPlace.addItem(Alice);
        testPlace.addItem(ITEM_TEST_2);
        
        try {
            testPlace.addItem(null);
        }catch(GameException e) {
            
        }

        assertEquals(testPlace.getItems().size(), 2);
        assertSame(ITEM_TEST_1.getContainer(), testPlace);
        assertSame(ITEM_TEST_2.getContainer(), testPlace);
        assertTrue(testPlace.findItem(ITEM_TEST_1));
        assertTrue(testPlace.findItem(ITEM_TEST_2));
        assertSame(testPlace.getItem(ITEM_TEST_1.getName()), ITEM_TEST_1);
        assertSame(testPlace.getItem(ITEM_TEST_2.getName()), ITEM_TEST_2);
*/
        // removing item
        /*
         *  Should be one item in the place (item 2),
         *  the item place should be reset to null
         *  and we should not be able to find the item
         *  removing twice the same item should return false
         */
     /*
        testPlace.removeItem(ITEM_TEST_1);
        testPlace.removeItem(ITEM_TEST_1);*/


      /*  assertEquals(testPlace.getItems().size(), 1);
        assertNull(ITEM_TEST_1.getContainer());
        assertFalse(testPlace.findItem(ITEM_TEST_1));
        
        assertSame(testPlace.getItem(ITEM_TEST_1.getName()), null);
        assertSame(testPlace.getItem(ITEM_TEST_2.getName()), ITEM_TEST_2);
    */}
}
