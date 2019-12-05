package src.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.game.core.exit.Exit;
import src.game.core.place.Cave;
import src.game.core.place.Place;

public class ExitIT {
    @Test
    public void test() {
        final String NAME = "Exit";
        final Place PLACE = new Place("Name", null);
        
        Exit exit = new Exit(NAME, PLACE);
        assertTrue(exit.canCross());
        assertSame(exit.getPlace(), PLACE);
        assertEquals(exit.getName(), NAME);
    }
}
