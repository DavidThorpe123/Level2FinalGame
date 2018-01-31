import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	public final int endState = 4;
	int squareX = 390;
	Font menuFont;
	Font instructionFont;
	Font characterSelect;
	Font small;
	Graphics g;
	Timer t;
	Arenas a;
	boolean isininstruction = false;
	int arenaSelect = new Random().nextInt(3);
	PlayerOne characterOne;
	Turret turretOne;

	long time = System.currentTimeMillis();

	GamePanel() {
		menuFont = new Font("Arial", Font.BOLD, 40);
		instructionFont = new Font("Arial", Font.BOLD, 40);
		characterSelect = new Font("Arial", Font.BOLD, 30);
		characterOne = new PlayerOne(PlayerOne.x, PlayerOne.y, PlayerOne.width, PlayerOne.height);
		small = new Font("Arial", Font.BOLD, 20);
		turretOne = new Turret(500, 500, 100);

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
		} else if (currentState == gameState) {
			isininstruction = false;
			drawGameState((Graphics2D) g);
		} else if (currentState == endState) {
			isininstruction = false;
			drawEndState(g);
		}
	}

	public void drawMenuState(Graphics g) {

		g.setFont(menuFont);
		g.setColor(Color.BLUE);
		g.drawString("Welcome to my Game!", 275, 200);
		g.setColor(Color.BLACK);
		g.setFont(instructionFont);
		g.drawString("Press I to see the Instructions", 200, 400);
		g.setColor(Color.RED);
		g.setFont(characterSelect);
		g.drawString("Press S to Start the Game!", 300, 500);

	}

	public void drawInstructionState(Graphics g) {
		g.setFont(menuFont);
		g.drawString("Player One uses WASD to move.", 150, 300);
		g.setColor(Color.BLUE);
		g.setFont(small);
		g.drawString("Goal: Kill as many turrets as you can before the time is up or lose your health", 150, 500);

	}

	public void drawEndState(Graphics g) {
		g.setFont(menuFont);
		g.setColor(Color.RED);
		g.drawString("You Lost! You killed", 200, 400);
		g.drawString("Press R to Retry!", 200, 700);
	}

	public void drawGameState(Graphics2D g) {

		switch (arenaSelect) {
		case 0:
			a.drawArenaOne(g);
			Turret.tX = 700;
			Turret.tY = 475;
			break;
		case 1:
			a.drawArenaTwo(g);
			break;
		case 2:
			a.drawArenaThree(g);
			break;
		}
		if (System.currentTimeMillis() - time > 5000) {
			time = System.currentTimeMillis();
			turretOne.fire();

		}
		characterOne.draw(g);
		turretOne.draw(g);

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_I && currentState == menuState) {
			isininstruction = true;
			currentState = instructionState;
		}
		if (e.getKeyChar() == KeyEvent.VK_B && isininstruction == true) {
			currentState = menuState;
		}

		if (e.getKeyChar() == KeyEvent.VK_D && currentState == gameState) {
			PlayerOne.x = PlayerOne.x + 20;
			characterOne.setDrawLeft(false);
		}
		if (e.getKeyChar() == KeyEvent.VK_A && currentState == gameState) {
			PlayerOne.x = PlayerOne.x - 20;
			characterOne.setDrawLeft(true);

		}
		if (e.getKeyChar() == KeyEvent.VK_S && currentState == menuState) {
			currentState = gameState;
		}
		if (e.getKeyChar() == KeyEvent.VK_R && currentState == endState) {
			currentState = menuState;
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
		int ac = 5;
		int gravity = 1;
		gravity = gravity + ac;
		PlayerOne.y = (PlayerOne.y + gravity);
		// Arena 1
		if (arenaSelect == 0) {
			// System.out.println(Arenas.pX + " " + Arenas.pY);
			// System.out.println(PlayerOne.x + " " + PlayerOne.y);
			if (PlayerOne.y + PlayerOne.height >= Arenas.pY && PlayerOne.x + PlayerOne.width >= Arenas.pX
					&& PlayerOne.x <= Arenas.pX + 175 && PlayerOne.y + PlayerOne.height < Arenas.pY + 100) {
				// ac = 0;
				// gravity = 0;
				PlayerOne.y = Arenas.pY - PlayerOne.height;
			}

			// Arena 1
		}
		if (PlayerOne.y > 1000) {
			PlayerOne.y = 0;
		}
		if (PlayerOne.health <= 0) {
			currentState = endState;
		}

	}

}