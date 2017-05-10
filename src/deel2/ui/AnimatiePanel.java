package deel2.ui;
import java.awt.Color;

import deel2.domain.BallenVeld;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AnimatiePanel extends JPanel{
	private final BallenVeld ballenVeld;
	public AnimatiePanel(BallenVeld ballenVeld){
		this.ballenVeld = ballenVeld;
		this.setBackground(ballenVeld.getAchtergrondKleur());
		this.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));
	}
	
	
}
