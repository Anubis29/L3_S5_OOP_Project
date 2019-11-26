package src.game.ui;

/**
 * 
 * UI_Mode_Selector is the base class for every interface between the user and the application.
 * It cannot be instantiated and 
 * 
 * @author alexandre
 * @version 0.1
 */

abstract public class UI_ModeSelector {
	public static final UI_Mode DEFAULT_UI_MODE = UI_Mode.CONSOLE;

	private static UI_Mode uiMode = UI_ModeSelector.DEFAULT_UI_MODE;
	private static boolean uiModeCanChange = true;
	
		
	public static final void setMode(UI_Mode mode) 
	{
		if(UI_ModeSelector.uiModeCanChange) {
			UI_ModeSelector.uiMode = mode;
		}
	}
	
	UI_ModeSelector(){
		UI_ModeSelector.uiModeCanChange = false;
	}
	
	public static final UI_Mode getMode() 
	{ 
		return UI_ModeSelector.uiMode;
	} 
}
