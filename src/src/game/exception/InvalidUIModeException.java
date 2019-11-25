package src.game.exception;

import src.game.ui.UI_Mode;

public class InvalidUIModeException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private final UI_Mode ERROR_UI_MODE;
	
	public InvalidUIModeException(String msg, UI_Mode mode) {
		super(msg);
		this.ERROR_UI_MODE = mode;
	}
	
	public UI_Mode getMode() { return this.ERROR_UI_MODE; }

}
