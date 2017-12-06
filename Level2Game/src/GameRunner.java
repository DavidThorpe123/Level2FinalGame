import javax.swing.JFrame;

public class GameRunner {

	JFrame frame;
	GamePanel gp;

	public static void main(String[] args) {
		GameRunner gr = new GameRunner();
	}

	GameRunner() {
		frame = new JFrame();
		gp = new GamePanel();
		frame.addKeyListener(gp);
		frame.add(gp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
