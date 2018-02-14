import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerBullet {

	public int pbX;
	public int pbY;
	Player p;

	PlayerBullet(Player p) {
		this.p = p;
		pbX = p.x;
		pbY = p.y;
	}

	public void draw(Graphics2D g) {
		update();
		g.setColor(Color.RED);
		g.fillOval(pbX, pbY, 10, 10);

	}

	public void update() {
		System.out.println(pbX);
		pbX = pbX + 5;
		if (pbX >= 1000 || pbX <= 0) {
			p.removeBullet(this);
		}
	}

}