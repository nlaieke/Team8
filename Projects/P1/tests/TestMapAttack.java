import java.awt.Color;
import junit.framework.*;
import java.io.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException {
		//ghost is in range and attacks, checks to see if gameover was returned
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(8, 7), "clyde", Color.red);
		Map map = frame.getMap();		//Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 7));
		assertTrue(map.attack("clyde") == false);
		
		//ghost is out of range and cannot attack so game continues
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(10, 7), "clyde", Color.red);
		Map map = frame.getMap();		//Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 7));
		assertTrue(map.attack("clyde") == true);
	}
}