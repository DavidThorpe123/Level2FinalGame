import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	public int currentState = 1;
	public final int menuState = 1;
	public final int gameState = 2;
	public final int instructionState = 3;
	public final int characterSelectState = 4;
	public final int endState = 5;
	public int playeroneSelect = 1;
	public int playertwoSelect = 1;
	int squareX = 390;
	Font menuFont;
	Font instructionFont;
	Font characterSelect;
	Graphics g;
	Timer t;
	Arenas a;
	boolean isininstruction = false;
	int arenaSelect = new Random().nextInt(3);

	GamePanel() {
		menuFont = new Font("Arial", Font.BOLD, 60);
		instructionFont = new Font("Arial", Font.BOLD, 40);
		characterSelect = new Font("Arial", Font.BOLD, 30);
		t = new Timer(1000 / 60, this);
		a = new Arenas();
		t.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
			isininstruction = false;
		} else if (currentState == instructionState) {
			isininstruction = true;
			drawInstructionState(g);
		} else if (currentState == characterSelectState) {
			isininstruction = false;
			drawCharacterSelectState(g);
		} else if (currentState == gameState) {
			switch (arenaSelect) {
			case 0:
				a.drawArenaOne(g);
				break;
			case 1:
				break;
			case 2:
				break;
			}
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

	public void drawCharacterSelectState(Graphics g) {
		g.drawRect(400, 500, 200, 200);
		g.drawRect(800, 500, 200, 200);
		g.drawRect(450, 550, 100, 100);
		g.drawOval(850, 550, 100, 100);
		System.out.println(playeroneSelect);
		if (playeroneSelect == 1) {
			squareX = 390;
			g.drawRect(squareX, 490, 220, 220);
		}
		if (playeroneSelect == 2) {
			squareX = 790;
			g.drawRect(squareX, 490, 220, 220);
		}
		if (playeroneSelect < 1) {
			playeroneSelect = 2;
		}
		if (playeroneSelect > 2) {
			playeroneSelect = 1;
		}

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
		if (e.getKeyChar() == KeyEvent.VK_ENTER && currentState == characterSelectState) {
			currentState = gameState;
		}
		if (e.getKeyChar() == KeyEvent.VK_D && currentState == characterSelectState) {
			playeroneSelect++;
		}
		if (e.getKeyChar() == KeyEvent.VK_A && currentState == characterSelectState) {
			playeroneSelect--;
		}
		if (e.getKeyChar() == KeyEvent.VK_RIGHT && currentState == characterSelectState) {
			playertwoSelect++;
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