package src.game.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import src.game.core.place.Place;

@RunWith(Suite.class)
@SuiteClasses({ 
    BagIT.class, 
    ExitIT.class,
    ItemIT.class, 
    PlaceIT.class,
    GCharacterIT.class,
    HealPotionIT.class
})

public class GameTestSuite {

}
