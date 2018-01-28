public class Turret {
	public static int tX = 50;
	public static int tY = 50;
	public static int tHP = 100;

	Turret(int tX, int tY, int tHP) {
		this.tX = tX;
		this.tY = tY;
		this.tHP = tHP;
	}

	public void shoot() {
		Bullet b = new Bullet();
		b.update();
	}

}
