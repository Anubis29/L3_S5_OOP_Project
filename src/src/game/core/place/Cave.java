package src.game.core.place;

public final class Cave extends Place implements DarkPlace {

	private static final String DARK_DECRIPTION = "Is too dark to see.";
	private final String LIGHT_DESCRIPTION;

	private boolean isLighted;
	
	
	public Cave(String name, String description) {
		super(name, Cave.DARK_DECRIPTION);
		this.LIGHT_DESCRIPTION = description;
		this.isLighted = false;
	}

	@Override
	public void light() {
		this.isLighted = true;
		this.setDescription(this.LIGHT_DESCRIPTION);
	}
	
	@Override
	public boolean isLighted() {
		return this.isLighted;
	}
	
}
