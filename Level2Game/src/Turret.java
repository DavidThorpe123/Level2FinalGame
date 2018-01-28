import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class Turret {
	public static int tX = 50;
	public static int tY = 50;
	public static int tHP = 100;
	public static Image i = Toolkit.getDefaultToolkit().createImage("Turret.png");
	ImageObserver io;

	Turret(int tX, int tY, int tHP) {
		this.tX = tX;
		this.tY = tY;
		this.tHP = tHP;

	}

	public void draw(Graphics2D g) {

		g.drawImage(i, tX, tY, 100, 100, io);
	}

}
