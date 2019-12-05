package src.game.core;

import java.util.ArrayList;
import java.util.List;

import src.game.core.character.GCharacter;
import src.game.core.character.Hero;
import src.game.core.character.Talkative;
import src.game.core.character.TalkingCharacter;
import src.game.core.exit.Exit;
import src.game.core.exit.LockableExit;
import src.game.core.item.Item;
import src.game.core.item.Useable;
import src.game.core.item.potion.SoftHealPotion;
import src.game.core.item.weapon.DuskBlade;
import src.game.core.item.weapon.Sword;
import src.game.core.place.*;
import src.game.core.quest.*;

import src.game.exception.GameException;
import src.game.exception.InvalidArgumentException;
import src.game.exception.InvalidCommandException;
import src.game.exception.InvalidUIModeException;
import src.game.ui.game.GameUI;

/**
 * La classe <b>Game</b> représente une instance d'un jeu.<br>
 * Il est possible de lancer le jeu avec la commande <b>run()</b>.<br>
 * Une fois je jeu lancé, il est possible d'arrêter le jeu avec un appel à <b>quit()</b>.
 * Les fonctions {@link #go(String) go}, {@link #look(String) look}, 
 * {@link #take(String) take} et {@link #use(String) use} 
 * permettent d'interargir avec le jeu.
 * 
 * @author alexandre
 * @version 0.1
 */
public class Game {

	private GameUI ui;
	
	private boolean isRunning;
	private boolean quitRequested;
	
	private Hero player; 
	private boolean playerTurn;
	private List<Quest> quests;	
	
	public Game()
	{
		this.ui = null;
		this.isRunning = false;
		this.quitRequested = false;
	}
	
/*------------------------------------------------------------------------*
 *                           [GETTERS]                                    *
 *------------------------------------------------------------------------*/
	
	/**
	 * Retourne le statut du jeu.<br>
	 * <b>true</b> : Le jeu est en cours d'execution.<br>
	 * <b>false</b> : Le jeu n'est pas en cours d'execution.
	 * 
	 * @return Le statut du jeu
	 */
	public boolean isRunning() {
		return this.isRunning;
	}
	
/*------------------------------------------------------------------------*
 *                          [MODIFIERS]                                   *
 *------------------------------------------------------------------------*/
	/**
	 * Lance le jeu.<br>
	 * Si le jeu est déja lancé, cette fonction n'effectue rien.<br>
	 * Cette fonction ne retourne que quand le jeu s'arrête, par un appel à {@link#quit()}.
	 * @throws InvalidUIModeException Si la création de l'interface a échoué
	 */
	public void run() throws InvalidUIModeException {
		
		if(this.isRunning) {
			return;
		}
		
		this.isRunning = true;

		this.setup();
		while(!this.quitRequested && !this.quests.isEmpty() && !this.player.isDead()) {	
			this.loop();
		}
		
		this.isRunning = false;
		this.ui.display("Vous avez quitté le jeu");
	}
	
	
	/**
	 * Initialise le jeu.<br>
	 * Cette fonction est appelé lors d'un appel à {@link#run()}.
	 * @throws InvalidUIModeException Si la création de l'interface a échoué
	 */
	private void setup() throws InvalidUIModeException {
		this.ui = GameUI.create(this);
		
		this.quitRequested = false;		
		this.initGame();
	}
	
	
	/**
	 * La boucle principale du jeu.<br>
	 * Cette fonction est lancée en boucle par la fonction {@link#run()} tant que
	 * le jeu est en cours d'execution.
	 */
	private void loop() {
		this.updateQuests();
		
		if(!this.quests.isEmpty()) {
			this.playerAction();
		}
		    // hero may die here

	}
	
	private void initGame() {
	    this.quests = new ArrayList<Quest>();
	    createAssets();
	}
	
