import java.awt.Color;
import java.awt.Graphics;

public class Arenas {
	public void drawArenaOne(Graphics g) {
		g.fillRect(300, 700, 300, 100);
		g.fillRect(700, 500, 100, 100);
		g.fillRect(100, 500, 100, 100);
		g.drawRect(50, 25, 195, 45);
		g.drawRect(700, 25, 195, 45);
		g.setColor(Color.GREEN);
		g.fillRect(50, 25, PlayerOne.health, 45);
		g.fillRect(700, 25, PlayerOne.health, 45);
	}

	public void drawArenaTwo(Graphics g) {
		g.fillRect(100, 700, 300, 100);
		g.fillRect(600, 700, 300, 100);
		g.drawRect(50, 25, 195, 45);
		g.drawRect(700, 25, 195, 45);
		g.setColor(Color.GREEN);
		g.fillRect(50, 25, PlayerOne.health, 45);
		g.fillRect(700, 25, PlayerOne.health, 45);
	}

	public void drawArenaThree(Graphics g) {
		g.fillRect(100, 700, 200, 100);
		g.drawRect(50, 25, 195, 45);
		g.drawRect(700, 25, 195, 45);
		g.setColor(Color.GREEN);
		g.fillRect(50, 25, PlayerOne.health, 45);
		g.fillRect(700, 25, PlayerOne.health, 45);
	}
}
