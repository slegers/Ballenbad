package deel3.domain;

import java.awt.Color;

public  class BewegendeCirkel extends Cirkel{
	private int snelheid,interneKlok;
	private IBaan baan;
	private BallenVeld ballenVeld;
	
	public BewegendeCirkel(Punt middelPunt, int radius, Color kleur, int snelheid, IBaan baan,BallenVeld ballenVeld){
		super(middelPunt, radius, kleur);
		setBaan(baan);
		this.ballenVeld = ballenVeld;
		this.snelheid=snelheid;
		interneKlok=0;
	}	
	
	public void setBaan(IBaan baan){
		this.baan=baan;
	}
	
	public void setSnelheid(int snelheid){
		this.snelheid = snelheid;
	}
	
	public int getSnelheid(){
		return snelheid;
	}
	
	public void beweeg(){
		//de waarde van de interne klok bepaalt of de bal binnen de tread van het animatiepanel mag bewegen
		//bal met snelheid 1 zal om de 4 milliseconden bewegen, ...
		//bal moet in ballenveld bewegen (indien rand raakt -> verander richting
		interneKlok++;
		if (interneKlok >= snelheid){
			if (ballenVeld.raaktRand(this)){
				baan.veranderRichting();
			}
			interneKlok = 0;
			this.getMiddelPunt().setX(baan.getX());
			this.getMiddelPunt().setY(baan.getY());
		}	
	}	
}	
	
	
	
		
		
