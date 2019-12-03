package src.game.core.container;

import java.util.List;

import src.game.core.character.GCharacter;

public interface GCharacterContainer  {
    
    public abstract GCharacter getCharacter(String name);
    public abstract List<GCharacter> getCharacters();

    public abstract void addCharacter(GCharacter element);
    public abstract boolean findCharacter(GCharacter element);
    public abstract boolean removeCharacter(GCharacter element);
}
