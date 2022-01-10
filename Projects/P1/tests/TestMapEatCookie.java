import junit.framework.*;
import java.awt.Color;
import java.io.*;
import javax.swing.JComponent;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Map map = frame.getMap();
		frame.addPacMan(new Location(1,1));
		String cookieName = "tok_x" + 1 + "_y" + 1;

		// eat cookie at location 1,1
		JComponent cookieEaten = map.eatCookie(cookieName);

		// return result is not empty. this mean's cookie was returned and eaten
		assertTrue(cookieEaten != null); 

		// after, spot should no longer contain cookie after being eaten
		assertFalse(map.getLoc(new Location(1,1)).contains(Map.Type.COOKIE));
	}


}
