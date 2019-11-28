package src.game.core;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

	public  class Place implements ItemContainer {
	
	private  final String NAME;
	private  final String description;
		
	private ArrayList<Item> items =new ArrayList<Item>();
	private ArrayList<Character> content =new ArrayList<Character>();
		
    public Map<String,Exit> v = new HashMap<String, Exit>();
	

    public Place(String n) {
    	this.NAME=n;
    }
    
    public String getDescription() {
		return "Place description";}
	//
    public void addItem(Item item) {
		this.items.add(item);
	}
		

	// 
    public void removeItem(Item item) {
		ArrayList<Item> contents;
		contents.remove(item);
		
	}
// 
	public String getName() {
		return NAME;
	}
	
	

	public Item getItem(String name) throws ItemNotFoundException {
		for(Item item : this.items) {
			si item.getName() est égal à name
			alors return item
		}
		
		ici lancer une exception
	}

	@Override
	public Item[] getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean find(Item item) {
		// TODO Auto-generated method stub
		return false;
	}
	

	