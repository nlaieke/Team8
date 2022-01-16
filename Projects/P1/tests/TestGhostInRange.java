import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(8, 7), "clyde", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 7));
		assertTrue(pacman.is_ghost_in_range());
	
		
	}
	
	public void testGhostInRange2() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(8, 8), "clyde", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 7));
		//Should fail
		assertTrue(pacman.is_ghost_in_range() == false);
		
	}
}

