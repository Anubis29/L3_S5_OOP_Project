package src.game.core.place;

public final class Cave extends Place implements DarkPlace {

	private static final String NAME = "Cave";
	
	private boolean isLighted;
	
	public Cave() {
		super(Cave.NAME);
		this.isLighted = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void light() {
		this.isLighted = true;
	}
	
	@Override 
	public String getDescription() {
	    return "Bla";	    
	}
	
}
