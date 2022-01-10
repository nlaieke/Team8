import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(myLoc.x + 1, myLoc.y + 0));
		validMoves.add(new Location(myLoc.x - 1, myLoc.y + 0));
		validMoves.add(new Location(myLoc.x + 0, myLoc.y + 1));
		validMoves.add(new Location(myLoc.x + 0, myLoc.y - 1));
<<<<<<< HEAD

		for (Location location : validMoves) {
			HashSet<Map.Type> type = myMap.getLoc(location);
			// the location isnt holding a cookie or empty space, its not a valid move
			if(type.contains(Map.Type.EMPTY) == false && type.contains(Map.Type.COOKIE) == false){
=======
		for (Location location : validMoves) {
			HashSet<Map.Type> type = myMap.getLoc(location);
			if (type.contains(Map.Type.WALL) || type.contains(Map.Type.GHOST)){
>>>>>>> pacman-get_valid_moves
				validMoves.remove(location);
			}
		}	
		return validMoves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
