import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerBullet {

	public int pbX;
	public int pbY;
	Player p;
	GamePanel gp;

	PlayerBullet(Player p) {
		gp = new GamePanel();
		this.p = p;
		pbX = p.x + 200;
		pbY = p.y + 50;
	}

	public void draw(Graphics2D g) {
		update();
		g.setColor(Color.RED);
		g.fillOval(pbX, pbY, 10, 10);

	}

	public void update() {
		System.out.println(pbX);
		pbX = pbX + gp.speed;
		if (pbX >= 1000 || pbX <= 0) {
			p.removeBullet(this);
		}

	}

}
