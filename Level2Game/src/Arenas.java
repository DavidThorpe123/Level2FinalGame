import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Arenas {
	public static int pX = 300;
	public static int pY = 700;
	public static int pX2 = 700;
	public static int pY2 = 500;
	public static int pX3 = 100;
	public static int pY3 = 500;
	public static int pX4 = 50;
	public static int pY4 = 25;
	Font f;

	public void drawArenaOne(Graphics g, int health, int health2, int ammo, int ammo2) {
		f = new Font("Arial", Font.BOLD, 30);
		g.fillRect(pX, pY, 300, 100);
		g.fillRect(pX2, pY2, 100, 100);
		g.fillRect(pX3, pY3, 100, 100);
		g.drawRect(pX4, pY4, 195, 45);
		g.setColor(Color.GREEN);
		g.fillRect(50, 25, health, 45);
		g.fillRect(750, 25, health2, 45);
		g.setColor(Color.RED);
		g.setFont(f);
		g.drawString("Player 1 Health: " + health, 35, 100);
		g.drawString("Player 1 Ammo: " + ammo, 35, 150);
		g.setColor(Color.BLUE);
		g.drawString("Player 2 Health: " + health2, 700, 100);
		g.drawString("Player 2 Ammo: " + ammo2, 700, 150);
		// System.out.println("1");

	}

}
