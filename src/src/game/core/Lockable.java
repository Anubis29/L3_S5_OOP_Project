package src.game.core;

public interface Lockable {
    public boolean isLocked();
    public void lock();
    public void unlock();
}
