import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerBullet {

	public int pbX;
	public int pbY;
	boolean moveLeft;
	Player p;
	GamePanel gp;

	PlayerBullet(Player p) {
		gp = new GamePanel();
		this.p = p;
		pbX = p.x + 100;
		pbY = p.y + 50;
		moveLeft = p.drawLeft;
	}

	public void draw(Graphics2D g) {
		update();
		g.setColor(Color.RED);
		g.fillOval(pbX, pbY, 10, 10);

	}

	public void update() {
		System.out.println();
		if (moveLeft) {
			pbX = pbX - gp.speed;
		}
		if (!moveLeft) {
			pbX = pbX + gp.speed;
		}

		if (pbX >= 1000 || pbX <= 0) {
			p.removeBullet(this);
		}
		if (hit(this, gp.characterOne)) {

			gp.characterOne.health = gp.characterOne.health - 10;

		}
		if (hit(this, gp.characterTwo)) {

			gp.characterTwo.health = gp.characterTwo.health - 10;

		}
	}

	boolean hit(PlayerBullet pb, Player p) {
		return hit(pb.pbX, pb.pbY, 10, 10, p.x, p.y, p.width, p.height);
	}

	private boolean hit(int pbX2, int pbY2, int i, int j, int x, int y, int width, int height) {
		boolean inX = false;
		if (pbX2 > x && pbX2 < x + width) {
			inX = true;
		}
		if (pbX2 + i > x && pbX2 + i < x + width) {
			inX = true;
		}
		boolean inY = false;
		if (pbY2 > y && pbY2 < y + height) {
			inX = true;
		}
		if (pbY2 + j > y && pbY2 + j < y + height) {
			inX = true;
		}
		return inX && inY;
	}

}
