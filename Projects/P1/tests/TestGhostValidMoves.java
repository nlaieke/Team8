import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import com.sun.jdi.Location;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		validMoves.add(new Location(10,11));
		Ghost ghost = frame.addGhost(new Location(9,11), "clyde", Color.orange);
		System.out.print(validMoves.equals(ghost.get_valid_moves()));
		assertTrue(validMoves.equals(ghost.get_valid_moves())); // equal ArrayLists.  
		
	}
}
