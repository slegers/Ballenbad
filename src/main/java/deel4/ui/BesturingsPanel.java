package deel4.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import deel4.domain.BallenVeld;

public class BesturingsPanel extends JPanel{
	private final static int MIN_AANTAL_BALPANELS=4;
	private BallenVeld ballenVeld;
	
	public BesturingsPanel(BallenVeld ballenVeld){
		this.ballenVeld = ballenVeld;
		this.setBackground(Color.YELLOW);
		this.setPreferredSize(new Dimension(200,200));
		//het besturingspanel voorziet minimum 4 subpanels of indien meer ballen evenveel subpanelsalser ballen zijn
		//+extra panel voor knop en info
		int aantalPanels= Math.max(MIN_AANTAL_BALPANELS, ballenVeld.getMaxAantalBallen())+1;
		this.setLayout(new GridLayout(aantalPanels,1));	
		//voeg knoppanel toe
		this.add(new KnoppenPanel(ballenVeld));
		//voeg besturingspanel voor iedere bal toe
		for (int i = 0; i < ballenVeld.getMaxAantalBallen();i++){
			Color achtergrondKleur = ballenVeld.getBalKleur(i);
			int balNr = i+1;
			this.add(new BesturingsPanelBal(ballenVeld,achtergrondKleur,balNr));
		}	
	}

}