	private void createAssets() {
		final String KINGDOM_NAME = "Northumbria";
		final String ENEMY_NAME = "Ysdra";
		
	    final Item OBJECTIVE_ITEM = new DuskBlade();
	    

	    Place throneRoom = new Place("Throne room", "A huge place");
	    Place village = new Place(KINGDOM_NAME + " village", "The center of " + KINGDOM_NAME + " activities. It is always an active place.");
	    Place river = new Place(KINGDOM_NAME + " west river", "A magnificent river. The river is to large to be crossed.");
	    Place forest = new Place(KINGDOM_NAME + " east forest", "This forest seems unsafe.");
	    Place cave = new Cave("Cave", "Nothing special here.");
	    Place plain = new Place("Endless plains", "Nothing special here.");
	    Place mountain = new Place("Montains", "Nothing special here.");
	    Place dragonsLair = new Place("Dragon's Lair", "Nothing special here.");
	    
	    
	    // Throne room
	    this.player = new Hero(null);
	    TalkingCharacter king = new TalkingCharacter("King of " + KINGDOM_NAME, "The King of " + KINGDOM_NAME + ". despite this old age, he is still a respected king.", null, null);
	    LockableExit throneToVillage = new LockableExit("Main door", village);
	    
	    throneRoom.addExit(throneToVillage);
	    throneRoom.addCharacter(king);
	    throneRoom.addCharacter(this.player);
	    throneRoom.addItem(new SoftHealPotion());
	    
	    // Village
	    village.addExit(new Exit("Top of the hill", throneRoom));
	    village.addExit(new Exit("West Border", river));
	    village.addExit(new Exit("East Border", forest));
	    village.addExit(new Exit("South Border", plain));
	    TalkingCharacter ringMan = new TalkingCharacter("Jean", "He seems sad.", "Hey you! My wife lost her ring in the river. If you find it, can you bring it to me ?\n", null);
	    village.addCharacter(ringMan);
	    
	    // River
	    river.addExit(new Exit("East", village));
	    Item ring = new Item("Gold ring", "A prety nice ring!", 0);
	    river.addItem(ring);

	    // Forest
	    forest.addExit(new Exit("West", village));
	    forest.addExit(new Exit("Cave entrance", cave));
	    
	    // Cave
	    cave.addExit(new Exit("Cave exit", forest));

	    // Plain
	    plain.addExit(new Exit("North", village));
	    plain.addExit(new Exit("Rocky road", mountain));
	    
	    // Mountain
	    mountain.addExit(new Exit("Bottom of the montain", plain));
	    mountain.addExit(new Exit("Entrance of the Dragon's Lair", dragonsLair));
	    
	    // Dragon's lair
	    dragonsLair.addExit(new Exit("Magic teleport", throneRoom));
	    dragonsLair.addItem(OBJECTIVE_ITEM);
	    
	    // Quests
	    IntroductionQuest intro = new IntroductionQuest("Introduction", this.player, king, ENEMY_NAME, throneToVillage, new Sword(), OBJECTIVE_ITEM.getName(), KINGDOM_NAME, this.ui);
	    this.quests.add(intro);
	    intro.start();
	    
	    MainQuest mainQuest = new MainQuest("Save " + KINGDOM_NAME, OBJECTIVE_ITEM, this.ui);
	    this.quests.add(mainQuest);	  
	    mainQuest.start();
	    
	    RingQuest ringQuest = new RingQuest("A bad day", "Find " + ringMan.getName() + "'s ring in the river", this.player, ringMan, ring, this.ui);
	    this.quests.add(ringQuest);
	}
	
	
	private void updateQuests() {
	    List<Quest> toRemove = new ArrayList<>();

		for(Quest q : this.quests) {
			q.update();
			if(q.isComplete()) {
				toRemove.add(q);
		    }
		}
		
		for(Quest q : toRemove) {
			this.quests.remove(q);
	    }
	}
	
	public boolean talk(String cName, List<Object> argList) {
	    for(GCharacter c : this.player.getPlace().getCharacters()) {
	        if(c.getName().toUpperCase().equals(cName.toUpperCase()) && c instanceof Talkative) {
	            this.ui.displaySentence((Talkative) c); 
	            argList.add(c);
	            return true;
	        }
	    }
	    
	    this.ui.display("Failed to talk to \"" + cName + "\"!\n");
	    return false;
	}
	
	
	
	
	public Object searchCurrentPlaceObjectByName(String name) {
		Object target = null;
		
		// Search items, characters, exits in place
		target = (target == null) ? this.player.getPlace().getItem(name) : target ;
    	target = (target == null) ? this.player.getPlace().getCharacter(name) : target;
    	target = (target == null) ? this.player.getPlace().getExit(name) : target;
    	
    	// Search player bag
    	target = (target == null) ? this.player.getItem(name) : target;

    	return target;
	}
	
	
	
