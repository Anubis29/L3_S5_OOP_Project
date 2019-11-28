package src.game.core.container;

import java.util.List;

import src.game.core.GCharacter;

public interface GCharacterContainer  {
    
    public abstract GCharacterContainer getCharacter(String name);
    public abstract List<GCharacterContainer> getCharacters();

    public abstract void addCharacter(GCharacter element);
    public abstract boolean findItem(GCharacter element);
    public abstract boolean removeItem(GCharacter element);
}
