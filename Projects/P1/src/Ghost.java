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
		ArrayList<Location> pacmanLocations = new ArrayList<Location>();
	
		pacmanLocations.add(new Location(myLoc.x + 1, myLoc.y + 0));
		pacmanLocations.add(new Location(myLoc.x + 0, myLoc.y + 1));
		pacmanLocations.add(new Location(myLoc.x + 0, myLoc.y - 1));
		pacmanLocations.add(new Location(myLoc.x - 1, myLoc.y + 0));
		
		
		for(Location location: pacmanLocations){
			HashSet<Map.Type> pacmanCheck = myMap.getLoc(location);
			if(pacmanCheck.equals(Map.Type.PACMAN)){
				return true;
			}
	}
		return false;
	}


	public boolean attack() {
		return false;
	}
}
