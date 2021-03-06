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
	Font endScreen;
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
	public boolean p1Won = true;
	public boolean p1CanJump = false;
	public boolean p2CanJump = false;
	int p1Jump = 0;
	int p2Jump = 0;

	GamePanel() {
		menuFont = new Font("Arial", Font.BOLD, 40);
		instructionFont = new Font("Arial", Font.BOLD, 40);
		characterSelect = new Font("Arial", Font.BOLD, 30);
		endScreen = new Font("Arial", Font.BOLD, 60);
		characterOne = new Player("Player.png", 50, 0, 200, 150, 5, "P1", this);
		characterTwo = new Player("Player.png", 500, 0, 200, 150, 5, "P2", this);
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
		g.drawString("Player One uses WASD to move and space to shoot. Use R to reload", 150, 300);
		g.drawString("Player Two uses IJKL to move and O to shoot. Use P to reload", 150, 500);
		g.setColor(Color.BLUE);
		g.setFont(small);
		g.drawString("Goal: Kill the other player. Also try to avoid the turrets.", 150, 700);

	}

	public void drawEndState(Graphics g) {
		g.setFont(endScreen);
		g.setColor(Color.RED);
		if (p1Won == true) {
			g.drawString("Player 1 Won!", 300, 400);
		}
		if (p1Won == false) {
			g.drawString("Player 2 Won!", 300, 400);
		}

	}

	public void drawGameState(Graphics2D g) {

		switch (arenaSelect) {
		case 0:
			a.drawArenaOne(g, characterOne.health, characterTwo.health, characterOne.ammo, characterTwo.ammo,
					(System.currentTimeMillis() - time) / 1000);
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

			characterOne.xPos = characterOne.xPos + 20;
			characterOne.setDrawLeft(false);
		}
		if (e.getKeyChar() == KeyEvent.VK_A && currentState == gameState) {

			characterOne.xPos = characterOne.xPos - 20;
			characterOne.setDrawLeft(true);

		}
		if (e.getKeyChar() == KeyEvent.VK_L && currentState == gameState) {
			characterTwo.xPos = characterTwo.xPos + 20;
			characterTwo.setDrawLeft(false);
			System.out.println("Test");
		}
		if (e.getKeyChar() == KeyEvent.VK_J && currentState == gameState) {
			characterTwo.xPos = characterTwo.xPos - 20;
			characterTwo.setDrawLeft(true);

		}
		if (e.getKeyChar() == KeyEvent.VK_W && currentState == gameState && p1CanJump == true) {
			// characterOne.yPos = characterOne.yPos - 300;
			p1Jump = 45;

		}
		if (e.getKeyChar() == KeyEvent.VK_I && currentState == gameState && p2CanJump == true) {
			// characterTwo.yPos = characterTwo.yPos - 300;
			p2Jump = 45;

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
		if (characterTwo.ammo > 0) {

			if (e.getKeyChar() == KeyEvent.VK_O && currentState == gameState) {
				characterTwo.shoot();
				characterTwo.ammo = characterTwo.ammo - 1;
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_P && currentState == gameState && characterTwo.ammo == 0) {
			if (System.currentTimeMillis() - time > 3000) {
				time = System.currentTimeMillis();
				characterTwo.ammo = 5;
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

		int gravity = 5;
		if (p1Jump > 0) {
			p1Jump--;
			characterOne.yPos = characterOne.yPos - gravity - gravity;
		}
		if (p2Jump > 0) {
			p2Jump--;
			characterTwo.yPos = characterTwo.yPos - gravity - gravity;
		}
		// Arena 1
		if (arenaSelect == 0) {
			// if (characterOne.getGravity()) {
			if (characterOne.yPos + characterOne.height >= Arenas.pY
					&& characterOne.xPos + characterOne.width >= Arenas.pX && characterOne.xPos <= Arenas.pX + 215
					&& characterOne.yPos + characterOne.height < Arenas.pY + 100) {
				characterOne.setGravityOn(false);
				p1CanJump = true;
				characterOne.yPos = Arenas.pY - characterOne.height;
			} else if (characterOne.yPos + characterOne.height >= Arenas.pY3
					&& characterOne.xPos + characterOne.width >= Arenas.pX3 && characterOne.xPos <= Arenas.pX3 + 60
					&& characterOne.yPos + characterOne.height < Arenas.pY3 + 100) {
				characterOne.setGravityOn(false);
				p1CanJump = true;
				characterOne.yPos = Arenas.pY3 - characterOne.height;

			} else {
				characterOne.setGravityOn(true);
				p1CanJump = false;
				characterOne.yPos = (characterOne.yPos + gravity);
			}
			// }
			// if (characterTwo.getGravity()) {
			if (characterTwo.yPos + characterTwo.height >= Arenas.pY
					&& characterTwo.xPos + characterTwo.width >= Arenas.pX && characterTwo.xPos <= Arenas.pX + 215
					&& characterTwo.yPos + characterTwo.height < Arenas.pY + 100) {
				characterTwo.setGravityOn(false);
				p2CanJump = true;
				characterTwo.yPos = Arenas.pY - characterTwo.height;
			} else if (characterTwo.yPos + characterTwo.height >= Arenas.pY3
					&& characterTwo.xPos + characterTwo.width >= Arenas.pX3 && characterTwo.xPos <= Arenas.pX3 + 60
					&& characterTwo.yPos + characterTwo.height < Arenas.pY3 + 100) {
				characterTwo.setGravityOn(false);
				p2CanJump = true;
				characterTwo.yPos = Arenas.pY3 - characterTwo.height;
			} else {
				characterTwo.setGravityOn(true);
				p2CanJump = false;
				characterTwo.yPos = (characterTwo.yPos + gravity);
			}
			// }
			// System.out.println(hit);

			// else {
			//
			// characterOne.setGravityOn(true);
			// characterTwo.setGravityOn(true);
			// }

			if (turretOne.b.bX < characterOne.xPos + 175 && turretOne.b.bY > characterOne.yPos
					&& turretOne.b.bY < characterOne.yPos + 150 && turretOne.b.active) {
				characterOne.health = characterOne.health - 10;
				turretOne.b.deactivate();

			}
			if (turretOne.b.bX < characterTwo.xPos + 175 && turretOne.b.bY > characterTwo.yPos
					&& turretOne.b.bY < characterTwo.yPos + 150 && turretOne.b.active) {

				characterTwo.health = characterTwo.health - 10;
				turretOne.b.deactivate();

			}

			// Arena 1
		}
		if (characterOne.yPos > 1000) {
			characterOne.yPos = 0;
			characterOne.health = characterOne.health - 5;
		}

		if (characterOne.health <= 0) {
			currentState = endState;
		}
		if (characterTwo.yPos > 1000) {
			characterTwo.yPos = 0;
			characterTwo.health = characterTwo.health - 5;
		}
		if (characterTwo.health <= 0) {
			currentState = endState;
		}
		if (characterOne.health <= 0 && characterOne.health < characterTwo.health) {
			p1Won = false;
			currentState = endState;
		}
		if (characterTwo.health <= 0 && characterTwo.health < characterOne.health) {
			p1Won = true;
			currentState = endState;
		}
	}

}