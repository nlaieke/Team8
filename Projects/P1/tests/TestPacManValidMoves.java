import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMovesEmpty() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		validMoves.add(new Location(10,11));
		PacMan pacman = frame.addPacMan(new Location (9,11));
		System.out.print(validMoves.equals(pacman.get_valid_moves()));
		for(int i= 0; i< validMoves.size(); i++){
			assertTrue(validMoves.contains(pacman.get_valid_moves().get(i))); // equal ArrayLists.  
		}		
	}
	public void testPacManValidMovesGhostsAndPacMan() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		validMoves.add(new Location(9,12));
		PacMan pacman = frame.addPacMan(new Location (9,11));
		Ghost testGhost = frame.addGhost(new Location(10,11), "blinky", Color.red);


		System.out.print(validMoves.equals(pacman.get_valid_moves()));
		for(int i= 0; i< validMoves.size(); i++){
			assertTrue(validMoves.contains(pacman.get_valid_moves().get(i))); // equal ArrayLists.  
		}		
	}
}
