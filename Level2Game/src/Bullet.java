import java.awt.Graphics;

public class Bullet {
	int bX = Turret.tX - 5;
	int bY = Turret.tY;

	Bullet() {
		this.bX = bX;
		this.bY = bY;
	}

	public void draw(Graphics g) {
		g.drawOval(bX, bY, 30, 30);
	}

	public void update() {
		if (PlayerOne.x < bX) {
			bX = bX - 10;
		} else if (PlayerOne.x > bX) {
			bX = bX + 10;
		}
		if (PlayerOne.y < bY) {
			bY = bY - 10;

		}
		if (PlayerOne.y > bY) {
			bY = bY + 10;
		}
	}
}
