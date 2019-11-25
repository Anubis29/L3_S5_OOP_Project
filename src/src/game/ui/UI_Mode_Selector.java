package src.game.ui;

/**
 * 
 * UI_Mode_Selector is the base class for every interface between the user and the application.
 * It cannot be instanciated and 
 * 
 * @author alexandre
 * @version 0.1
 */

abstract public class UI_Mode_Selector {
	public static final UI_Mode DEFAULT_IO_MODE = UI_Mode.CONSOLE;

	private static UI_Mode IO_Mode = UI_Mode_Selector.DEFAULT_IO_MODE;
	private static boolean IO_ModeCanChange = true;
	
	UI_Mode_Selector(){
		UI_Mode_Selector.IO_ModeCanChange = false;
	}
		
	public static final void setMode(UI_Mode mode) 
	{
		if(UI_Mode_Selector.IO_ModeCanChange) {
			UI_Mode_Selector.IO_Mode = mode;
		}
	}
	
	public static final UI_Mode getMode() 
	{ 
		return UI_Mode_Selector.IO_Mode;
	} 
}
