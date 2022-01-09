import junit.framework.*;
import java.awt.Color;
import java.io.*;
import javax.swing.JComponent;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		JComponent eatenCookie = pacman.consume();

		// eatenCookie should return cookie when cookie is present
		assertTrue(eatenCookie != null);
	}

	public void testConsumeOnEmptySpot() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		JComponent eatenCookie = pacman.consume();

		// eat cookie that is present. after which cookie should disapear
		assertTrue(eatenCookie != null);

		JComponent secondConsume = pacman.consume();

		// after cookie is empty, if you were to call consume() on empty spot, should return null 
		assertTrue(secondConsume == null);
	}
}
