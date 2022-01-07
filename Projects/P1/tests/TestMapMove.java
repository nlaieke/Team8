import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase{

	public void testMapMove() throws FileNotFoundException {
		noFrame frame = new noFrame();
		Map map = frame.getMap();
		PacMan pacman = frame.addPacMan(new Location(9,11) );
		Ghost ghost = frame.addGhost(new Location(10,11), "clyde", Color.orange);
		//testing pacman
		assertTrue(map.move("pacman", new Location (9,11), Map.Type.PACMAN)); // moving to same location
		assertTrue(map.move("pacman", new Location (9,12), Map.Type.PACMAN)); // moving 1 space
		assertTrue(map.move("pacman", new Location (2,4), Map.Type.PACMAN)); // moving across screen
		assertFalse(map.move("pacman", new Location (33,4), Map.Type.PACMAN)); // moving off screen



		//testing Ghost
		assertTrue(map.move("clyde", new Location (10,11), Map.Type.GHOST)); // moving to same location
		assertTrue(map.move("clyde", new Location (9,11), Map.Type.GHOST)); // moving 1 space
		assertTrue(map.move("clyde", new Location (2,4), Map.Type.GHOST)); // moving across screen
		assertFalse(map.move("pacman", new Location (31,4), Map.Type.PACMAN)); // moving off screen
	}
}
