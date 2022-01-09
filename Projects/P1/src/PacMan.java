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
		return null;	
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	// consumes cookie that pacman may be on top of
	public JComponent consume() { 
		// check map for cookie at current location
		if (myMap.getLoc(this.myLoc).contains(Map.Type.COOKIE) == true) {
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
