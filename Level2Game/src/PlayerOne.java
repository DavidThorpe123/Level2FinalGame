import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class PlayerOne extends JPanel {
	// Image characterOneImage;
	public static int x;
	public static int y;
	public static ImageObserver io;
	// = new ImageIcon("Untitled-1.gif");
	public static Image i = Toolkit.getDefaultToolkit().createImage("Untitled-1.gif");

	PlayerOne(int x, int y) {
		this.x = x;
		this.y = y;
		// characterOneImage = Toolkit.getDefaultToolkit().createImage("test.png");

	}

	public static void draw(Graphics2D g) {
		// g.drawImage(i, x, y, this);
		g.drawImage(i, x, y, 300, 200, io);
	}

	public boolean intersect(int x1, int y1, int x2, int y2, int s1, int s2) {
		int dx = (x1 - x2) * (x1 - x2);
		int dy = (y1 - y2) * (y1 - y2);
		int ds = (s1 - s2) * (s1 - s2);
		return dx + dy < ds;

	}

}
