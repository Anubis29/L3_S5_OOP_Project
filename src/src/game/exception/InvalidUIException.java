package src.game.exception;

import src.game.ui.UI_Mode;

public class InvalidUIException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private UI_Mode mErrorMode;
	
	public InvalidUIException(String msg, UI_Mode mode) {
		super(msg);
		mErrorMode = mode;
	}
	
	public UI_Mode getMode() { return mErrorMode; }

}
