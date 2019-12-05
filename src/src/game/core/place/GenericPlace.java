package src.game.core.place;

public final class GenericPlace extends Place {

    private final String DESCRIPTION;
            
    public GenericPlace(String name, String description) {
        super(name, null);
        this.DESCRIPTION = description;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
