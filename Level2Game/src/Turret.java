import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Turret {
	public static int tX = 50;
	public static int tY = 50;
	public static int tHP = 100;
	// public static Image i =
	// Toolkit.getDefaultToolkit().createImage("/Turret.png");
	public static Image i = null;
	ImageObserver io;
	Bullet b;

	Turret(int tX, int tY, int tHP) {
		try {
			i = ImageIO.read(Turret.class.getResource("Turret.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tX = tX;
		this.tY = tY;
		this.tHP = tHP;
		b = new Bullet();
	}

	public void draw(Graphics2D g) {
		g.drawImage(i, tX, tY, 100, 100, io);
		b.draw(g);
	}

	public void fire() {
		b.activate();
	}

}
