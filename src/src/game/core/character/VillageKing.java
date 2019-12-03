package src.game.core.character;

import src.game.core.item.weapon.Sword;
import src.game.core.place.Place;

public final class VillageKing extends GCharacter implements Talkative {

    private boolean mIntroPassed;
    
    private static final String mIntroText =
            "Dear Hero, our kingdom is in danger ! I heard the [MECHANT] is trying to find the [SWORD]. With this artefact in"
            + "his hand, he will destroy everyting. Please, find the [SWORD] before him ! The sword is located at the top of the dragon's"
            + "lair, behind the great montains."
            + "Take this sword, it will help you during your journey.";
            
    private static final String mPostText = "The sword is located at the top of the dragon's lair, behind the great montains.";
    
    public VillageKing(String nameOfPersonnage, Place placeOfStart) {
        super(nameOfPersonnage, placeOfStart);
        this.mIntroPassed = false;
    }


    
    
    @Override
    public String getSentence() {
        if(!mIntroPassed) {
            return mIntroText;
        }else {
            return mPostText;
        }
        //if(this.getBag().getItem(name))
    }
    
}
