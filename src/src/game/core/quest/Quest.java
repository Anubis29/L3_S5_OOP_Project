package src.game.core.quest;

import java.util.List;

import src.game.core.Command;

public abstract class Quest {
	
	private boolean isComplete;
	private boolean isStarted;
	private boolean startFlag = false;
	
	public Quest() {
		this.isComplete = false;
		this.isStarted = false;
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
	
	
	protected void onStart() {}
	protected boolean onUpdate() { return false; }
	protected void onComplete() {}
	protected void onUserAction(Command cmd, List<Object> args) {}
}
