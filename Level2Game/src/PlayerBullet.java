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
		gp = p.getGamePanel();
		this.p = p;
		pbX = p.getXPos() + 100;
		pbY = p.getYPos() + 50;
		moveLeft = p.drawLeft;
	}

	public void draw(Graphics2D g) {
		update();
		g.setColor(Color.RED);
		g.fillOval(pbX, pbY, 10, 10);

	}

	public void update() {
		System.out.println("Player: " + p.name);
		System.out.println("Player: X" + p.getXPos());
		System.out.println("PLayer: Y" + p.getYPos());
		System.out.println("Player: " + gp.characterOne.name);
		System.out.println("Player1: X" + gp.characterOne.getXPos());
		System.out.println("PLayer1: Y" + gp.characterOne.getYPos());
		System.out.println("Player: " + gp.characterTwo.name);
		System.out.println("Player2: X" + gp.characterTwo.getXPos());
		System.out.println("PLayer2: Y" + gp.characterTwo.getYPos());
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
			p.removeBullet(this);

		}
		if (hit(this, gp.characterTwo)) {

			gp.characterTwo.health = gp.characterTwo.health - 10;
			p.removeBullet(this);

		}
	}

	boolean hit(PlayerBullet pb, Player p) {
		if (p.owns(pb)) {
			return false;
		}
		return hit(p.getXPos(), p.getYPos(), p.width, p.height, pbX, pbY, 10, 10);
	}

	private boolean hit(int x, int y, int width, int height, int pbX2, int pbY2, int i, int j) {
		System.out
				.println(new Rectangle2D.Double(x, y, width, height) + " " + new Rectangle2D.Double(pbX2, pbY2, i, j));
		return new Rectangle2D.Double(x, y, width, height).contains(new Rectangle2D.Double(pbX2, pbY2, i, j));

	}

}
