import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMovesEmpty() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		validMoves.add(new Location(10,11));
		Ghost ghost = frame.addGhost(new Location(9,11), "clyde", Color.orange);
		System.out.print(validMoves.equals(ghost.get_valid_moves()));
		assertTrue(validMoves.equals(ghost.get_valid_moves())); // equal ArrayLists.  
		
	}
	public void testPacManValidMovesGhostsAndPacMan() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		validMoves.add(new Location(10,11));
		PacMan pacman = frame.addPacMan(new Location (9,11));
		Ghost testGhost = frame.addGhost(new Location(10,11), "blinky", Color.red);


		System.out.print(validMoves.equals(ghost.get_valid_moves()));
		assertTrue(validMoves.equals(ghost.get_valid_moves())); // equal ArrayLists.  
		
	}
}
