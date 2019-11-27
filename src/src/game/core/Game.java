package src.game.core;

import src.game.exception.InvalidArgumentException;
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
	private boolean objectiveReached;
	
	private Personnage player; 
	
	
	public Game()
	{
		this.ui = null;
		this.isRunning = false;
		this.quitRequested = false;
		this.objectiveReached = false;
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
 *                      [ACTION UTILISATEUR]                              *
 *------------------------------------------------------------------------*/
	
	/**
	 * Permet de déplacer le personnage dans un nouveau lieu. Ce lieu doit être eccessible depuis
	 * la position actuelle du joueur.
	 * 
	 * @param place Nom du lieu ou le joueur doit se déplacer.
	 * @throws InvalidArgumentException si place est null ou n'est pas un nom de lieu valide.
	 */
	public void go(String place) throws InvalidArgumentException {
		Place playerPlace = player.getPlace();
		
		
		//player.move(place);
	}
	
	
	/**
	 * [TODO]
	 * Permet d'afficher les objets et les sorties présentes dans le lieu actuel du joueur.<br>
	 * Si item n'est pas null
	 * 
	 * @param item Nom du lieu ou le joueur doit se déplacer.
	 * @throws InvalidArgumentException si place n'est pas un nom de lieu valide.
	 */
	public void look(String itemName) {
		if(itemName == null) {
			ui.display(player.getPlace().getItem(itemName));
		}else {
			ui.display(player.getPlace());
		}
	}

	/**
	 * Permet de prendre un objet dans le lieu ou se trouve le joueur et de le mettre dans le sac du joueur.
	 * 
	 * @param item Le nom de l'objet à ajouter dans le sac.
	 * @throws Something si il n'y a pas assez de place dans le sac du joueur.
	 * @throws Something si item n'est pas un nom d'objet valide.
	 */
	public void take(String itemName) {
		player.addItem(player.getPlace().getItem(itemName));
	}
	
	
	/**
	 * Quitte le jeu.
	 */
	public void quit() {
		this.quitRequested = true;
	}
	
	public void use(String name) {
		
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
		while(!this.quitRequested && !this.objectiveReached) {	
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
		this.objectiveReached = false;
	}
	
	
	/**
	 * La boucle principale du jeu.<br>
	 * Cette fonction est lancée en boucle par la fonction {@link#run()} tant que
	 * le jeu est en cours d'execution.
	 */
	private void loop() {
		try {
			ui.readUserAction();
		}catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}
