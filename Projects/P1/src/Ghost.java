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
		return null;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
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
