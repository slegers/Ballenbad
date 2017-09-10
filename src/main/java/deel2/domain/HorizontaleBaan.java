package deel2.domain;

public class HorizontaleBaan implements IBaan {

	private boolean naarRechts;
	private int x;
	private int y;
	
	public HorizontaleBaan(int x, int y){
		this.x = x;
		this.y = y;
		naarRechts = true;
	}
	
	@Override
	public int getX() {
		if (naarRechts) x = x+2; else x = x -2;
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void veranderRichting() {
		naarRechts = !naarRechts;		
	}

}
