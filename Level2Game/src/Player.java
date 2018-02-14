import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Player extends JPanel {
	// Image characterOneImage;
	public int x;
	public int y;
	public int c2X;
	public int c2Y;
	public int b2X = x;
	public int b2Y = y;
	public int width = 300;
	public int height = 150;
	public int health = 195;
	public int ammo = 5;
	public static ImageObserver io;
	boolean drawLeft = false;

	List<PlayerBullet> bullets;

	// = new ImageIcon("Untitled-1.gif");
	public Image i = Toolkit.getDefaultToolkit().createImage("Untitled-1.gif");

	public Player(String img, int x, int y, int width, int height, int ammo) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ammo = ammo;

		bullets = new ArrayList<>();
		// characterOneImage = Toolkit.getDefaultToolkit().createImage("test.png");
		i = Toolkit.getDefaultToolkit().createImage(img);
	}

	public void setDrawLeft(boolean drawLeft) {
		this.drawLeft = drawLeft;
	}

	public void draw(Graphics2D g) {

		if (drawLeft) {
			g.drawImage(i, x + width, y, -width, height, io);
		} else {
			g.drawImage(i, x, y, width, height, io);
		}

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);

		}

	}

	public void shoot() {

		PlayerBullet pb = new PlayerBullet(this);
		bullets.add(pb);
	}

	public void removeBullet(PlayerBullet playerBullet) {
		bullets.remove(playerBullet);
	}

}
