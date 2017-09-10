package deel2.domain;

import java.awt.Color;
import java.awt.Graphics;

public class Cirkel extends Vorm {
	
	private Punt middelPunt;
	private int radius;
	private Color kleur;

	public Cirkel(Punt middelpunt, int radius, Color kleur)  throws IllegalArgumentException{
		setMiddelPunt(middelpunt);
		setRadius(radius);
		setKleur(kleur);
	}

	public Punt getMiddelPunt() {
		return middelPunt;
	}

	public void setMiddelPunt(Punt middelPunt) throws IllegalArgumentException{
		if(middelPunt == null){
			throw new IllegalArgumentException("Ongeldig middelpunt");
		}
		this.middelPunt = middelPunt;
	}
	
	public Color getKleur() {
		return kleur;
	}

	public void setKleur(Color kleur) throws IllegalArgumentException{
		if(kleur == null){
			throw new IllegalArgumentException("Ongeldige kleur");
		}
		this.kleur = kleur;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws IllegalArgumentException{
		if(radius <= 0)
			throw new IllegalArgumentException("straal moet > 0");
		this.radius = radius;
	}

	@Override
	public boolean equals(Object object){
		boolean gelijk = false;
		if(object instanceof Cirkel){
			Cirkel cirkel = (Cirkel)(object);
			if(	super.equals(cirkel) &&
					cirkel.getMiddelPunt().equals(this.getMiddelPunt()) &&
					cirkel.getRadius() == this.getRadius()){
				gelijk = true;
			}
		}
		return gelijk;
	}
	
	@Override
	public String toString(){
		return "Cirkel: middelPunt: "+this.getMiddelPunt()+" - straal: "+this.getRadius()+super.toString();
	}
	
	//extra voor story09
	@Override
	public Omhullende getOmhullende() {
		Punt positieLinksBoven = new Punt(getMiddelPunt().getX()-getRadius(),
				  getMiddelPunt().getY()-getRadius());
		return new Omhullende(positieLinksBoven, 2*getRadius(), 2*getRadius());
	}
	
	@Override
	public void teken(Graphics graphics) {
		if(isZichtbaar()){
			graphics.setColor(kleur);
			graphics.fillOval(getMiddelPunt().getX()-getRadius(), 
					getMiddelPunt().getY()-getRadius(), 2*getRadius(), 2*getRadius());
		}
	}
	
	public void beweeg(){
		this.getMiddelPunt().setX(this.getMiddelPunt().getX()+1);
	}

}
