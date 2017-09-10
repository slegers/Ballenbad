package deel4.domain;

import java.awt.Color;
import java.util.ArrayList;

public class BallenVeld {
	//hoeveel ballen laten we maximaal toe in animatie
	private final static int MAX_AANTAL_BALLEN = 7;
	private final static Color ACHTERGROND_KLEUR = Color.LIGHT_GRAY;
	//kleuren van de ballen
	private final static Color[] BAL_KLEUREN = {Color.BLUE,Color.GREEN,Color.RED,Color.CYAN,Color.MAGENTA,Color.BLACK,Color.DARK_GRAY};
	private  ArrayList <Cirkel> cirkels;
	private int maxX, maxY;
	
	public BallenVeld(){
		cirkels = new ArrayList<Cirkel>();		
	}
	
	public void setMaxX(int maxX){
		this.maxX = maxX;
	}
	
	public void setMaxY(int maxY){
		this.maxY = maxY;
	}
	  
	public void voegCirkelToe(int x, int y){
		//als er nog een bal kunnen toevoegen voegen we default een bal toe met:
		//horizontale baan
		//snelheid 1
		//eerste vrije kleur uit BAL_KLEUREN array
		if (cirkels.size() < getMaxAantalBallen()){
			IBaan baan = new HorizontaleBaan(x,y);
			Cirkel cirkel = new BewegendeCirkel(new  Punt(x,y),30,BAL_KLEUREN[cirkels.size()],1,baan,this);
			if (!raaktRand(cirkel)){
				cirkels.add(cirkel);
			}
		}
	}
    public void voegCirkelToeViaKeyBoard(){
        //als er nog een bal kunnen toevoegen voegen we default een bal toe met:
        //horizontale baan
        //snelheid 1
        //eerste vrije kleur uit BAL_KLEUREN array
        if (cirkels.size() < getMaxAantalBallen()){
            IBaan baan = new HorizontaleBaan(200,200);
            Cirkel cirkel = new BewegendeCirkel(new  Punt(200,200),30,BAL_KLEUREN[cirkels.size()],1,baan,this);
            if (!raaktRand(cirkel)){
                cirkels.add(cirkel);
            }
        }
    }
	
	public ArrayList<Cirkel> getCirkels(){
		return cirkels;
	}
	
	public Color getAchtergrondKleur(){
		return ACHTERGROND_KLEUR;
	}
	
	public Color getBalKleur(int volgnr){
		Color balKleur = Color.WHITE;
		if (volgnr < BAL_KLEUREN.length){
			balKleur = BAL_KLEUREN[volgnr];
		}
		return balKleur;
	}
	
	
	public int getMaxAantalBallen(){
		return Math.min(BAL_KLEUREN.length,MAX_AANTAL_BALLEN);		
	}
	
	public int getAantalMogelijkeBallen(){
		return getMaxAantalBallen() - cirkels.size();
	}
	
	public Cirkel getCirkel(int volgNr){
		return cirkels.get(volgNr);
	}

	public boolean raaktRand(Cirkel cirkel){
		return cirkel.getMiddelPunt().getX() - cirkel.getRadius() <= 0 || cirkel.getMiddelPunt().getX() + cirkel.getRadius() >= maxX ||
			   cirkel.getMiddelPunt().getY() - cirkel.getRadius() <= 0 || cirkel.getMiddelPunt().getY() + cirkel.getRadius() >= maxY;	
	}
		
	public void init(){
		cirkels.clear();
	}
}
