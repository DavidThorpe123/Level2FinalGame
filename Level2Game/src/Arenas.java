import java.awt.Graphics;

public class Arenas {
	public void drawArenaOne(Graphics g) {
		g.fillRect(400, 700, 300, 100);
	}

	public void drawArenaTwo(Graphics g) {
		g.fillRect(100, 700, 300, 100);
		g.fillRect(600, 700, 300, 100);
	}

	public void drawArenaThree(Graphics g) {
		g.fillRect(100, 700, 200, 100);
	}
}
