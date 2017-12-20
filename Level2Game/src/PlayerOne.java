import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PlayerOne extends JPanel {
	Image characterOneImage;
	int x;
	int y;
	ImageObserver io;
	// ImageIcon characterOneImage = new ImageIcon("Untitled-1.gif");

	PlayerOne(int x, int y) {
		this.x = x;
		this.y = y;
		// characterOneImage = Toolkit.getDefaultToolkit().createImage("test.png");
		try {
			characterOneImage = ImageIO.read(new File("Untitled-1.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {
		g.drawImage(characterOneImage, x, y, this);

	}

}
