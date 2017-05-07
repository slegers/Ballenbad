package deel2.domain;

public class VertikaleBaan implements IBaan {
	private boolean naarOnder;
	private int x;
	private int y;
	
	public VertikaleBaan(int x, int y){
		this.x = x;
		this.y = y;
		naarOnder = true;
	}
	
	@Override
	public int getY() {
		if (naarOnder) y = y+2; else y = y -2;
		return y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void veranderRichting() {
		naarOnder = !naarOnder;		
	}
}
