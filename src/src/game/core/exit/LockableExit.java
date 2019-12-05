package src.game.core.exit;

import src.game.core.Lockable;
import src.game.core.place.Place;

public class LockableExit extends Exit implements Lockable{

    private boolean isLocked;
    
    public LockableExit(String name, Place place) {
        super(name, place);
        isLocked = false;
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public void lock() {
        this.isLocked = true;
    }

    @Override
    public void unlock() {
        this.isLocked = false;
    }
    
    @Override
    public boolean canCross() {
        return !this.isLocked();
    }

}
