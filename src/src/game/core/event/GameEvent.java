package src.game.core.event;

import src.game.core.Game;

public interface GameEvent {
    
    public abstract boolean eventComplete();
    public abstract boolean processEvent(Game g);
}
