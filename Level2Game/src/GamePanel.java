import java.awt.Color;
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
	boolean isininstruction = false;

	GamePanel() {
		menuFont = new Font("Arial", Font.BOLD, 60);
		instructionFont = new Font("Arial", Font.BOLD, 40);
		characterSelect = new Font("Arial", Font.BOLD, 30);
		t = new Timer(1000 / 60, this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
			isininstruction = false;
		} else if (currentState == instructionState) {
			isininstruction = true;
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
		g.setColor(Color.RED);
		g.drawString("Player One uses WASD to move.", 300, 300);
		g.drawString("Player Two Uses Arrow Keys to move.", 200, 600);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stubH
		if (e.getKeyChar() == KeyEvent.VK_I) {
			isininstruction = true;
			currentState = instructionState;
		}
		if (e.getKeyChar() == KeyEvent.VK_B && isininstruction == true) {
			currentState = menuState;
		}
		if (e.getKeyChar() == KeyEvent.VK_C) {
			isininstruction = false;
			System.out.println("Changing");
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
		repaint();

	}
}