import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	public int bX = Turret.tX - 5;
	public int bY = Turret.tY;
	boolean active = false;

	Bullet() {

	}

	public void draw(Graphics g) {
		if (active) {
			g.setColor(Color.RED);
			g.fillOval(bX, bY, 10, 10);
			update();
		}

	}

	public void update() {
		if (active) {
			bX = bX - 5;
			if (bX <= 0 || bY <= 0) {
				active = false;
			}
		}

	}

	public void activate() {
		active = true;
		bX = Turret.tX - 5;
		bY = Turret.tY;
	}

}
