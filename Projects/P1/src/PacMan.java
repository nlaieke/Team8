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
		validMoves.add(new Location(myLoc.x + 1, MyLoc.y + 0));
		validMoves.add(new Location(myLoc.x - 1, MyLoc.y + 0));
		validMoves.add(new Location(myLoc.x + 0, MyLoc.y + 1));
		validMoves.add(new Location(myLoc.x + 0, MyLoc.y - 1));
		for (Location location : validMoves) {
			HashSet<Map.Type> type = myMap.getLoc(Location);
			if (type.contains(Map.Type.Wall) || type.contains(Map.Type.GHOST)){
				validMoves.remove(location);
			}
		}	
		return validMoves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		ArrayList<Location> ghostLocations = new ArrayList<Location>();
		ghostLocations.add(new Location(this.myLoc.x + 1, this.myLoc.y + 0));
		ghostLocations.add(new Location(this.myLoc.x + 0, this.myLoc.y + 1));
		ghostLocations.add(new Location(this.myLoc.x + 0, this.myLoc.y - 1));
		ghostLocations.add(new Location(this.myLoc.x - 1, this.myLoc.y + 0));
		
		
		for(Location location: ghostLocations){
			HashSet<Map.Type> ghostCheck = myMap.getLoc(location);
			if(ghostCheck.contains(Map.Type.GHOST)){
				return true;
			}
	}
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
