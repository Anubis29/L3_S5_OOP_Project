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
	public static final UI_Mode sDEFAULT_IO_MODE = UI_Mode.CONSOLE;

	private static UI_Mode sIO_Mode = sDEFAULT_IO_MODE;
	private static boolean sIO_ModeCanChange = true;
	
	UI_Mode_Selector(){
		sIO_ModeCanChange = false;
	}
		
	public static final void setMode(UI_Mode mode) 
	{
		if(sIO_ModeCanChange) {
			sIO_Mode = mode;
		}
	}
	
	public static final UI_Mode getMode() 
	{ 
		return sIO_Mode;
	} 
}
