import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	// ghost attack() succeeds only when pacman is in range, and myMap.attack() returns true
	public void testAttackSuccess() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(8, 7), "clyde", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 7));
		assertTrue(ghost.is_pacman_in_range());
		assertTrue(frame.getMap().attack("clyde"));
		assertTrue(ghost.attack());
	}
	
	// ghost attack fails if  pacman is not in range
	public void testAttackFailure() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(8, 8), "clyde", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 4));
		//Should fail
		assertTrue(ghost.is_pacman_in_range() == false);
		assertTrue(ghost.attack() == false);
	}
}
