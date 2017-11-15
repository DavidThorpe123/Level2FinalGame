import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
public int currentState = 0;
public final int menuState = 1;
public final int gameState = 2;
public final int endState = 3;
Font menuFont;
Font instructionFont;
Font characterSelect;
PlayerOne po;
Graphics g;
GamePanel() {
po = new PlayerOne(g, 10, 10, 10, 10);
menuFont = new Font("Arial", Font.BOLD, 60);
instructionFont = new Font("Arial", Font.BOLD, 40);
characterSelect = new Font("Arial", Font.BOLD, 30);
}
public void paintComponent(Graphics g) {
	if (currentState == gameState) {
		drawGameState(g);
	}
}

public void drawGameState(Graphics g) {
g.setFont(instructionFont);
g.drawString("Welcome to my Game!", 200, 400);
}
}