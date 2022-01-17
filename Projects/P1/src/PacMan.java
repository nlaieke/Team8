import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.lang.Math;

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
		for (Location location : new ArrayList<Location>(validMoves)) {
			HashSet<Map.Type> type = myMap.getLoc(location);
			// the location isnt holding a cookie or empty space, its not a valid move
			if(type.contains(Map.Type.PACMAN) && type.contains(Map.Type.COOKIE)){
				validMoves.remove(location);
			}
		}	
		return validMoves;
	}

	public boolean move() {
		ArrayList<Location> validMoves = get_valid_moves();
		if (validMoves.isEmpty()) {
			return false;
		} else {
			this.myLoc = validMoves.get((int)(Math.random()*validMoves.size()));
			this.shift = this.myLoc.unshift(this.myLoc);
			this.myMap.move(this.myName, this.myLoc, Map.Pacman);
			return true;
		}
	}

	public boolean is_ghost_in_range() { 
		ArrayList<Location> ghostLocations = new ArrayList<Location>();
		ghostLocations.add(new Location(this.myLoc.x + 1, this.myLoc.y + 0));
		ghostLocations.add(new Location(this.myLoc.x + 0, this.myLoc.y + 1));
		ghostLocations.add(new Location(this.myLoc.x + 0, this.myLoc.y - 1));
		ghostLocations.add(new Location(this.myLoc.x - 1, this.myLoc.y - 1));
		ghostLocations.add(new Location(this.myLoc.x - 1, this.myLoc.y + 0));
		
		
		for(Location location: ghostLocations){
			HashSet<Map.Type> ghostCheck = myMap.getLoc(location);
			if(ghostCheck.contains(Map.Type.GHOST)){
				return true;
			}
	}
		return false;
	}
	// consumes cookie that pacman may be on top of
	public JComponent consume() { 
 		// check map for cookie at current location
		if (myMap.getLoc(this.myLoc).contains(Map.Type.COOKIE) == false) {
			// consume cookie
			int x = this.myLoc.x;
			int y = this.myLoc.y;
			String cookieName = "tok_x" + x + "_y" + y;
			return myMap.eatCookie(cookieName);
		}

		// no cookie
		return null;
	}
}
