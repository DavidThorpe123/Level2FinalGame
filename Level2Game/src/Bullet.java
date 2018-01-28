import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	public static int bX = Turret.tX - 5;
	public static int bY = Turret.tY;

	Bullet() {
		this.bX = bX;
		this.bY = bY;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(bX, bY, 10, 10);
	}

	public void update() {
		bX = bX - 5;
		bY = bY - 5;
		if (bX - 30 / 2 <= 0) {
			bX = -bX;
		}
		if (bX + 30 / 2 >= 1000) {
			bX = -bX;
		}
		if (bY - 30 / 2 <= 0) {
			bY = -bY;
		}
		if (bY + 30 / 2 >= 1000) {
			bY = -bY;
		}

	}
}
