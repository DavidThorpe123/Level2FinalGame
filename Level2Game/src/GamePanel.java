import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	int arenaSelect = 0;
	Player characterOne;
	Player characterTwo;
	public int speed = 5;
	Turret turretOne;
	long time = System.currentTimeMillis();
	public boolean hit = false;

	GamePanel() {
		menuFont = new Font("Arial", Font.BOLD, 40);
		instructionFont = new Font("Arial", Font.BOLD, 40);
		characterSelect = new Font("Arial", Font.BOLD, 30);
		characterOne = new Player("Player.png", 50, 0, 200, 150, 5);
		characterTwo = new Player("Player.png", 500, 0, 200, 150, 5);
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
			a.drawArenaOne(g, characterOne.health, characterTwo.health, characterOne.ammo, characterTwo.ammo);
			Turret.tX = 700;
			Turret.tY = 400;
			break;
		}
		if (System.currentTimeMillis() - time > 5000) {
			time = System.currentTimeMillis();
			turretOne.fire();

		}
		characterOne.draw(g);
		characterTwo.draw(g);
		turretOne.draw(g);

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		if (e.getKeyChar() == KeyEvent.VK_I && currentState == menuState) {
			isininstruction = true;
			currentState = instructionState;
		}
		if (e.getKeyChar() == KeyEvent.VK_B && isininstruction == true) {
			currentState = menuState;
		}

		if (e.getKeyChar() == KeyEvent.VK_D && currentState == gameState) {

			characterOne.x = characterOne.x + 20;
			characterOne.setDrawLeft(false);
		}
		if (e.getKeyChar() == KeyEvent.VK_A && currentState == gameState) {

			characterOne.x = characterOne.x - 20;
			characterOne.setDrawLeft(true);

		}
		if (e.getKeyChar() == KeyEvent.VK_K && currentState == gameState) {
			characterTwo.x = characterTwo.x + 20;
			characterTwo.setDrawLeft(false);
			System.out.println("Test");
		}
		if (e.getKeyChar() == KeyEvent.VK_J && currentState == gameState) {
			characterTwo.x = characterTwo.x - 20;
			characterTwo.setDrawLeft(true);

		}
		if (e.getKeyChar() == KeyEvent.VK_W && currentState == gameState) {
			characterOne.y = characterOne.y - 200;

		}
		if (e.getKeyChar() == KeyEvent.VK_S && currentState == menuState) {
			currentState = gameState;
		}
		if (e.getKeyChar() == KeyEvent.VK_R && currentState == endState) {
			currentState = menuState;
		}
		if (characterOne.ammo > 0) {

			if (e.getKeyChar() == KeyEvent.VK_SPACE && currentState == gameState) {
				characterOne.shoot();
				characterOne.ammo = characterOne.ammo - 1;
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_R && currentState == gameState && characterOne.ammo == 0) {
			if (System.currentTimeMillis() - time > 3000) {
				time = System.currentTimeMillis();
				characterOne.ammo = 5;
			}
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
		characterOne.y = (characterOne.y + gravity);
		characterTwo.y = (characterTwo.y + gravity);
		// Arena 1
		if (arenaSelect == 0) {
			System.out.println(hit);

			if (characterOne.y + characterOne.height >= Arenas.pY && characterOne.x + characterOne.width >= Arenas.pX
					&& characterOne.x <= Arenas.pX + 150 && characterOne.y + characterOne.height < Arenas.pY + 100) {

				characterOne.y = Arenas.pY - characterOne.height;
			}
			if (characterTwo.y + characterTwo.height >= Arenas.pY && characterTwo.x + characterTwo.width >= Arenas.pX
					&& characterTwo.x <= Arenas.pX + 150 && characterTwo.y + characterTwo.height < Arenas.pY + 100) {

				characterTwo.y = Arenas.pY - characterTwo.height;
			}
			if (characterOne.y + characterOne.height >= Arenas.pY3 && characterOne.x + characterOne.width >= Arenas.pX3
					&& characterOne.x <= Arenas.pX3 + 60 && characterOne.y + characterOne.height < Arenas.pY3 + 100) {

				characterOne.y = Arenas.pY3 - characterOne.height;
			}
			if (characterTwo.y + characterTwo.height >= Arenas.pY3 && characterTwo.x + characterTwo.width >= Arenas.pX3
					&& characterTwo.x <= Arenas.pX3 + 60 && characterTwo.y + characterTwo.height < Arenas.pY3 + 100) {

				characterTwo.y = Arenas.pY3 - characterTwo.height;
			}
			System.out.println("Bullet X: " + turretOne.b.bX);
			System.out.println("Bullet Y: " + turretOne.b.bY);
			if (turretOne.b.bX < characterOne.x + 175 && turretOne.b.bY > characterOne.y
					&& turretOne.b.bY < characterOne.y + 150 && turretOne.b.active) {

				characterOne.health = characterOne.health - 10;
				turretOne.b.deactivate();

			}

			// Arena 1
		}
		if (characterOne.y > 1000) {
			characterOne.y = 0;
			characterOne.health = characterOne.health - 5;
		}

		if (characterOne.health <= 0) {
			currentState = endState;
		}
		if (characterTwo.y > 1000) {
			characterTwo.y = 0;
			characterTwo.health = characterTwo.health - 5;
		}
		if (characterTwo.health <= 0) {
			currentState = endState;
		}

	}

}