	public void playerAction() {
	    Command cmd = null;
	    ArrayList<String> args = new ArrayList<>();
	    this.playerTurn = true;
	    
	    while(this.playerTurn == true) {
	        this.playerTurn = false;
	        
	        do{
	            args.clear();
	            
                this.ui.display("\nPLAYER ACTION : ");
    
    	        try {
    	            cmd = this.ui.readUserCommand(args);
    	            
    	            if(!cmd.checkArgCount(args.size())) {
    	                throw new InvalidArgumentException(cmd, "Bad argument count!");
    	            }
    	            
    	        }catch(GameException e){
    	            this.ui.display(e.getMessage() + "\n");
    	            cmd = null;
    	        }
	        }while(cmd == null);

	        
	        // If failed to process the command, it's still the player turn
	        List<Object> argList = new ArrayList<Object>();
	        if(!processCommand(cmd, args, argList)) {
	            this.playerTurn = true;
	        }else {
	        	// Action success
	        	for(Quest q : this.quests) {
	        		q.onUserAction(cmd,argList);
	        	}
	        }
	    }
	}
	
	
	
	public boolean processCommand(Command cmd, List<String> args, List<Object> argList) {
	    String arg0 = (args.size() >= 1) ? args.get(0) : null;
        String arg1 = (args.size() >= 2) ? args.get(1) : null;

	    boolean result = true;
	    
        switch(cmd) 
        {
        case GO :
            result = this.go(arg0, argList);
            break;
        case HELP :
            result = this.help(arg0);
            this.playerTurn = true;
            break;
        case TAKE :
            result = this.take(arg0, argList);
            break;
        case LOOK :
            result = this.look(arg0, argList);
            this.playerTurn = true;
            break;
        case QUIT :
            this.quit();
            break;
        case USE :
            result = this.use(arg0, arg1, argList);
            break;
        case TALK :
            result = this.talk(arg0, argList);
            break;
        case SEARCH:
            result = this.search(arg0, argList);
            this.playerTurn = true;
            break;
        case QUEST :
        	result = this.quests();
        	this.playerTurn = true;
            break;
        }
        
	    return result;
	}
	
/*------------------------------------------------------------------------*
 *                      [ACTION UTILISATEUR]                              *
 *------------------------------------------------------------------------*/
	
	/**
	 * Permet de déplacer le personnage dans un nouveau lieu. Ce lieu doit être eccessible depuis
	 * la position actuelle du joueur.
	 * 
	 * @param place Nom du lieu ou le joueur doit se déplacer.
	 * @param argList 
	 * @return 
	 * @throws InvalidArgumentException si place est null ou n'est pas un nom de lieu valide.
	 */
	public boolean go(String place, List<Object> argList) {
		Exit exit = player.getPlace().getExit(place);
		argList.add(exit);
		
		if(exit == null) {
		    this.ui.display("Failed find the place \"" + place + "\" are you lost?\n");
		    return false;
		}
		
		if(!exit.canCross()) {
		    this.ui.display("Failed to walk to \"" + place + "\", the exit \"" + exit.getName() + "\" cannot be crossed!\n");
	        return false;
		}
		
        player.setPlace(exit.getPlace());
        this.ui.display("You successfuly walked to \"" + place + "\"!\n");
		return true;	
	}
	
	
	/**
	 * [TODO]
	 * Permet d'afficher les objets et les sorties présentes dans le lieu actuel du joueur.<br>
	 * Si item n'est pas null
	 * @param argList 
	 * 
	 * @param item Nom du lieu ou le joueur doit se déplacer.
	 * @throws InvalidArgumentException si place n'est pas un nom de lieu valide.
	 */
	public boolean look(String name, List<Object> argList) {
	 	Lookeable toLook = null;
	 	
		if(name != null) {
			Object target = null;

	    	target = searchCurrentPlaceObjectByName(name);
	    	argList.add(target);
	    	
	    	if(target == null) {
	    		this.ui.display("Failed to look \"" + name + "\" : Not found!\n");
	    		return false;
	    	}
	    	
	    	try{
		    	toLook = (Lookeable) target;
	    	}catch(ClassCastException e) {
	    		this.ui.display("Failed to look \"" + name + "\" : Not lookeable!\n");
	    		return false;
	    	}
	    	
		    			
		}else {
			toLook = this.player.getPlace();
		}
		 
    	this.ui.display(toLook.getDescription() + "\n");
    	return true;
	}
	

