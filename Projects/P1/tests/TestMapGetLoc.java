import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

public class TestMapGetLoc extends TestCase {

	public void testMapGetLoc() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		HashSet<Map.Type> emptySet = new HashSet<Map.Type>();
		emptySet.add(Map.Type.EMPTY);
		frame.addPacMan(new Location(2,1));
		frame.addGhost(new Location(1,1), "Blinky", Color.red);
		
		assertTrue(m.getLoc(new Location(2,1)).contains(Map.Type.PACMAN)); // tests that pacman is found at it's location
		assertTrue(m.getLoc(new Location(1,1)).contains(Map.Type.GHOST)); // tests that the ghost is found at it's location

		assertFalse(m.getLoc(new Location(0,0)).contains(Map.Type.EMPTY)); // tests that empty is not in a location w/ objects
		assertFalse(m.getLoc(new Location(2,1)).contains(Map.Type.EMPTY)); // tests that empty is not in a location w/ objects
		assertFalse(m.getLoc(new Location(1,1)).contains(Map.Type.EMPTY)); // tests that empty is not in a location w/ objects

		assertTrue(m.getLoc(new Location(-1, -1)).equals(emptySet)); // tests that out of range locations are empty
		assertTrue(m.getLoc(new Location(40, 40)).equals(emptySet)); // tests that out of range locations are empty
	}
}
