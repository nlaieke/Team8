import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove1() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		Ghost ghost = new Ghost("Blinky", new Location(1,1), m);
		frame.addGhost(new Location(1,1), "Blinky", Color.red);
		
		for(Location location : ghost.get_valid_moves()) {
			System.out.println(location.x + "," + location.y);
		}
		
		assertTrue(ghost.move()); // ensures ghost can move when it has empty spaces
	}

	public void testGhostMove2() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		Ghost ghost = new Ghost("Blinky", new Location(-1,-1), m);
		for(Location location : ghost.get_valid_moves()) {
			System.out.println(location.x + "," + location.y);
		}
		
		assertFalse(ghost.move()); // ensures ghost cannot move when out of bounds of the maze
	}
	
	public void testGhostMove3() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		Ghost ghost = new Ghost("Blinky", new Location(31,31), m);
		for(Location location : ghost.get_valid_moves()) {
			System.out.println(location.x + "," + location.y);
		}
		
		assertFalse(ghost.move()); // ensures ghost cannot move when out of bounds of the maze
	}
}
