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
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		return null;
	}
}
