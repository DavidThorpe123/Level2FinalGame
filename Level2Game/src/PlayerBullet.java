import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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
		System.out.println("Player: X" + p.x);
		System.out.println("PLayer: Y" + p.y);
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
			System.exit(0);
		}
		if (hit(this, gp.characterTwo)) {

			gp.characterTwo.health = gp.characterTwo.health - 10;

		}
	}

	boolean hit(PlayerBullet pb, Player p) {
		return hit(p.x, p.y, p.width, p.height, pbX, pbY, 10, 10);
	}

	private boolean hit(int x, int y, int width, int height, int pbX2, int pbY2, int i, int j) {
		System.out
				.println(new Rectangle2D.Double(x, y, width, height) + " " + new Rectangle2D.Double(pbX2, pbY2, i, j));
		return new Rectangle2D.Double(x, y, width, height).contains(new Rectangle2D.Double(pbX2, pbY2, i, j));

	}

}
