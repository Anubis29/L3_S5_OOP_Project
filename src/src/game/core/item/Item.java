package src.game.core.item;

import src.game.core.Lookeable;
import src.game.core.container.ItemContainer;
import src.game.exception.ItemContainerException;

public class Item implements Lookeable{
    private static final ItemContainer DEFAULT_CONTAINER = null;
    
	private final String NAME;
	private final int VOLUME ;
	private ItemContainer container;
	private String description;
	
	//
	public Item(String name, String description, int volume){
		this.NAME = name;
		this.VOLUME= volume;
		this.container = Item.DEFAULT_CONTAINER;
		this.description = description;
	}

	
  //les accesseurs (getter)
	public String getName() {
		return this.NAME;
	}
	
	public int getVolume() {
		return this.VOLUME;
	}
	
	public ItemContainer getContainer() {
		return this.container;
	}

 //les accesseurs (setter)
	public void setContainer(ItemContainer container) throws ItemContainerException {
	    
	    ItemContainer newContainer = container;
	    ItemContainer oldContainer = this.container;
	    
	    if(newContainer == oldContainer) { // Condition d'arrêt de récursion
	        return;
	    }
	    
	    if(oldContainer != null) {
	        this.container = null;
            oldContainer.removeItem(this);
        }
            
        this.container = newContainer;
        if(newContainer != null) {
           try {
               newContainer.addItem(this);
           }catch(ItemContainerException e){
               this.container = null;
               this.setContainer(oldContainer);
               throw e;
           }
       }
	}
	
	@Override
	public String getDescription() {
		return this.getName() + " : " + this.description;
	}

	@Override
	public void setDescription(String desc) {
		this.description = desc;
	}
}