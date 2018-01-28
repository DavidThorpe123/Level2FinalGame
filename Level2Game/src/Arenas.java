import java.awt.Color;
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
	public static int pX5 = 700;
	public static int pY5 = 25;

	public void drawArenaOne(Graphics g) {
		g.fillRect(pX, pY, 300, 100);
		g.fillRect(pX2, pY2, 100, 100);
		g.fillRect(pX3, pY3, 100, 100);
		g.drawRect(pX4, pY4, 195, 45);
		g.setColor(Color.GREEN);
		g.fillRect(50, 25, PlayerOne.health, 45);
		g.drawString("Player 1 Health", 50, 35);
		System.out.println("1");
	}

	public void drawArenaTwo(Graphics g) {
		g.fillRect(100, 700, 300, 100);
		g.fillRect(600, 700, 300, 100);
		g.drawRect(50, 25, 195, 45);

		g.setColor(Color.GREEN);
		g.fillRect(50, 25, PlayerOne.health, 45);
		g.drawString("Player 1 Health", 50, 35);
		System.out.println("2");
	}

	public void drawArenaThree(Graphics g) {
		g.fillRect(100, 700, 200, 100);
		g.drawRect(50, 25, 195, 45);

		g.setColor(Color.GREEN);
		g.fillRect(50, 25, PlayerOne.health, 45);
		g.drawString("Player 1 Health", 50, 35);
		System.out.println("3");
	}
}
