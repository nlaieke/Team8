import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import com.sun.jdi.Location;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMovesEmpty() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		validMoves.add(new Location(10,11));
		Ghost ghost = frame.addGhost(new Location(9,11), "clyde", Color.orange);
		System.out.print(validMoves.equals(ghost.get_valid_moves()));
		for(int i= 0; i< validMoves.size(); i++){
			assertTrue(validMoves.contains(ghost.get_valid_moves().get(i))); // equal ArrayLists.  
		}		
	}
	public void testGhostValidMovesGhostsAndPacMan() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		validMoves.add(new Location(10,11));
		Ghost ghost = frame.addGhost(new Location(9,11), "clyde", Color.orange);
		Ghost testGhost = frame.addGhost(new Location(9,11), "blinky", Color.red);

		PacMan pacman = frame.addPacMan(new Location (9,12));

		System.out.print(validMoves.equals(ghost.get_valid_moves()));
		for(int i= 0; i< validMoves.size(); i++){
			assertTrue(validMoves.contains(ghost.get_valid_moves().get(i))); // equal ArrayLists.  
		}		
	}
}
