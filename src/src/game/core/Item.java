package src.game.core;

public class Item implements Lookeable{
	private  final String DESCRIPTION;
	private final String NAME;
	private final int VOLUME ;
	private ItemContainer container;
	
	//
	public Item(String description, String name, int volume, ItemContainer container){
		this.DESCRIPTION= description;
		this.NAME = name;
		this.VOLUME= volume;
		this.container = container;
		
		if(container != null) {
		    container.addItem(this);
		}
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
	
	public String getDescription() {
		return this.DESCRIPTION;
	}


 //les accesseurs (setter)
	public void setContainer(ItemContainer container) {
	    
	    ItemContainer newContainer = container;
	    ItemContainer oldContainer = this.container;
	    
	    if(newContainer != oldContainer) {
	        
	        if(oldContainer != null) {
	            this.container = null;
	            oldContainer.removeItem(this);
	        }
	        
	        this.container = newContainer;
	        if(newContainer != null) {
	            newContainer.addItem(this);
	        }
	    }
	    
	}

}