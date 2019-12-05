package src.game.core.quest;

import java.util.List;

import src.game.core.Command;
import src.game.ui.game.GameUI;

public abstract class Quest {
	
	private boolean isComplete;
	private boolean isStarted;
	private boolean startFlag = false;
	
	private final String NAME;
	private String infos;
	protected final GameUI UI;
	
	public Quest(String name, String info, GameUI ui) {
		this.isComplete = false;
		this.isStarted = false;
		this.NAME = name;
		this.infos = info;
		this.UI = ui;
	}
	
	public final String getName() {
		return this.NAME;
	}
	
	public final String getInfos() {
		return this.infos;
	}
	
	protected final void setInfos(String infos) {
		this.infos = infos;
	}
	
	public final void start() {
		this.isStarted = true;
	}
	
	public final void update() {
		if(!this.isStarted) {
			return;
		}
		
		if(!this.startFlag) {
			this.onStart();
			this.startFlag = true;
		}
		
		if(!this.isComplete) {
			this.isComplete = onUpdate();
			
			if(this.isComplete) {
				this.onComplete();
			}
		}
	}
	
	public final boolean isStarted() {
		return this.isStarted;
	}
	
	public final boolean isComplete() {
		return this.isComplete;
	}
	
	
	protected void onStart() {
		this.UI.display(">>The quest \"" + this.NAME + "\" started!\n");
	}
	protected boolean onUpdate() { return false; }
	
	protected void onComplete() {
		this.UI.display(">>You completed the quest \"" + this.NAME + "\"!\n");
	}
	
	public void onUserAction(Command cmd, List<Object> args) {}
}
