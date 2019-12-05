package src.game.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.game.core.character.GCharacter;
import src.game.core.exit.Exit;
import src.game.core.item.Item;
import src.game.core.item.potion.SuperHealPotion;
import src.game.core.item.weapon.Sword;
import src.game.core.place.Place;
import src.game.exception.GameException;

public class PlaceIT {
    private final String NAME = "Place";
    
    private Place testPlace;
            
    @Before
    public void setUp() {
        testPlace = new Place(NAME, null);
    }
    
    
    @Test 
    public void gettersTest(){
        assertTrue(testPlace.getItems().isEmpty());
        assertTrue(testPlace.getCharacters().isEmpty());
    }
    
    @Test
    public void testExit() {
        final String EXIT_NAME = "Exit";
   
        final Place EXIT_PLACE = new Place(NAME, null);
        final Exit TEST_EXIT = new Exit(EXIT_NAME, EXIT_PLACE);
        
        testPlace.addExit(TEST_EXIT);
        assertSame(testPlace.getExit(EXIT_PLACE.getName()), TEST_EXIT);
        assertNull(testPlace.getExit("Not existing place"));
    }
    
    @Test 
    public void itemContainerTest() {
        // add test        
        final Item ITEM_TEST_1 = new Sword();
        final Item ITEM_TEST_2 = new SuperHealPotion();

        // ensure can't find not existing item
        assertFalse(testPlace.findItem(ITEM_TEST_1));
        
        // adding items
        testPlace.addItem(ITEM_TEST_1);
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

        // removing item
        /*
         *  Should be one item in the place (item 2),
         *  the item place should be reset to null
         *  and we should not be able to find the item
         *  removing twice the same item should return false
         */
     
        testPlace.removeItem(ITEM_TEST_1);
        testPlace.removeItem(ITEM_TEST_1);


        assertEquals(testPlace.getItems().size(), 1);
        assertNull(ITEM_TEST_1.getContainer());
        assertFalse(testPlace.findItem(ITEM_TEST_1));
        
        assertSame(testPlace.getItem(ITEM_TEST_1.getName()), null);
        assertSame(testPlace.getItem(ITEM_TEST_2.getName()), ITEM_TEST_2);
    }
    
    @Test 
    public void characterAddAndRemove(){
        final String NAME_ALICE = "Alice";
        final String NAME_BOB = "Bob";
        
        final GCharacter ALICE = new GCharacter(NAME_ALICE, null, (Place) null);
        final GCharacter BOB = new GCharacter(NAME_BOB, null, (Place) null);

        
        // ensure can't find not existing item
        assertFalse(testPlace.findCharacter(ALICE));
        
        // adding items
        testPlace.addCharacter(ALICE);
        testPlace.addCharacter(BOB);
        
        try {
            testPlace.addCharacter(null);
        }catch(GameException e) {
            
        }

        assertEquals(testPlace.getCharacters().size(), 2);
        assertSame(ALICE.getPlace(), testPlace);
        assertSame(BOB.getPlace(), testPlace);
        assertTrue(testPlace.findCharacter(ALICE));
        assertTrue(testPlace.findCharacter(BOB));
        assertSame(testPlace.getCharacter(ALICE.getName()), ALICE);
        assertSame(testPlace.getCharacter(BOB.getName()), BOB);

        // removing item
        /*
         *  Should be one item in the place (item 2),
         *  the item place should be reset to null
         *  and we should not be able to find the item
         *  removing twice the same item should return false
         */
     
        assertTrue(testPlace.removeCharacter(ALICE));
        assertFalse(testPlace.removeCharacter(ALICE));

        assertEquals(testPlace.getCharacters().size(), 1);
        assertNull(ALICE.getPlace());
        assertFalse(testPlace.findCharacter(ALICE));
        
        assertSame(testPlace.getCharacter(ALICE.getName()), null);
        assertSame(testPlace.getCharacter(BOB.getName()), BOB);
    }
}
