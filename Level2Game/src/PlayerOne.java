import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerOne implements KeyListener {
PlayerOne(Graphics g, int x, int y, int playerwidth, int playerheight) {
drawPlayerOne(g, x, y, playerwidth, playerheight);
}
public void drawPlayerOne(Graphics g, int x, int y, int playeronewidth, int playeroneheight) {
g.drawRect(x, y, playeronewidth, playeroneheight);	
}
public void updatePlayerOne() {
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode() == KeyEvent.VK_W) {
		System.out.println("Test");
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
