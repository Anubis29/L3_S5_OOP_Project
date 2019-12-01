package src.game.core.item;

import src.game.core.place.DarkPlace;

public class Torch extends Item implements Useable<DarkPlace> {
    
    private static final String NAME = "Torch";
    private static final int VOLUME = 1;
    private static final String DESCRIPTION = "The torch allow you to light dark areas!";
    
    public Torch() {
        super(Torch.NAME, Torch.VOLUME);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void use(DarkPlace target) {
        target.light();        
    }

    @Override
    public String getDescription() {
        return Torch.DESCRIPTION;
    }

}
