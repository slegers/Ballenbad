package deel1.ui;
import java.awt.Color;

import deel1.domain.BallenVeld;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AnimatiePanel extends JPanel{
	private final BallenVeld ballenVeld;
	public AnimatiePanel(BallenVeld ballenVeld){
		this.ballenVeld = ballenVeld;
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));
	}
	
	
}
