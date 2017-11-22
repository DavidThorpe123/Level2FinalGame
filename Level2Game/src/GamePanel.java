import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	public int currentState = 1;
	public final int menuState = 1;
	public final int gameState = 2;
	public final int instructionState = 3;
	public final int characterSelectState = 4;
	public final int endState = 5;
	Font menuFont;
	Font instructionFont;
	Font characterSelect;
	Graphics g;
	Timer t;

	GamePanel() {
		menuFont = new Font("Arial", Font.BOLD, 60);
		instructionFont = new Font("Arial", Font.BOLD, 40);
		characterSelect = new Font("Arial", Font.BOLD, 30);
		t = new Timer(1000 / 60, this);
	}

	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
		}
		if (currentState == instructionState) {
			drawInstructionState(g);
		}

	}

	public void drawMenuState(Graphics g) {
		g.setFont(menuFont);
		g.drawString("Welcome to my Game!", 200, 400);
		g.setFont(instructionFont);
		g.drawString("Press I to see the Instructions", 200, 800);
		g.setFont(characterSelect);
		g.drawString("Press C to Select your Character!", 200, 600);

	}

	public void drawInstructionState(Graphics g) {
		g.setFont(menuFont);
		g.drawString("Player One uses WASD to move.", 300, 600);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Test" + e.getKeyChar());
		if (e.getKeyChar() == KeyEvent.VK_I) {
			currentState = instructionState;
			System.out.println("Test");
		}
		if (e.getKeyChar() == KeyEvent.VK_C) {
			currentState = characterSelectState;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}