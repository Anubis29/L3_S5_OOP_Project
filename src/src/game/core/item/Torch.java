package src.game.core.item;

import src.game.core.place.DarkPlace;

public class Torch extends Item implements Useable {
        
    private static final String NAME = "Torch";
    private static final int VOLUME = 1;
    private static final String DESCRIPTION = "The torch allow you to light dark areas!";
    
    public Torch() {
        super(Torch.NAME, Torch.DESCRIPTION, Torch.VOLUME);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean use(Object target) {
    	DarkPlace lTarget = (DarkPlace) target;
    	if(lTarget == null) {
    		return false;
    	}
    	
        lTarget.light(); 
        return true;
    }

}
