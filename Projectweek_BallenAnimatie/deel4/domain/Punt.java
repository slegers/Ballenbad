package deel4.domain;

public class Punt {

	private int x;
	private int y;

	public Punt(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String toString() {
		return getX() + ", " + getY();
	}

	public boolean equals(Punt punt) {
		boolean gelijk = false;
		if (this.getX() == punt.getX() && this.getY() == punt.getY()) {
			gelijk = true;
		}
		return gelijk;
	}
	
	public double berekenAfstand(Punt punt){
		int afstandX = punt.getX()-getX();
		int afstandY = punt.getY()-getY();
		double x2 = Math.pow(afstandX, 2.0);
		double y2 = Math.pow(afstandY, 2.0);
		double afstand = Math.sqrt(x2+y2);
		return afstand;
	}

}
