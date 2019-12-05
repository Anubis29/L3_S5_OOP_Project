package src.game.core.quest;

import src.game.core.character.GCharacter;
import src.game.core.character.TalkingCharacter;
import src.game.core.exit.LockableExit;
import src.game.core.item.Item;
import src.game.ui.game.GameUI;

public class IntroductionQuest extends Quest {
	
	private final TalkingCharacter KING;
	private final Item INTRODUCTION_ITEM;
	
	private final GCharacter PLAYER;
	private final GameUI UI;
	
	private final String INTRO_TEXT;
	private final String WAITING_FOR_ITEM_TAKEN_TEXT;
	private final String POST_QUEST_TEXT;
	private final LockableExit EXIT;

	
	public IntroductionQuest(GCharacter player, TalkingCharacter king, String mainEnemy, LockableExit exit, Item introductionItem, String targetItem, String kingdom, GameUI ui) {
		this.KING = king;
		this.INTRODUCTION_ITEM = introductionItem;
		this.PLAYER = player;
		this.UI = ui;
		this.EXIT = exit;
		
		this.WAITING_FOR_ITEM_TAKEN_TEXT = "Take this " + introductionItem.getName() + ", it will help you during this journey!\n";
		
		this.INTRO_TEXT = 
				"Dear " + player.getName() + ", the " + kingdom + " is in danger !\n" + 
				mainEnemy + " want to rule us all. He is searching for the " + targetItem + ". With this powerfull artefact in" + 
				"his possession, he will destroy everyting we know. Please, find the " + targetItem + " before him!\n" + 
				"The " + targetItem + " is lost in the kingdom, I hope you will find it on time...\n" + 
				this.WAITING_FOR_ITEM_TAKEN_TEXT;
		
		this.POST_QUEST_TEXT = "You may find some usefull information in the village.\n";
		
	}
	
	@Override
	protected void onStart() {
		this.KING.setSentence(this.INTRO_TEXT);
		this.UI.displaySentence(KING);
		this.KING.getPlace().addItem(this.INTRODUCTION_ITEM);
		
		this.KING.setSentence(this.WAITING_FOR_ITEM_TAKEN_TEXT);
		this.EXIT.lock();
	}
	
	@Override
	public boolean onUpdate() {
		if(this.PLAYER.findItem(this.INTRODUCTION_ITEM)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void onComplete() {
		this.KING.setSentence(this.POST_QUEST_TEXT);
		this.EXIT.unlock();
		this.UI.display("\"" + this.EXIT.getName() + "\" is now unlocked!\n");
	}
}
