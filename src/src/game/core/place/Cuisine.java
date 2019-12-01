package src.game.core.place;

import java.util.List;

import src.game.core.Exit;
import src.game.core.Item;
import src.game.core.Place;

public class Cuisine extends Place {

    private static final String NAME = "Cuisine"; 
    private static final String DESCRIPTION = "Une belle cuisine";
    
    public Cuisine(List<Exit> exits) {
        super(Cuisine.NAME, Cuisine.DESCRIPTION);
        
        // ici on créée les objets que l'on veut dans la pièce.
        this.addItem(new Item("Pomme", 1, "Une pomme verte"));
        this.addItem(new Item("Couteau", 1, "Un couteau bien aiguisé"));
        
        // Il y a maintenant une pomme et un couteau dans la cuisine.
        // Ensuite il faudra y ajouter les exits qu'on veut.
        for(Exit exit : exits) {
            this.addExit(exit);
        }
        
        // Il y a maintenant toutes les sorties attachées à cette Cuisine
    }
}
