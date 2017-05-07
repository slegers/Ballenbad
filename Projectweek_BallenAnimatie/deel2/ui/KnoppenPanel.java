package deel2.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import deel2.domain.BallenVeld;

public class KnoppenPanel extends JPanel{
	private JButton knop;

	
	public KnoppenPanel(BallenVeld ballenVeld){
		this.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));
		this.setLayout(new GridLayout(4,1));
		knop = new JButton("Herstart animatie");
		knop.setFont(new Font("Sans Serif", Font.PLAIN, 16));
				   
		this.add(knop);
		this.add(new JLabel("Om bal toe tevoegen: "));
		this.add(new JLabel("Klik met muis in ballenveld"));
		
	}

}