	/**
	 * Permet de prendre un objet dans le lieu ou se trouve le joueur et de le mettre dans le sac du joueur.
	 */
	public boolean take(String itemName, List<Object> argList) {
	    Item item = player.getPlace().getItem(itemName);
	    argList.add(item);
	    
	    boolean addSuccess = true;
	    
	    if(item == null) {
	        this.ui.display("Failed to take \"" + itemName + "\" : Item not found!\n");
	        addSuccess = false;
	    }else {
	        if(!player.addItem(item)) {
	            this.ui.display("Failed to take \"" + itemName + "\" : Bag full!\n");
	            addSuccess = false;
	        }else {
	            this.ui.display("\"" + itemName + "\" : Successfully added to bag!\n");
	        }
	    }
	    
	    return addSuccess;  
	}
	
	
	/**
	 * Quitte le jeu.
	 */
	public void quit() {
		this.quitRequested = true;
	}
		
		
	public boolean search(String arg, List<Object> argList) {	    
	    if(arg == null) {
	    	argList.add(player.getPlace());
	        this.ui.display(player.getPlace().toString());
	    }
	    else{
	        GCharacter c = player.getPlace().getCharacter(arg);
	    	argList.add(c);

	        if(c != null) {
	            this.ui.display(c.toString());
	        }else {
	            this.ui.display("Failed to search, invalid argument\n");
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	public boolean help(String arg0) {
		if(arg0 != null) {
	        arg0 = arg0.toUpperCase();
	        Command cmdHelp;
	            
	        try {
	            cmdHelp = Command.getFromString(arg0);
	        }catch(InvalidCommandException e) {
	            this.ui.display(e.getMessage() + "\n");
	            return false;
	        }
	            
	        this.ui.display(cmdHelp.help() + "\n");
	    }else {
	        this.ui.display("Available commands are :\n");
	        for(Command cmd : Command.values()) {
	            this.ui.display(" - " + cmd + "\n");
	        }
	    }
	        
	    this.ui.display("\n");	
	    return false;
	}
	
	public boolean use(String arg0, String arg1, List<Object> argList) {
	    Useable toUse = null;
	    try{
	    	Item item = this.player.getItem(arg0);
	    	if(item == null) {
	    		this.ui.display("Failed to use \"" + arg0 + "\" : Item not found!\n");
	    		return false;
	    	}
	    	
	    	toUse = (Useable) this.player.getItem(arg0);
	    }catch(ClassCastException e) {
	    	this.ui.display("Failed to use \"" + arg0 + "\" : Item not useable!\n");
	        return false;
	    }

	    
	    Object target = null;
	    
	    if(arg1 != null) {
	    	target = (target == null) ? this.player.getPlace().getItem(arg1) : target ;
	    	target = (target == null) ? this.player.getPlace().getCharacter(arg1) : target;
	    	target = (target == null) ? this.player.getItem(arg1) : target;
	    	target = (target == null) ? this.player.getPlace().getExit(arg1) : target;
	    	
	    	if(target == null) {
	    		this.ui.display("Failed to use \"" + arg0 + "\" on \"" + arg1 + "\" : Target nor found!\n");
	    		return false;
	    	}
	    }
	    
	    if(!toUse.use(target)) {
	    	if(target == null) {
	    		this.ui.display("Failed to use \"" + arg0 + "\"!\n");
	    	}else {
	    		this.ui.display("Failed to use \"" + arg0 + "\" on \"" + arg1 + "\" : Not compatible !\n");
	    	}
	    	return false;
	    }
	    
	    argList.add(toUse);
	    argList.add(target);
        this.ui.display("You successfully used \"" + arg0 + "\"\n");
	    return true;
	}
	
	public boolean quests() {
		for(Quest q : this.quests) {
			if(q.isStarted()) {
				this.ui.display("[" + q.getName() + "]-> " + q.getInfos() + "\n");
			}
		}
		return true;
	}	
}
