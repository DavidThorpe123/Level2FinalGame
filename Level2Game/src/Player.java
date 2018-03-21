import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Player extends JPanel {
	// Image characterOneImage;
	public int xPos;
	public int yPos;
	public int c2X;
	public int c2Y;
	public int b2X = xPos;
	public int b2Y = yPos;
	public int width = 150;
	public int height = 75;
	public int health = 195;
	public int ammo = 5;
	boolean gravityOn = true;
	boolean drawLeft = false;
	String name;
	GamePanel gp;

	List<PlayerBullet> bullets;

	// = new ImageIcon("Untitled-1.gif");
	public Image i = Toolkit.getDefaultToolkit().createImage("Player.png");

	public Player(String img, int x, int y, int width, int height, int ammo, String name, GamePanel gamePanel) {
		this.gp = gamePanel;
		this.name = name;
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.ammo = ammo;

		bullets = new ArrayList<>();
		// characterOneImage = Toolkit.getDefaultToolkit().createImage("test.png");
		i = Toolkit.getDefaultToolkit().createImage(img);
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setDrawLeft(boolean drawLeft) {
		this.drawLeft = drawLeft;
	}

	public void setGravityOn(boolean gravityOn) {
		this.gravityOn = gravityOn;
	}

	public boolean getGravity() {
		return gravityOn;
	}

	public void draw(Graphics2D g) {

		if (drawLeft) {
			g.drawImage(i, xPos + width, yPos, -width, height, this);
		} else {
			g.drawImage(i, xPos, yPos, width, height, this);
		}

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);

		}

	}

	public GamePanel getGamePanel() {
		return gp;
	}

	public void shoot() {

		PlayerBullet pb = new PlayerBullet(this);
		bullets.add(pb);
	}

	public void removeBullet(PlayerBullet playerBullet) {
		bullets.remove(playerBullet);
	}

	public boolean owns(PlayerBullet pb) {
		return bullets.contains(pb);
	}

}
