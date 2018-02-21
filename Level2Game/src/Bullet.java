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
			g.fillOval(bX, bY, 30, 30);
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

	public void deactivate() {
		active = false;
	}

	public boolean intersect(int x1, int y1, int x2, int y2, int s1, int s2) {
		int dx = (x1 - x2) * (x1 - x2);
		int dy = (y1 - y2) * (y1 - y2);
		int ds = (s1 - s2) * (s1 - s2);
		return dx + dy < ds;

	}

}
