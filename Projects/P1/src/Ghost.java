import java.util.HashSet;
import java.util.ArrayList;
import java.lang.Math;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(myLoc.x + 1, myLoc.y + 1));
		validMoves.add(new Location(myLoc.x - 1, myLoc.y + -1));
		validMoves.add(new Location(myLoc.x + 1, myLoc.y + 1));
		validMoves.add(new Location(myLoc.x + -1, myLoc.y - 1));

		for (Location location : new ArrayList<Location>(validMoves)) {
			HashSet<Map.Type> type = myMap.getLoc(location);
			if (type.contains(Map.Type.WALL)){
				validMoves.remove(location);
			}
		}	
		return validMoves;	
  }

	public boolean move() {
		ArrayList<Location> validMoves = get_valid_moves();
		if(validMoves.isEmpty()) {
			return false;
		} else {
			this.myLoc = validMoves.get((int)(Math.random()*validMoves.size()));
			this.shift = this.myLoc.unshift(this.myLoc);
			this.myMap.move(this.myName, this.myLoc, Map.Type.GHOST);
			return true;
		}
	}

	public boolean is_pacman_in_range() { 
		ArrayList<Location> pacmanLocations = new ArrayList<Location>();
	
		pacmanLocations.add(new Location(myLoc.x + 1, myLoc.y + 0));
		pacmanLocations.add(new Location(myLoc.x + 0, myLoc.y + 1));
		pacmanLocations.add(new Location(myLoc.x + 0, myLoc.y - 1));
		pacmanLocations.add(new Location(myLoc.x - 1, myLoc.y - 1));
		pacmanLocations.add(new Location(myLoc.x - 1, myLoc.y + 0));
		
		
		for(Location location: pacmanLocations){
			HashSet<Map.Type> pacmanCheck = myMap.getLoc(location);
			if(pacmanCheck.contains(Map.Type.PACMAN)){
				return true;
			}
	}
		return false;
	}


	public boolean attack() {
		// check if in range to attack
		if (is_pacman_in_range()) {
			// attempt ghost attack using the map class method
			if (myMap.attack(myName)) {
				// success
				return true;
			}
		}

		// failure
		return false;
	}
}
