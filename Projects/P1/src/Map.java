import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location
		if(loc.x <=30 && loc.y <=30){
			components.get(name).setLocation(loc.x,loc.y);
			locations.put(name, loc);
			if (!field.containsKey(loc)) {
				field.put(loc, new HashSet<Type>());
			}
			field.get(loc).add(type);
			return true;
			}
		else return false;	
		}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method		
		if (field.containsKey(loc)) {
			return field.get(loc);
		} else {
			return emptySet;
		}
	}
	

	public boolean attack(String Name) {
		Location ghostLocation = locations.get(Name);
		Location pacman = locations.get("pacman");
		if(ghostLocation.x == pacman.x && ghostLocation.y == pacman.y){
			gameOver = true;
		}
		else if(ghostLocation.x == pacman.x){
			if(ghostLocation.y == pacman.y +1){
				gameOver = true;
			}
			else if(ghostLocation.y == pacman.y -1){
				gameOver = true;
			}
			
		}
		else if(ghostLocation.y == pacman.y){
			if(ghostLocation.x == pacman.x +1){
				gameOver = true;
			}
			else if(ghostLocation.x == pacman.x -1){
				gameOver = true;
			}
				
		}
	
		return gameOver;
	}
	
	// eat cookie by updating locations, cookie components, field hash
	// parameter given will be the cookie's token name: example "tok_x1_y2"
	public JComponent eatCookie(String name) {
		// use cookie taken parameter to remove cookie from cookie components
		JComponent cookieComp = components.remove(name);

		if(cookieComp == null) {
			return null;
		}

		// get location of cookie using the cookie token parameter
		Location loc = locations.get(name);

		// clear that location on map's field hash
		field.get(loc).clear();

		//replace with pacman who just ate the cookie
		field.get(loc).add(Type.PACMAN);

		// remove cookie's location from map
		locations.remove(name);
		return cookieComp;
	}
}
