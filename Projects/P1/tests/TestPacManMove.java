import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacmanMove1() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		PacMan pacman = new PacMan("pacman", new Location(1,1), m);
		frame.addPacMan(new Location(1,1));

		for(Location location : pacman.get_valid_moves()) {
			System.out.println(location.x + "," + location.y);
		}
		
		assertTrue(pacman.move()); // ensures ghost can move when it has empty spaces
	}

	public void testPacmanMove2() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		PacMan pacman = new PacMan("pacman", new Location(-1,-1), m);
		for(Location location : pacman.get_valid_moves()) {
			System.out.println(location.x + "," + location.y);
		}
		
		assertFalse(pacman.move()); // ensures ghost cannot move when out of bounds of the maze
	}
	
	public void testPacmanMove3() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map m = frame.getMap();

		PacMan pacman = new PacMan("pacman", new Location(31,31), m);
		for(Location location : pacman.get_valid_moves()) {
			System.out.println(location.x + "," + location.y);
		}
		
		assertFalse(pacman.move()); // ensures ghost cannot move when out of bounds of the maze
	}
}