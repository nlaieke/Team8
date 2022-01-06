import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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
			Map.Map.Type type = myMap.getLoc(Location);
			if( type == Map.Type.Wall){
				validMoves.remove(location);
			}
		}	
		return validMoves;	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
